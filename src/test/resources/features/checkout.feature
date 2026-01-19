@checkout
Feature: checkout page functionality

  Rule: I am a guest customer

    Scenario: Using default payment options
      Given I have a product in cart
      And I'm on checkout page
      When I provide billing details
        |firstName|lastName|country|address|city|state|zipCode|email|
        |John|Doe|United States (US)|123 Main St|holly zone|Texas|12345|john.doe@example.com|
      And I place order
      Then the order should be placed successfully