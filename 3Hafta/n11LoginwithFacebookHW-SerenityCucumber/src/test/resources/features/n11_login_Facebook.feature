Feature: n11 login with Facebook
  Scenario: n11 login with Facebook
    Given User opens browser and the main page
    When User navigate to Facebook Page
    And User logged in with valid Facebook credentials
    Then User loges in to user main page