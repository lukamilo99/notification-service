# Notification service

## Description
A service is responsible for notifying users about various events. This service acts as consumer and communicates with other services asynchronously(retrieving user and event information) using the RabbitMQ message broker and a direct exchange. Currently, only the functionality to send registration confirmation emails has been implemented. However, the plan is to extend this service to handle other types of notifications, such as password reset conformation, reservation remainders, and other types of alerts. All sent notifications are stored in NoSQL MongoDB.

## Strucuture
This service is part of a Rent-a-Car application that is structured as a set of microservices:
* [User service](https://github.com/lukamilo99/user-service) <br/>
* [Rent service](https://github.com/lukamilo99/rent-service) <br/>
* [Notification service](https://github.com/lukamilo99/notification-service) <br/>
* [Api gateway service](https://github.com/lukamilo99/api-gateway-service) <br/>
* [Registry service](https://github.com/lukamilo99/registry-service) <br/>

Each microservice is responsible for a specific task, and they work together to provide the functionality.
