# Maven + Cucumber + TestNG + Appium
- A BDD framework based on Maven, cucumber and TestNG
- Support app test (Appium)
- support web test (Selenium)


#### How to run test
* mvn clean test -Papptest
* mvn clean test -Pwebtest

#### Appium API sample
 * removeApp, installApp, startActivity, isAppInstalled
 * swipe, tap, click
 * findElementsById
 

 #### Backup
 * run samples
 * cd CucumberTestNgFramework/src/test 
 * replace : with ; on windows
 * java -cp "jars/*" cucumber.api.cli.Main -p pretty --snippets camelcase .
 * java -cp "jars/*:." cucumber.api.cli.Main -p pretty --snippets camelcase -g step_definitions features
 * java -cp "jars/*:." cucumber.api.cli.Main -p progress --snippets camelcase -g step_definitions features
 * javac -cp "jars/*:." step_definitions/CheckoutSteps.java implementation/Checkout.java





