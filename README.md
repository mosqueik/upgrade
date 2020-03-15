# upgrade
Project done in gradle.
Added a task to download the webdriver Mac/Windows/Linux.

CHROME BROWSER should be updated, it downloads the lastest webdriver available. Check that the same version corresponds to what you have in your machine.

To run the project without install:
1- Use the correct command if you are in Mac/Windows/Linux:

gradlew build 
OR 
gradle build 

It should download the webdriver (only Chromedriver in this ocation) and run the tests...