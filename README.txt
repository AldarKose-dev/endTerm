Nurtleu Shaizolla, Elmira Orujova SE-2008
       Java Endterm project 
       Topic: Clothes store 

When user runs the programm there are four (4) available options that will appear as a loop:
     1 show clothes 
     2 sort clothes
     3 order 
     4 exit

If user chooses (1) all available clothes will be outputed from the database. 

If user chooses (2) programm will ask a user what type of sorting he wants to see:
by: size
    gender
    color
    price
    brand
    category

User should input corresponding number to choose one category. Then, based on an answer user should type details about choosen sorting,
for example, his/her size, gender, brand and so one. 

If user chooses (3) programm will ask user to input the ID of product that he/she wants to buy.
Then it will ask user for personal info, such as Name, Phone number, Address. All data about orders and user saves in database.  


There are several most important classes: 
Order - works in creation of orders and inputting/outpitting this order by putting it to array.
Product - create object of product and send it into database
Database connection - to eastablish connection between PostgreSQL and Java 
Applictaion - responsible for user choises and representation of it
Main - establishes coonection and starts the programm 
OrderController - this class implements the logic of creating new order and getting it from database
ProductController - manages the products from database

If user chooses (4) programm execution ends. 

In the project were used such things like:
     1) Exception handling during the execution of SQL statements and establishing connections with Database. 
     2) THe project has 9 classes, and more were about to be added for authorization (administrator and general user)
     3) It shows the understanding of principles of OOP, such as Polymorphism and Encapsulation. 
     4) The singleton pattern was implemented






