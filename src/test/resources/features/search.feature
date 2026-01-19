Feature: search for products
  As a customer
  I want to search for products
  So that I can find the product I want

  Scenario: search for a product
    Given I am on the storePage
    When I search for "iPhone"
    Then I should see the product "iPhone"