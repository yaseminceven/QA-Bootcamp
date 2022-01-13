Feature: user logs out from application
  @logout
  Scenario: user logs out from the EriBank application
    Given user logged in to application
    When user loges out
    Then user should see login page