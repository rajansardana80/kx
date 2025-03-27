Feature: Broker able to login1 to application

  @Automated
  Scenario: Broker able to login to application
    Given Broker hit "ENGINE_USER_LOGIN" api
      | Element        | Value                            |
      | email          | abhishekpal.singh11@klearnow.com |
      | hashedPassword | Qa@12345#                        |
    Then Verify "ENGINE_USER_LOGIN" response
      | Element | Value   |
      | kxtoken | notNull |




