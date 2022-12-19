# Web GUI (Using Cucumber)

## What does it do?
This maven module shows you what a well-structured project that uses Cucumber features/steps along with a page object model / fluent design should look like.
<br/>Note that it is recommended to use the Cucumber approach only if your team is implementing a full BDD cycle, otherwise we recommend using the TestNG approach instead. If you decide to use Cucumber with [SHAFT_Engine](https://github.com/shafthq/SHAFT_ENGINE) keep exploring this maven module.

## How do I run it?
To execute this project follow these simple steps:
- From your right-hand maven menu, run ```Lifecycle > clean```
- Then run ```Lifecycle > test```
  (This will ensure that this test module is built and executed successfully without any errors.)
- The execution report will launch in your default browser once test execution is complete.
- Since this is a Cucumber project, note that you can also execute by pressing the green ```run``` button inside any of your feature files.
- You can also execute all your tests by running your ```CucumberTestRunner``` class.

## How do I explore it?
After checking out this project to your IDE, you should find this basic folder structure:
- ```pom.xml``` <br/>This is the main project object model file which houses the SHAFT_Engine version and some basic project configuration.
- ```src > main > java``` <br/>Here you will find your page object model classes, for every page there is a class. Note that if there are common elements between several pages (like a sticky menu or a footer) it is recommended to create separate classes for them without implementing a base page (inheritance) unless absolutely necessary and in alignment with basic SOLID principles.
- ```src > main > resources``` <br/>Here you will find the ```selenium4.yml``` file to launch your docker-compose selenium grid, along with your SHAFT_Engine ```*.properties``` files to manage all your settings. Pay attention to ```cucumber.properties``` since this is the file that you need to configure to be able to read your step definitions and features and glue them together.
- ```src > test > java``` <br/>Here you will find your ```Steps``` and your ```CucumberTestRunner``` classes. Feel free to add more steps, and note that the test runner will always run all your features unless you configure your properties file to apply specific filters or run specific tags.
- ```src > test > resources``` <br/>Here you will find the ```simpleJSON.json``` test data file to learn how you can externalize your test data with ease. You will also find your ```*.feature``` files where your project will be able to read and glue the steps automatically.