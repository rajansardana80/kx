Feature: Broker login1 test cases

  @Web @Automated
  Scenario: Verify user is able to login into broker application
    Given Launch the broker application
    When User enters the below credentials
      | Element | Value                         |
      | email   | rajan.sardana.10@klearnow.com |
      | pwd     | Qa@12345                     |