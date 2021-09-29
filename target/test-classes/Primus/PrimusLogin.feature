Feature: Checking login functionality of Primus Bank

Background: User successfully login
Given  launch browser "webdriver.chrome.driver" and  .exe file "C:\\Selenium\\Browser\\chromedriver.exe" path
Given user enter "http://primusbank.qedgetech.com/" Url
@SmokeTest
Scenario Outline: Login functionality with valid credential
When user select branch
When user enter <userid> as user id
When user enter <password> as password
When user click on login
Then user get msg as "Welcome to Admin" 


Examples:
|userid|password|
|Admin|Admin|
|Admin123|Admin|
|Rajesh|8765P|
|345678|Admin|
@SmokeTest
Scenario Outline: Login functionality with invalid credential
When user select branch
When user enter <userid> as user id
When user enter <password> as password
When user click on login
Then user get emsg as "Banker Login" 


Examples:
|userid|password|
|A244|Admin|
|Admin|@#h4|
|772234|8765P|
|@!$%|Admin|