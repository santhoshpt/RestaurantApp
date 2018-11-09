Restaurant Application
Setting up Java 
java -version java version "1.8.0_121" 
set JAVA_HOME=D:\Packages\Java\jdk1.8.0_171 
set PATH=%PATH%;%JAVA_HOME%\bin

D:\work\RND\github\RestaurantApp>java -version 
java version "1.8.0_191"
Java(TM) SE Runtime Environment (build 1.8.0_191-b12) 
Java HotSpot(TM) 64-Bit Server VM (build 25.191-b12, mixed mode)

git clone https://github.com/santhoshpt/RestaurantApp.git 
cd into RestaurantApp

gradlew bootRun


http://localhost:8080/restaurant/menu/item?id=10

{"id":10,"name":"test","description":"test","price":10.0}