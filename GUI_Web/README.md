# Web GUI

## What does it do?
This maven module shows you what a well-structured project looks like, so that you can focus on exploring some proposed design patterns (page object model + fluent design) and some proposed best practices (by object locators + test isolation + allure/testng annotations and parameters) for a real project that uses [SHAFT_Engine](https://github.com/shafthq/SHAFT_ENGINE).
<br/>It is recommeded to play around with the Basic Web GUI module first to get familiar with the engine itself before focusing on optimizing the project structure.

## How do I run it?
To execute this project follow these simple steps:
- From your right-hand maven menu, run ```Lifecycle > clean```
- Then run ```Lifecycle > test```
  (This will ensure that this test module is built and executed successfully without any errors.)
- The execution report will launch in your default browser once test execution is complete.

## How do I explore it?
After checking out this project to your IDE, you should find this basic folder structure:
- ```pom.xml``` <br/>This is the main project object model file which houses the SHAFT_Engine version and some basic project configuration.
- ```src > main > java``` <br/>Here you will find your page object model classes, for every page there is a class. Note that if there are common elements between several pages (like a sticky menu or a footer) it is recommended to create separate classes for them without implementing a base page (inheritance) unless absolutely necessary and in alignment with basic SOLID principles.
- ```src > main > resources``` <br/>Here you will find the ```selenium4.yml``` file to launch your docker-compose selenium grid, along with your SHAFT_Engine ```*.properties``` files to manage all your settings.
- ```src > test > java``` <br/>Here you will find your ```TestPackage.SampleTests``` where you will be able to observe how a fluent designed test method looks like, how to use some of the recommended annotations/parameters for allure and testng, practice test isolation, and just play around with the engine in a more well-structured project.
- ```src > test > resources``` <br/>Here you will find the ```simpleJSON.json``` test data file to learn how you can externalize your test data with ease.