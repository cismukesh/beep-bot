# Beep Beep Bot Bot

  Project is based on jsp and java-spring boot. 
  
  Beep Bot a Telegram chatbot which talks with a user and provides him/her relevant information like the weather, news and other interesting tidbits on any particular day, at a geographic location.   

  Basic feature of the application include:

  i. The bot should first ask the name of the user, and start addressing him/her by that name.

  ii. Then the bot should ask about the location of the person.

  iii. The bot will tell the weather of the day in that location.

  iv. The bot will also tell the top 3 news in that country.

# Usage

   i. first user Pick-up Location on the google map and insert his/her name and click on submit, application will show user Name, Location and Location-Weather. 

   ii. user select the country for getting news then click on news, application returns the top 3 news of selected country.   

## Installation

   i. Eclipse - IDE.

   ii. You just need to have Java 8 installed on your machine.

   iii. Use spring starter maven project for easily import (import existing maven project) in eclipse.
 
   iv. Also there some dependencies, Install all the dependencies of pom.xml. 
  
   v. For database java ORM tool hibernate create database and tables automatically.

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.One way is you just need to run application to import existing maven project from any IDE like eclipse or Intellij, and run as a spring boot app.

The application will run on 

```bash
http://127.0.0.1:9090/beep-bot-home
```