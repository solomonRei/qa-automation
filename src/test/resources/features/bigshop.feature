@bigshop
Feature: BigShop Website Testing

  @require_test
  Scenario: User navigates to the BigShop website
    Given the user opens the browser
    When the user navigates to "https://bigshop.md/"
    Then the website title should contain "BigShop"

  @require_test
  Scenario: User searches for a product
    Given the user is on the BigShop homepage
    When the user searches for "smartphone"
    Then search results should be displayed

  @require_test
  Scenario: User adds a product to the cart
    Given the user is on the product page
    When the user adds a laptop to the cart
    Then the cart should contain the added product

  @optional_test
  Scenario: User proceeds to checkout
    Given the user has products in the cart
    When the user goes to the cart
    And the user proceeds to checkout
    Then the user should see the checkout page

  @undone_test
  Scenario: User logs in to their account
    Given the user is on the login page
    When the user enters valid credentials
    And the user clicks the login button
    Then the user should be logged in