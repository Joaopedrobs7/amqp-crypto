
# Amqp Crypto

Este projeto é uma mensageria amqp com python e java.

![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Python](https://img.shields.io/badge/python-3670A0?style=for-the-badge&logo=python&logoColor=ffdd54)


### Instalação

Clone o repositório em sua máquina:

```bash
git clone https://github.com/Joaopedrobs7/amqp-crypto.git
```
Python:

```
cd amqp-crypto /
pip install -r requirements.txt
```
## Executando Backend
- Rode o `backend.py` para monitorar todas as mensagens<br />    
![Screenshot 2024-09-30 144359](https://github.com/user-attachments/assets/23135882-f7aa-4f6e-b2a7-49370f01542f)


## Executando Produtor (Spring Java)
- Importe o "prodmessenger" Como projeto Maven no [Eclipse](https://eclipseide.org/)<br />

![Screenshot from 2024-09-30 07-52-05](https://github.com/user-attachments/assets/c49ba0aa-7708-4b9d-b4f2-0fa2bc0336db)

- Inicie o Produtor rodando "ProdApplication.java"<br />

![Screenshot from 2024-09-30 07-55-19](https://github.com/user-attachments/assets/94cf29b0-c303-4e9f-89b2-530e4f7a24fe)

- Escolha entre: `1,2 ou 3` Para enviar mensagem para um tópico específico

## Executando Consumidor
Para o Consumidor utilize o [Pycharm](https://www.jetbrains.com/pycharm/) ou outra ide que permita rodar múltiplas instancias.

- Vá até 'Run/debug configurations﻿' Selecione o arquivo `consumer.py` e habilite 'Allow multiple instances'<br />
![Screenshot from 2024-09-30 08-55-08](https://github.com/user-attachments/assets/4f36e6ed-735d-4798-ae7b-16c01e6eca04)

# Agora está tudo certo para rodar ;)
![myImage](https://i.giphy.com/media/v1.Y2lkPTc5MGI3NjExNGh4MnFud3I2ZHYyOXp4MWVkaGZ5bnNkcHB0Z2ZiMmRyN25kNG43MyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/RPwrO4b46mOdy/giphy.gif)
- Rode o `consumer.py` e escolha entre: `1-Consumidor ou 2-Auditor`.
- Caso Consumidor: escolha seu tópico de interesse e sinta-se livre para rodar múltiplas instancias de consumidor ou auditor.
- Caso Auditor: Será apenas um auditor temporário que vai ouvir apenas durante sua execução, se desejar o monitoramento completo por favor siga o [Executando Backend](#executando-backend)
