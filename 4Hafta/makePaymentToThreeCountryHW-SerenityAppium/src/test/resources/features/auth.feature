Feature: I as a user want to authenticate in the application to check my credentials

  @auth_incorrect
  Scenario: Check login with incorrect username and password
    When User logins with invalid username and password
    Then User should see the information toast

  @auth_correct
  Scenario: check login with correct username and password
    When I login with username company and password company
    Then you should see the home page



