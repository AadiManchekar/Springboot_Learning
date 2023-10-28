# # Define the targets
# all: compile test run

# # Compile the code
# compile:
#     mvn compile

# # Run the tests
# test:
#     mvn test

# # Run the application
# run:
#     mvn exec


# Maven targets
.PHONY: maven-clean maven-install

maven-clean:
	@mvn clean

maven-install:
	@mvn install
