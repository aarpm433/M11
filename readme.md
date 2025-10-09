
# Dependencies
To run this application properly on your local machine, you'll need Java 17 and MySQL installed. All other dependencies are already defined in the pom.xml file.

# Instructions
1. Make sure environment variables are properly set (this should already be the case)
2. Log into your MySQL console
3. Create a database named rdelivery
4. Clone the project
5. Open the project in VS Code
6. Edit your database configuration file (src/main/resources/application.properties)
    1. Edit the username, password and database name as required
7. Execute the main function
    1. Open the RocketFoodApplication.java file and run it (on the top right part of VS Code, you should see an arrow pointing to the right, when you hover over it, you see a “Run Java” tooltip. Click it.
    2.  You should see a line similar to this at the end of the execution: `INFO 24016 --- [ main] c.r.rocketFood.RocketFoodApplication : Started RocketFoodApplication in 2.726 seconds (process running for 2.963)`

Research

What is SQL

SQL or struyctured Query Language, is a programming language designed to handle relational databases in relatinal databse management systems, it is the standard language used to interact with and extract information from relatinal databses, which organize data into strucured tables.

What is the main difference between SQLite and MySQL?

Mysql is design for larger, multi-user, production -ready sustems with full databse features, wheras SQLite is... lighter... it is lightweight ,serverless, and ideal for small projects, local storage. Situations where simplicity is key

What are primary and foreign keys

A primary key is a key originating from a table, for example in a user table, you could have a user id. A Foreign key is a key that comes from another table, say you make a reservation on a website logged in as User123, that would be a primary key in the user table, as that is your id, but a foreign, or secondary key, in the reservations tables. It is important imformation that comes from another table. 

What are the different relationship types that can be found in a relational databse, Give an example for each type 

One to one: table 1 can have 1 connection with table 2, and vice versa, it would be like saying User 123 can only make a single reservation

one to many: table 1 can have multiple connections with table 2, once they are at the table, user123 can place many orders

Many to many: Multiple records in table 1 can relate to multiple things in table 2, multiple users in a database, can go try many different restaurants.

Identify a pair of tables that have a many-to-one relationship. 
addresses and restaurants, on restaurant can not have multiple addresses, and one address, cannot have multiple restaurants (unless they are stacked)

Identify a pair of table that have a many to one relationship
customers and restaurant, many customers can go a restaurant, but a restaurant cannot go to multiple customers

Identify a pair of tables that have a many to many relationship
customers and orders, many customers can order many things. 