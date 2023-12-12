# ESPRIT-4TWIN8-plateforme de fitness 
## MicroServices Spring Boot with docker
A team of esprit students developing microservices for a project " PLATEFORME DE FITNESS ".

## Authors

- [@Wadhah Naggui](https://www.github.com/wadhahzoldyck)
- [@Akram Hadj naser](https://www.github.com/Akramhn)
- [@Malak Hadj messaoud](https://www.github.com/Malak-hadj-messaoud)
- [@Ahmed Belhadj boubaker](https://www.github.com/Ahmed-bel-haj-boubaker)
- [@Oussama Amri](https://www.github.com/Oussemamri)

  
## Tech Stack

**Client Side:** Angular 16, Eureka

**Server Side:** Spring, API Gateway, Eureka, MongoDB (reactive) ,Nodejs
 

# Description

Our project focuses on a fitness platform, comprising 7 microservices with an API Gateway and a Eureka server. The microservices are grouped within a single Docker container, interacting seamlessly via APIs.

- **Authentication/User Management Microservice :**  
  Ensures user authentication and manages their personal data.

- **Coach Microservice :**  
  Provides dedicated features for coach management, including their names, surnames, experience, and availability.

- **Gym Microservice :**  
  Manages information related to fitness gyms, including their location, capacity, and name.

- **Exercise Microservice :**  
  Offers functionalities for exercise management, detailing aspects such as name, types of exercises, and a description.

- **Exercise Plan Microservice :**  
  Responsible for creating and managing exercise plans for users, integrating exercises from the previous microservice. It includes information such as the name, start, and end of the plan.

- **Product Microservice :**  
  Manages information about products associated with the fitness platform, including description, quantity, and price.

- **Order Microservice :**  
  Handles orders placed by users, including details of the ordered products.

This architecture allows for optimal modularity, facilitating maintenance, feature extension, and scalability of the platform to provide a comprehensive experience for users in the fitness domain.
