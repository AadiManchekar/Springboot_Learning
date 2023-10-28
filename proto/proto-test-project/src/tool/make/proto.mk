# Protocol Buffers targets
.PHONY: proto-compile grpc-generate clean-and-run

# Compile the protocol buffer definitions and generate the Java code
proto-compile:
	@mvn protobuf:compile

# Generate the gRPC code
grpc-generate:
	@mvn protobuf:compile-custom

# Clean the project, compile proto files, and run the project
clean-and-run: proto-compile grpc-generate
	@mvn clean install exec:java
