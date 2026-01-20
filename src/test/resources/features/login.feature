@login
Feature: Login functionality
  Scenario: Customer can login with valid credentials
    Given I am on the login page
    When I enter valid credentials
    | email | password |
    | google@gmail.com | Wht098 |
    And I click on login button
    Then I should be redirected to the dashboard page