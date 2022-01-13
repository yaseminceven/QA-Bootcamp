# scenario
# make payment for each country in countries list

Feature: User makes a payment
  @payment-all
  Scenario: user makes payment to all countries
    Given user can open the application and login to app
    When user makes a payment with "5" amount to "8679921347" "Tom" to the each country
    Then user should see balance is reduced by "5"  for each country

# user cancels the payment
  @cancel-payment
  Scenario: user cancels the payment
    Given user login to app
    When user makes a payment to "Jim" "867992135" "USA" with amount of "80" and cancels
    Then user should see the same balance

# user makes invalid payment
  @invalid-payment
  Scenario Outline: user makes invalid payment
    Given user can login to app
    When user makes a payment to <phone> <name> with <amount> to <country>
    Then user should not click the send payment
    Examples:
      | phone        | name  |amount| country |
      | "8679921343" | "Jim" | "0"  | "USA"   |
      | "8679921343" | ""   | "10"  | "USA"   |
      |  ""          | "Jim" | "40" | "USA"   |
      | "8679921343" | "Jim" | "30" | ""      |