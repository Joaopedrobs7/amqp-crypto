import pika
import uuid

# Access the CLODUAMQP_URL environment variable and parse it (fallback to localhost)
url = 'amqps://ubiteixu:GGQ8zclQ4tudrTJB3KE6E6TzkabD2dyt@jackal.rmq.cloudamqp.com/ubiteixu'
params = pika.URLParameters(url)
params.heartbeat = 50000;
connection = pika.BlockingConnection(params)
channel = connection.channel()# start a channel

#definindo rotas
routingkey_baixo = 'cripto.baixo'
routingkey_medio = 'cripto.medio'
routingkey_alto = 'cripto.alto'
routingkey_backend = 'cripto.#'
routingkey = ''
queue = ''

consumer_type = int(input('1-CONSUMIDOR\n2-BACKEND\n: '))

#QUEUE E ROUTING KEY
if (consumer_type == 1):
    client_type = int(input('1-BAIXO RISCO\n2-MEDIO RISCO\n3-ALTO RISCO\n: '))
    match(client_type):
        case 1:
            queue = "fila1-" + str(uuid.uuid4())[:4]
            routingkey = routingkey_baixo
        case 2:
            queue = "fila2-" + str(uuid.uuid4())[:4]
            routingkey = routingkey_medio
        case 3:
            queue = "fila3-" + str(uuid.uuid4())[:4]
            routingkey = routingkey_alto

elif (consumer_type == 2):
    queue = 'backend-' + str(uuid.uuid4())[:4]
    routingkey = routingkey_backend

# Declarando Queues
channel.queue_declare(queue=queue,exclusive=True)

#bind
channel.queue_bind(exchange='topic-exchange',queue=queue,routing_key= routingkey)

def callback(ch, method, properties, body):
    print(body)
channel.basic_consume(queue = queue,on_message_callback = callback, auto_ack = True)

channel.start_consuming()