#make a payment to three different client
# client countries CN, USA, JPN
# client amounts 10, 20, 30
# for each payment user's balance should be checked.

Feature: User makes a payment
  @payment
  Scenario Outline: user makes payment to three different countries
    Given user can open the application and login
    When user makes a payment with <amount> amount to <phone> <name> <country>
    Then user should see balance is reduced by <amount>
    Examples:
      | amount | phone      |name      |country  |
      |   "10"   | "8679921347" |"Tom"     |"Canada" |
      |   "20"   | "7015168317" |"Jerry"   | "USA"   |
      |   "30"   | "751441679"  |"Sakura"  | "Japan" |