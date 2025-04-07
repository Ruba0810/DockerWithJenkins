# Step 1: Use OpenJDK 17 as the base image for running the application
FROM openjdk:17-jdk-slim

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy your existing pom.xml (to install dependencies without source code)
COPY pom.xml .

# Step 4: Download project dependencies using Maven
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline

# Step 5: Copy your application source code into the container
COPY src /app/src

# Step 6: Expose the port your application will run on (adjust this as needed)
EXPOSE 8080

# Step 7: Command to run your application
CMD ["java", "-jar", "target/CucumbertestNg-0.0.1-SNAPSHOT.jar"]
