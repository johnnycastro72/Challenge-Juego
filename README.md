<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://image.winudf.com/v2/image1/Y29tLmVkdWM4cy50cml2aWFxdWl6MjAxNV9pY29uXzE1NTE1OTIzMjZfMDA4/icon.png?w=&fakeurl=1" alt="Project logo"></a>
</p>

<h3 align="center">Questions & Answers Game</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Issues](https://img.shields.io/github/issues/kylelobo/The-Documentation-Compendium.svg)](https://github.com/kylelobo/The-Documentation-Compendium/issues)
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/kylelobo/The-Documentation-Compendium.svg)](https://github.com/kylelobo/The-Documentation-Compendium/pulls)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

---

<p align="center"> In this challenge we are going to model a quiz show, the intention is to design a solution that allows to have a bank of questions with different options for a single answer, also each question must be in a category or a group of similar questions of the same level, for each round must be assigned a prize to get, the rounds of the game are level that increase as the player wins prizes.
    <br> 
</p>

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Deployment](#deployment)
- [Usage](#usage)
- [Built Using](#built_using)
- [TODO](./TODO.md)
- [Contributing](../CONTRIBUTING.md)
- [Authors](#authors)
- [Acknowledgments](#acknowledgement)

## 🧐 About <a name = "about"></a>

What is sought in this game is to pre-construct a series of questions with 4 answer options and one of them valid, plus a category associated with the same level of difficulty. Each question must be categorized and there must be a minimum of 5 questions per category where for each round a question must be randomly drawn from that category, there must be 5 rounds in the entire game.
There must be 5 rounds in the whole game, each round awards prizes (points or money) when the player gets it right.

The accumulated prizes are within the contest but if given the case the player intends to leave the game can withdraw before answering the question, if on the contrary the player loses then would leave the game without the accumulated that would take at that time.

## 🏁 Getting Started <a name = "getting_started"></a>

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See [deployment](#deployment) for notes on how to deploy the project on a live system.

### Prerequisites

- [Python](https://www.python.org/downloads/) - Python 3.9.9
- [Visual Studio Code](https://code.visualstudio.com/) - Code Editor
- [Postman](https://www.postman.com/) - API testing
- [Heroku cli](https://devcenter.heroku.com/articles/heroku-cli) - Heroku Command Line Interface (Deployment)
- [Node.js](https://nodejs.org/en/) - Server Enviroment
- [Vue.js](https://vuejs.org/) - FrontEnd Framework
- [Docker Desktop](https://docs.docker.com/docker-for-windows/install/) - Containers Platform
- [Java JDK](https://www.oracle.com/java/technologies/downloads/#java17) - Java programming language
- [Apache Maven](https://maven.apache.org/download.cgi) - Software project management
- [Intellij IDEA](https://www.jetbrains.com/idea/download/#section=windows) - IDE for software developers
- [MongoDB](https://www.mongodb.com/) - NoSQL database

## If you need the database credentials please send an email to j2csofka@gmail.com

### running Endpoints

- API Gateway - GraphQL node.js - https://qagame-api.herokuapp.com/
- Authentication microservice django rest python - https://qaauth-ms.herokuapp.com/
- Question and answers game microservice - Spring Boot Java - https://qagame-ms.herokuapp.com/
- Question and answers game front end - Vue.js Node.js - https://qagame-fe.herokuapp.com/


### Installing

```
Download all tools and frameworks
clone this repository to your local desktop
use requirements.txt or package.json to install required libraries
Intellij IDEA download and install all dependencies
```

End with an example of getting some data out of the system or using it for a little demo.

## 🔧 Running the tests <a name = "tests"></a>

Explain how to run the automated tests for this system.

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## 🎈 Usage <a name="usage"></a>

Add notes about how to use the system.

## 🚀 Deployment <a name = "deployment"></a>

Add additional notes about how to deploy this on a live system.

## ⛏️ Built Using <a name = "built_using"></a>

- [PostgreSQL](https://www.postgresql.org/) - Database SQL
- [django](https://www.djangoproject.com/) - Server Framework
- [django-Rest](https://www.django-rest-framework.org/) - Server Rest Framework
- [python](https://www.python.org/) - Python programming language
- [MongoDB](https://www.mongodb.com/) - Database NoSQL
- [Spring Boot](https://spring.io/projects/spring-boot) - Server Framework
- [Java](https://www.java.com/en/) - Java programming language
- [NodeJs](https://nodejs.org/en/) - Server Environment
- [Apollo Server](https://www.apollographql.com/) - Server Framework
- [VueJs](https://vuejs.org/) - Web Framework
- [JavaScript](https://www.javascript.com/) - JavaScript programming language
- [Docker](https://www.docker.com/) - Containers Platform
- [Heroku](https://dashboard.heroku.com/apps) - Platform as a service (PaaS)

## ✍️ Authors <a name = "authors"></a>

- [@johnnycastro72](https://github.com/johnnycastro72) - Idea & Initial work

## 🎉 Acknowledgements <a name = "acknowledgement"></a>

- Hat tip to anyone whose code was used
- Inspiration
  Practical challenge proposed by Sofka as part of its application to the developer position.
- References
  Mision TIC course memories.
