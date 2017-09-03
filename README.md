# QAWorks Contact Us testing

Testing the QAworks contact page using Cucumber JVM and Selenium

# Instructions

Clone the repo:

Git:
```
$ git clone https://github.com/adindar/selenium-test.git
```

Svn:
```
$ svn co https://github.com/adindar/selenium-test.git
```

## Prerequisites

In order to run browser tests, Selenium will need to be able to drive a browser
installed to your system. Please download Chrome for best results.

Also download ChromeDriver 
https://sites.google.com/a/chromium.org/chromedriver/downloads
and copy the .exe file to your C: drive. Replace this path in /selenium-test/src/test/java/cucumber/StepDefs.java

## Use Maven

Open a command window and run:

    mvn test

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the `RunTest`
class tells JUnit to kick off Cucumber.

My test results are as follows:
4 Scenarios (1 failed, 3 passed)
11 Steps (1 failed, 10 passed)

The failed scenario occurs when the email address is left blank.
