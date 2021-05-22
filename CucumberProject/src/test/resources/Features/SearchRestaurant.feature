Feature: Use the website to find restaurants
  So that I can order food
  As a hungry customer
  I want to be able to find restaurants in my area
  
  Scenario: Search for restaurants in an area
  Given User is on Homepage
  When  User search for restaurants in "136 Market Avenue, Winnipeg, MB, Canada"
  And   User clicks on find restaurants in your area
  Then  User should see some restaurants in searched address
  