
 Feature: My First feature
 
  Scenario: Open Browser and navigate
    Given User Opened the Browser
    When User navigated to app url
    Then user is able to see application landing page

Scenario: User is able to search for product
    Given User Opened the Browser and navigated to app url
    When User search for the new product 
    Then Search result for the product is displayed

