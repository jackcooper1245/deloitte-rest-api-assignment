# deloitte-rest-api-assignment
Welcome to my CRUD REST-API for my Deloitte Assignment. Here you can access and maintain film quotes. The quotes must have a film name and content. As well as that you can optionally add the Actor who said the movie quote.

Link to Postman collection:
https://www.getpostman.com/collections/c500060e243d9ce5bb1e


Link to youtube run through:

https://www.youtube.com/watch?v=xgHdbcgstHo&feature=youtu.be
# To Run

With Docker Compose:

Run `docker-compse up`

Alternatively:

Run:
` % docker pull jackcooper1245/mysql:latest`
` $ docker run jackcooper1245/mysql:latest`

This will get the database running in your local environment.

Navigate to the root of this director and type: `./mvnw spring-boot:run`

Navigate to `http://localhost:8080/quotes` to begin.

# To Test

To run the test suite look in /src/main/test. Right click on the director named `java` and click run tests. All tests will pass if the server is running. If it isn't 1 test will fail.  


# Example Requests:

**GET**

**get all**
`http://localhost:8080/quotes`

This will bring you all the quotes in the data base in JSON.


    { "id": 1,
        "actor": {
            "name": "Mike Myers"
        },
        "film-name": "Shrek",
        "content": "Ogres are like onions."
    },
    {
        "id": 2,
        "actor": null,
        "film-name": "We're gunna need a bigger boat!",
        "content": "Jaws"
    }
    ... etc
      

**POST**

**add new quote** `http://localhost:8080/quotes`

Here you can add new quotes to the database. Below is an example of a new quote. Notice you do not have to add an id as the database will do this automatically.
        
        {"actor": {
            "name": "Ferris Bueller"
        },
        "film-name": "Ferris Buellers Day off",
        "content": "Twist and Shout"}
    
    

**PUT**

**edit quote** `http://localhost:8080/quotes`

Update a quote with a different film name, content or actor. Below is a quote with a new actor.

    
    {"id": 67,
    "actor": {
        "name": "Brick"
    },
    "film-name": "Anchor Man",
    "content": "Buy new suits"}


**DEL**

**delete quote**
`http://localhost:8080/quotes/67`

A delete request with the id of the quote that you are looking to delete. This request will delete the quote below from the database.

    {"id": 67,
    "actor": {
        "name": "Brick"
    },
    "film-name": "Anchor Man",
    "content": "Buy new suits"}
    
**GET**

**get a specific quote** `http://localhost:8080/quotes/67`
The above request will get you the below quote.


    {"id": 67,
    "actor": {
        "name": "Brick"
    },
    "film-name": "Anchor Man",
    "content": "Buy new suits"}
    
 # Component Design Diagram
 
 

