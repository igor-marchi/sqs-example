#!/bin/sh

aws configure set aws_access_key_id test
aws configure set aws_secret_access_key test
aws configure set default.region sa-east-1

echo "Waiting for LocalStack to be ready..."
aws --endpoint-url=http://localstack:4566 sqs list-queues

while [ $? -ne 0 ]
do
    sleep 2
    echo "Retrying..."
    aws --endpoint-url=http://localstack:4566 sqs list-queues
done

echo "LocalStack is ready, creating the queue..."
aws --endpoint-url=http://localstack:4566 sqs create-queue --queue-name example-queue
