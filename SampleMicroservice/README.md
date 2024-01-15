mvn archetype:generate -DgroupId=com.aadi -DartifactId=SampleMicroservice -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

copy paste pom.xml

mkdir api

mkdir util

copy paste pom.xml for api and util

mkdir microservices

cd microservices

Repeat for all projects in microservice folder 

spring init \
    --boot-version=3.2.1 \
    --type=maven-project \
    --java-version=17 \
    --packaging=jar \
    --name=recommendation-service \
    --dependencies=actuator,webflux,lombok \
    --version=1.0.0-SNAPSHOT \
    recommendation-service
