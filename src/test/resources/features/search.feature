@search
Feature: search for products
  As a customer
  I want to search for products
  So that I can find the product I want

  Scenario Outline: search for a product that are in store
    Given I am on the store page
    When I enter <productName> in the search field
    And I click on the search button
    Then I should see only  <productName> on the storePage

    Examples:
    |productName|
    |shirt|
    |shoes|
    |Bracelet|
