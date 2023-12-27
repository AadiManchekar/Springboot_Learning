docker compose up -d


(Remove KafkaConsumer)
docker exec -it kafka bash

cd /opt/kafka_2.13-2.8.1/bin

./kafka-console-consumer.sh --topic aadiTopic --from-beginning --bootstrap-server localhost:9092


run the code and then open swagger

http://{IP or localhost}:8080/swagger-ui/index.html#/message-controller/sendMessage