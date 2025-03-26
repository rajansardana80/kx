Feature: Broker able to login2 to application

  @Automated1
  Scenario: Broker able to login to application
    Given Broker hit "ENGINE_USER_LOGIN" api
      | Element        | Value                            |
      | email          | abhishekpal.singh11@klearnow.com |
      | hashedPassword | Qa@12345#                        |

#    Then Verify "ENGINE_USER_LOGIN" api response
#      | Element | Value   |
#      | code    | 200     |
#      | token   | notNull |


