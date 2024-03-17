# 📦 LocalStack SQS Project

Este projeto usa o LocalStack para emular o serviço SQS da AWS localmente.

## 🚀 Pré-requisitos

- Docker
- Docker Compose

## 🛠️ Como usar

1. Clone este repositório.
2. Navegue até o diretório do projeto.
3. Execute `docker-compose up` para iniciar o LocalStack e criar as filas SQS.

## 📬 Filas SQS

Este projeto cria uma filas SQS no LocalStack:

- `example-queue`

Você pode interagir com essas filas usando o AWS CLI configurado para usar o endpoint do LocalStack.
