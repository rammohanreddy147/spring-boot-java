FROM gitpod/workspace-full:latest

# Install Java 17
RUN sudo apt-get update && sudo apt-get install -y openjdk-17-jdk
RUN sudo update-alternatives --set java /usr/lib/jvm/java-17-openjdk-amd64/bin/java

# Set JAVA_HOME to point to Java 17
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
