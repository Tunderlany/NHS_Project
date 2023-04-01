@addUser
Feature: Testing the add user functionality of NHS app web page

  @NA-51
  Scenario: Adding new user
    Given User navigates to NHS app site
    When User enters username 'Loli' and password 'Loli'
    Then User validates the page title is 'LoginPage'
    When User enters username 'admin' and password 'admin'
    And User validates the page title is 'NHS patients'
    And User clicks system settings link
    And User adds new user with username 'Loli' and password 'Loli'
    And User logs out
    Then User enters username 'Loli' and password 'Loli'
    And User validates the page title is 'NHS patients'


