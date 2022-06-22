# Scenes_Automation
Automation https://automation.avalonmeta.com using Selenium WebDriver API,POM pattern(Page Object Model Design Pattern)
-----------------------------------------------------------------------------------------------------------------------
## Technology: <br>
* Automation Framework: Selenium <br>
* Build tool: Maven <br>
* Test Driven Development Framework: TestNG
* Language: Core Java <br>
* Report: Allure,html-report <br>
* IDE: Eclipse, IntelliJ <br>

------------------------------------------------------------------------------------------------------------------------

## Requirement:<br>
1. Automate https://automation.avalonmeta.com UI

------------------------------------------------------------------------------------------------------------------------

## Installation:
1. Clone the repo using below URL<br>
   https://github.com/devzery/Scenes.git<br>
2. Import the project as an Existing Maven Project in IDE:<br>

------------------------------------------------------------------------------------------------------------------------

## Usage:
1. Maven is used as Build Automation Tool that can be used to Execute Project from Command Prompt using:<br>
   #MavenSurefirePlugin, #MavenProfile and also to Integrate the Project with CI Tools - Jenkins Or Bamboo.<br>
2. Apache POI APIs to Drive Data from Excel Files.<br>
   Also, used DataProvider Concept that is provided by TestNG.<br>
3. WebDriverEventListener to Generate Useful Logs in the Console during Tests Execution.<br>
4. Log4j API to Generate Loggers.<br>
5. Extent Report API to Generate Excellent Test Report.<br>
6. Retry Logic to Execute Failed Test Scripts with More Chances Automatically at Run Time.<br>

------------------------------------------------------------------------------------------------------------------------

## Maven Surefire Plugin:
1. Pre-Requisites: Maven Jar Files must be downloaded and path must be set for the same in<br>
   System Environment Variables.<br>
2. To Execute Maven Project from Command Line Prompt, we need Maven Surefire Plugin which you will find in<br>
   pom.xml file.<br>

## Maven Profile Concept
1. In general, If we do not use Maven Profiling when in working with multiple testng.xml files.<br>
   Each time we need to go to pom.xml file and change the name of testng.xml file in Maven Surefire Plugin<br>
   which needs to be executed and it is a very tedious task to do every time.<br>
   So, It is a good practice to implement Maven Profile Concept when in working with multiple testng.xml files.<br>
   Refer: https://mkyong.com/maven/maven-profiles-example/<br>

[Multiple testng.xml files >> We maintain sanity_testng.xml, smoke_testng.xml, regresssion_testng.xml].

------------------------------------------------------------------------------------------------

## Note:
1. Driving the Common Properties like Url, Username and Password from Configuration.properites File.<br>
2. All Common Methods have been written in src/main/java/com/scenes/qa/Utilities/TestUtility.java<br>
3. Failed Test Screenshot that gets added into Extent Report - Code is Written in TestBase.java Class.<br>









