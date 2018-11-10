Restaurant Application

This is an sample spring boot RESTfull web application which does not have much persistence yet.

Setting up Java 

	Need to install java 8 before running the application.
	java -version java version "1.8.0_121" 
	set JAVA_HOME=D:\Packages\Java\jdk1.8.0_171 
	set PATH=%PATH%;%JAVA_HOME%\bin

	D:\work\RND\github\RestaurantApp>java -version 
	java version "1.8.0_191"
	Java(TM) SE Runtime Environment (build 1.8.0_191-b12) 
	Java HotSpot(TM) 64-Bit Server VM (build 25.191-b12, mixed mode)

Clonning the project into local machine

	Set up the git in local machine.
	git clone https://github.com/santhoshpt/RestaurantApp.git 
	cd into RestaurantApp

gradlew bootRun

	Running the application with embedded Tomcat server

Insert a menu item

	http://localhost:8080/restaurant/menu/item
	RequestMethod=POST
	Content-Type=application/json
	Accept=application/json
	Request Body
	{
	    "id":"200",
		"name":"Crispy Pizza",
		"description":"Crispy Pizza",
		"price":"250.00"
	}
	Http Status Code = 200

Query for a menu item

	http://localhost:8080/restaurant/menu/item?id=100
	RequestMethod=GET
	Accept=application/json
	Resoponse
	{
	    "id":"200",
		"name":"Crispy Pizza",
		"description":"Crispy Pizza",
		"price":"250.00"
	}
	Http Status Code = 200, 404

Update an exiting menu item

	http://localhost:8080/restaurant/menu/item/100
	RequestMethod=PUT
	Content-Type=application/json
	Accept=application/json
	Body
	{
	    "id":"200",
		"name":"Crispy Pizza",
		"description":"Crispy Pizza",
		"price":"300.00"
	}
	Http Status Code = 200, 404

Delete an exiting menu item

	http://localhost:8080/restaurant/menu/item/100
	RequestMethod=DELETE
	Http Status Code = 200, 404


References

	https://spring.io/guides/gs/rest-service/#scratch
	https://docs.gradle.org/current/userguide/gradle_wrapper.html#sec:adding_wrapper
