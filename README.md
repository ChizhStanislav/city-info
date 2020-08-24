Web Telegram Bot

About

The Web Telegram Bot application is an application that provides the user with reference information about the entered city.You can manage data about cities (add new cities and information about them, change and delete any information) via REST webservices.

Tools/libraries

The application uses Springboot, Spring MVC, Spring Data, Hibernate, Java 14. Telegrambots and log4j Libraries. Use Maven to build the project.

Installation guideline (for windows)

-to install the Web Telegram Bot, you need to download it from a remote repository via the link using a third-party application (Git Bash...) or download a ZIP
-archive, in the second case you need to unpack the archive after downloading; -you should install apache-maven (link: https://maven.apache.org/);
-to launch the Web Telegram Bot, go to the root directory of the project from the command line (.../city-info) and type the command (mvn clean package exec:java -Dexec.mainClass="by.chyzh.cityinfo.CityInfoApplication");
-in the application.properties specify botToken=1252229380:AAGJ8u9bUuDn33w8sTg4CBog9WzpY4fxjlu and bot User name=city_information_bot;
-you can also run the application in any development environment.

email

stas23041991@gmail.com