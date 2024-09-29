# consume.py
import pika

# URL de conexão com o CloudAMQP
url = 'amqps://ubiteixu:GGQ8zclQ4tudrTJB3KE6E6TzkabD2dyt@jackal.rmq.cloudamqp.com/ubiteixu'
params = pika.URLParameters(url)
params.heartbeat = 50000;
connection = pika.BlockingConnection(params)
channel = connection.channel()  # Inicia um canal

# Declarando a fila que irá coletar todas as mensagens
channel.queue_declare(queue='backend')

# Ligando a fila à exchange com um routing key que captura todas as mensagens
channel.queue_bind(exchange='topic-exchange', queue='backend', routing_key='cripto.#')

def callback(ch, method, properties, body):
    print(f"Mensagem recebida: {body.decode()}")

# Consumindo da fila dedicada que coleta todas as mensagens
channel.basic_consume(queue='backend', on_message_callback=callback, auto_ack=True)

print("Aguardando mensagens em backend...")
channel.start_consuming()
