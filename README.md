## Build-Microservices-using-Spring-Boot-and-Spring-Cloud
### learned how to use Spring Cloud Config Server to provide centralize 
Configuration for all microservice and their respective instances
![11](https://user-images.githubusercontent.com/48306820/235079830-9dd29365-1390-4195-8112-aa536350dff5.jpeg)

###
![12](https://user-images.githubusercontent.com/48306820/235079844-4e0d33b1-71ef-4072-8ced-1e69b122969e.jpeg)

### here in spring cloud congi server if we change the properties which are present in git, then we need to manually restart the config server 
and hit the /refresh actuator end point to recieve the latest change in properties file which is very hactic
![spring cloud config server problem](https://user-images.githubusercontent.com/48306820/235080030-daf70ba4-ed22-4079-ac8f-5bbbac6965e7.png)

### but using spring cloud bus we are using message broker(kafka or rabbit) and we just hit the /busrefresh endpoint to to publish the latest 
change and no need to hit /refresh endpoint for each microservice seperatly
![spring cloud bus config](https://user-images.githubusercontent.com/48306820/235080045-4b4c7c47-eb0b-48d6-85c9-261cc52b1a05.png)

### added react-frontend with validation checking
<img width="1440" alt="Screenshot 2023-04-29 at 6 17 17 PM" src="https://user-images.githubusercontent.com/48306820/235303277-927b6b73-4b87-422e-81af-83275247c093.png">
<img width="1440" alt="Screenshot 2023-04-29 at 6 17 31 PM" src="https://user-images.githubusercontent.com/48306820/235303287-d2a4a08e-7a20-4969-921a-a7d7e922520c.png">
