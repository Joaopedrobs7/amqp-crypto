
# Amqp Crypto

Este projeto é uma mensageria amqp com python e java.

### Instalação

Clone o repositorio em sua maquina:

```bash
git clone https://github.com/Joaopedrobs7/amqp-crypto.git
```
Python:

```
cd amqp-crypto /
pip install -r requirements.txt
```
    
## Executando Produtor (Spring Java)
- Importe o "prodmessenger" Como projeto Maven no [Eclipse](https://eclipseide.org/)

![Screenshot from 2024-09-30 07-52-05](https://github.com/user-attachments/assets/c49ba0aa-7708-4b9d-b4f2-0fa2bc0336db)

- Inicie o Produtor rodando "ProdApplication.java"

![Screenshot from 2024-09-30 07-55-19](https://github.com/user-attachments/assets/94cf29b0-c303-4e9f-89b2-530e4f7a24fe)

- Escolha entre: `1,2 ou 3` Para enviar mensagem para um topico especifico

## Executando Backend
- Rode o `backend.py` para monitorar todas mensagens

## Executando Consumidor
Para o Consumidor utilize o [Pycharm](https://www.jetbrains.com/pycharm/) ou outra ide que permita rodar multiplas instancias.

- Va ate 'Run/debug configurations﻿' Selecione o arquivo "consumer" e habilite "Allow multiple instances"
![Screenshot from 2024-09-30 08-55-08](https://github.com/user-attachments/assets/4f36e6ed-735d-4798-ae7b-16c01e6eca04)

### Agora esta tudo certo para rodar ;)<br />

- Rode o `consumer.py` e escolha entre: `1-Consumidor ou 2-Auditor`.<br />
+ Caso consumidor escolha seu topico de interesse e sinta-se livre para rodar multiplas instancias de consumidor ou auditor.
+ Caso Auditor: Sera apenas um auditor temporario que vai ouvir apenas durante sua execucao, se desejar o monitoramento completo por favor siga o [Executando Backend](#executando-backend)

