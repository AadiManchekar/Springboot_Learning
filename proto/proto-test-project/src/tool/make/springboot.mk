# Clean the application
clean:
    mvn clean

# Compile and run the Spring Boot application
run:
    make clean
    mvn compile exec

# Build and run the tests
test-all: compile
    mvn test

# Build and package the application
package: compile
    mvn package

# Install the application to the local Maven repository
install: package
    mvn install

# Deploy the application to a remote server
deploy:
    # TODO: Add the necessary commands to deploy the application to a remote server
