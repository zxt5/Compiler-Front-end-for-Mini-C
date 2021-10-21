FROM openjdk:8
WORKDIR /app/
COPY * ./
RUN export CLASSPATH="./antlr-4.9.2-complete.jar" && export CLASSPATH="./antlr4-runtime.jar" && javac *.java
# RUN javac *.java