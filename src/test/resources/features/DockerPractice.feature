Feature: check functionalities on Docker file

  @dockerLogin
  Scenario:check correct login functionality
    * enter login and password
    * you are logined successfully

  @loginfail
  Scenario: check fail login functionality
    * enter not correct login and password
    * you are logined not correct

