@register
Feature: register for a new account
  As a customer
  I want to register for a new account
  So that I can access the site

  Rule: register with valid credentials
  Scenario: register for with new account
    Given I am on the account page
    When I fill in the form with valid data
      |username|email|password|
      |am newGuy|testEng@test.com|testpasword|
    And I click on register
    Then I should see a success message

  Rule: register with invalid credentials
    Scenario: register for with existing email
      Given I am on the account page
      When I fill in the form with invalid data
        |username|email|password|
        |test user|testuser@test.com|testpassword|
      And I click on register
      Then I should get an email error message

     Scenario: register with invalid username
      Given I am on the account page
      When I fill in the form with invalid data
        |username|email|password|
        |11111|testuser@test.com|testpassword|
      And I click on register
      Then I should get a username error message
