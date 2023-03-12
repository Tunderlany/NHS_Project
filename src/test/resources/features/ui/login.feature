@login
Feature: Testing the login functionality on NHS app

  Scenario: Testing successful login

    Given User navigates to NHS app site
    When User enters username 'admin' and password 'admin'
    Then User validates the page title is 'NHS patients'

  Scenario Outline: Testing login with invalid credentials

    Given User navigates to NHS app site
    When User enters username '<userName>' and password '<password>'
    Then User validates the page title is '<pageTitle>'

    Examples:
      |userName      |password     |pageTitle|
      |wrongUser     |admin        |LoginPage|
      |admin         |wrongPassword|LoginPage|
      |wrongUser     |wrongPassword|LoginPage|

  Scenario Outline: Testing login with leaving credential input blank

    Given User navigates to NHS app site
    When User enters username '<userName>' and password '<password>'
    Then User validates the page title is '<pageTitle>'

    Examples:
      |userName |password |pageTitle|
      |         |admin    |LoginPage|
      |admin    |         |LoginPage|
      |         |         |LoginPage|














