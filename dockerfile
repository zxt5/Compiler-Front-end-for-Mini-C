FROM openjdk:15
WORKDIR /app/
COPY * ./
RUN javac -cp .:antlr-4.9.2-complete.jar Main.java