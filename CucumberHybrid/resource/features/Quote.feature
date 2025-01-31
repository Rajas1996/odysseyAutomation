@smoke
Feature: Test Create quote 
  I want to create successful quote

  Scenario: Verify if user is able to create quote successfully or not
    Given User is on dashboard page
    When User cliks on create quote button
    And User Inputs property address
    Then Quote successfully gets created
    

