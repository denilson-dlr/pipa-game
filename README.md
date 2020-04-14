## Pipa Game Microservice
This is a microservice to store users' scores and retreive ranking position information.

---
### Features
- Add a new user with his/hers score.
- Update a user's score.
- Retreive a user score and ranking position by id.
- Retreive the highscores users list.
---
### Design & Coding
- DDD - Every microservice start with a good Domain Driven Design. Mapping domains for this microservice the Core Domain - User and Sub-domains: Ranking Highscores and Score. 
It brings us a sense of organization in what the domain does and interact with the wolrd, helping us to identify the business process into its context.
Applying the DDD, we can extract the main principles of it: Ubiquitous Language and Bounded Context.
- Ubiquitous Language: In a short, ubiquitous language is a shared language developed by the team composed of both domain experts and software developers - It is good to remember that is not a business, enterprise-wide universal language. Instead, it is a language to everyone in the team get along with the domain context.

- Bounded Context: The Bounded Context mapped for this microservice is Scoring. A bounded context is a specific responsability enforced by external world to communicate with. In this case, to receive and to send scoring data information.

######The image is the DDD design applying Ubiquitous Language and mapped Bounded Context. ![Domain Driven Design](/images/scoring.PNG) (/images/scoring.PNG)



- The Architecture for microservice is a n-layer architecture which separates our domain and service, following [Patterns of Enterprise Application Architecture](https://martinfowler.com/books/eaa.html). I recommend to visit an example post catalog from the book: [Service Layer](https://martinfowler.com/eaaCatalog/serviceLayer.html).

######The image shows the architecture for this microservice. ![Architecure Diagram](/images/architecture.PNG) (/images/architecture.PNG)

- Quicksort - It was implemented a quicksort for sorting users position. It is one of very well sorting algorithms. See more here: [QuickSort](https://en.wikipedia.org/wiki/Quicksort).

---
### How to run
- Start the spring boot application using an ide of your choice
- Browser the swagger url documentation: http://localhost:8083/swagger-ui.html
- Enter the credentials [username: admin, password: admin]
- Get access to the swagger documentation and try the endpoints out.

#### Requirements
- JDK 11.
- IDE with Spring Boot Support.