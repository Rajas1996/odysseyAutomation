Feature: Test the login feature

  Scenario Outline: Verify if user is able to login successfully or not
    Given user is on login page
    When I enter value in <username> field
    And I Click Next Button
    And I enter values in <password> field
    And I click on enter Button
    Then I should able to log into system
    And User click on quote button
    And user add home address

    Examples: 
      | username          | password     |
      | admin@farmers.com | Hiren@123456 |
