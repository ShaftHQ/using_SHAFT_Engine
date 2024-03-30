# Basic Web GUI

## What does it do?
This maven module shows you what a basic flat test class looks like, so that you can focus on exploring the folder structure, basic functionality, and properties configuration for a simple project that uses [SHAFT_Engine](https://github.com/shafthq/SHAFT_ENGINE).

## How do I run it?
To execute this project follow these simple steps:
- From your right-hand maven menu, run ```Lifecycle > clean```
- Then run ```Lifecycle > test```
  (This will ensure that this test module is built and executed successfully without any errors.)
- The execution report will launch in your default browser once test execution is complete.

## How do I explore it?
After checking out this project to your IDE, you should find this basic folder structure:
- ```pom.xml``` <br/>This is the main project object model file which houses the SHAFT_Engine version and some basic project configuration.
- ```src > main > java``` <br/>This directory is unused here, since this is a basic template.
- ```src > main > resources``` <br/>Here you will find the ```selenium4.yml``` file to launch your docker-compose selenium grid, along with your SHAFT_Engine ```*.properties``` files to manage all your settings.
- ```src > test > java``` <br/>Here you will find your ```TestPackage.SampleBasicTests``` where you will be able to play around with SHAFT's wizard-like syntax to try its browser actions, element actions, verifications, and assertions.
- ```src > test > resources``` <br/>Here you will find the ```simpleJSON.json``` test data file to learn how you can externalize your test data with ease.