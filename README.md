# JSON File Parsing Project

This project is designed to parse and display information from a JSON file. The project is built with Spring Boot and utilizes the Jackson library for JSON parsing.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
Java 8 or above  
Maven

### Installing

--> 1. Clone the project to your local machine

```
  git clone https://github.com/alicjaz/Sportradar.git
```
--> 2. Move into the directory:
```
cd Sportradar
```

--> 3. Build and run the project using maven
```
mvn clean install
```

--> 4. Run the Spring Boot application
```
mvn spring-boot:run
```
--> 5. Deploy the server
```
http://127.0.0.1:8000/
```
### Endpoints
`/events?numberOfEvents` - Prints the first `numberofEvents` events in the JSON file. If the number of events specified is greated than the total number of events in the JSON file, all events will be printed.  
`/teams/{compatitionName}` - Prints all team names for given `competitionName` alphabetically.


### Built With
[Spring Boot](https://spring.io/projects/spring-boot) - The web framework used  
[Jackson](https://github.com/FasterXML/jackson) - JSON parsing library  
[Maven](https://maven.apache.org/) - software project management and comprehension tool

### Author
Alicja Zalewska - [github](https://github.com/alicjaz)

## Screenshots
![Home page view](https://i.ibb.co/V2YNRYp/index.png)

![Matches view](https://i.ibb.co/vdQSDJc/matches.png)

![Competitors](https://i.ibb.co/bWgjqxT/competitors.png)
