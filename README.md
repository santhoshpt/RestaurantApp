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

Clonning the project into local machine or else download archieve.

	Set up the git in local machine.
	git clone https://github.com/santhoshpt/RestaurantApp.git 
	cd into RestaurantApp

gradlew bootRun

	Running the application with embedded Tomcat server and execute the following URLs in Postman.

Adding a new menu item resource

	URL: http://localhost:8080/restaurant/menu/item
	RequestMethod=POST
	Content-Type=application/json
	Accept=application/json
	Request Body
	{
	    "name":"Crispy Pizza",
	     "description":"Crispy Pizza",
	     "price":"250.00"
	}
	Reponse http status code is 200
	
To read all menu item resources

	URL: http://localhost:8080/restaurant/menu/item
	RequestMethod=GET
	Accept=application/json
	Resoponse Body
	[
	  {
	    "id":"1000",
	    "name":"Pizza",
	    "description":"Pizza",
	    "price":"100.00"
	  },{
	    "id":"2000",
	    "name":"Cheese Pizza",
	    "description":"Cheese Pizza",
	    "price":"200.00"
	  }
	]
	Http Status Code = 200, 404

To read an existing menu item resource

	URL: http://localhost:8080/restaurant/menu/item/1
	RequestMethod=GET
	Accept=application/json
	Resoponse Body
	{
	    "id":"1",
	    "name":"Crispy Pizza",
	    "description":"Crispy Pizza",
	     "price":"250.00"
	}
	Http Status Code = 200, 404

To Update an exiting menu item

	URL: http://localhost:8080/restaurant/menu/item/1
	RequestMethod=PUT
	Content-Type=application/json
	Accept=application/json
	Request Body
	{
	     "name":"Crispy Pizza",
	     "description":"Crispy Pizza",
	     "price":"300.00"
	}
	Http Status Code = 200, 404

Delete an exiting menu item

	URL: http://localhost:8080/restaurant/menu/item/1
	RequestMethod=DELETE
	Http Status Code = 200, 404


References

	https://spring.io/guides/gs/rest-service/#scratch
	https://docs.gradle.org/current/userguide/gradle_wrapper.html#sec:adding_wrapper
