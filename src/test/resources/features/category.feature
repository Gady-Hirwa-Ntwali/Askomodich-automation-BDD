@category
Feature: category filter
  As a customer
  I want to filter the products by category
  So that I can find the products I am looking for

  Scenario Outline: filter by categories
    Given am  on the store page
    When  input the category <category>
    Then I should see the products in the category <category> only

    Examples:
      | category |
      |Men’s Shoes  (1)|
      |Women’s Shoes  (1)|
      |Men’s Shirts  (1)    |