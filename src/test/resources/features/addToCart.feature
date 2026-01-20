Feature: add to cart feature
  As a customer
  I want to add products to my cart
  So I can purchase the products

  Rule: Add product from store
  Scenario Outline: Add one quantity to cart
    Given I am on the store page
    When I add <productName> to the cart
    Then I see 1 <productName> in the cart
     #And I see 2 products in the cart
    Examples:
      | productName    |
      | Basic Blue Jeans|
      |Anchor Bracelet  |
      |Boho Bangle Bracelet|


# Rule: Add product from product from product page
#
#   Scenario Outline: Add one quantity to cart
#     Given I'm on the product page
#     When I add "<productName>" to the cart
#     Then I see 1 product in the cart
#     Examples:
#       | productName    |
#       |Green Jeans|
#       |Red Shirt  |
#       |Green Shirt|