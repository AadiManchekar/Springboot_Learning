docker run -d -p 9411:9411 --name zipkin openzipkin/zipkin:3

docker run -d --name postgres_ms2 -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -p 5432:5432 postgres:16

docker exec -it postgres_ms2 bash

psql -U root

type root and hit enter

CREATE DATABASE schools;

CREATE DATABASE students;

you can open swagger 

http://localhost:8070/swagger-ui/index.html#/

http://localhost:8090/swagger-ui/index.html#/

you can refer data.json to input the data :) 

run it in following series

confg-server > discovery > gateway > school > student


enter this in browser and see if you get the data

http://localhost:8222/api/v1/schools/with-students/1


zipkin UI : http://localhost:9411/zipkin/