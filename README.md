# E-Register

The Following project is the solution for ***Taqneen Software*** Company using **Spring Boot** as a technology, **IntelliJ** as an IDE and **PostgreSQL** as a database.   
In simple words, using this project you can create a student with a certain major and involve in many courses.  
To use my project **please don't forget to change following information in *application.properties* file**:  
1. spring.datasource.url 
2. spring.datasource.username
3. spring.datasource.password (if available)
4. spring.jpa.hibernate.ddl-auto (Start with create-drop then change it to update)

Using Postman you can do the following functionalities :
1.  Student CRUD operations 
2.  Course CRUD operations 
3.  Major CRUD operations 
4.  Get Students by creation date (from , to)
5.  Get Students by major 
6.  Add Course to Student 
7.  Remove Course from Student 
8.  Get Course with count of registration
9.  Get Major by Code
10. Get Major By Student