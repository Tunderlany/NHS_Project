@systemSettingsAPI
Feature: Testing system settings API endpoints

  Background:
    Given User navigates to NHS app site
    When User enters username 'Lola' and password 'Lola'
    Then User validates the page title is 'NHS patients'
    And User clicks system settings link

  @NA-56
  Scenario: Validating get diseases endpoint
    Given User has valid url
    When User sends a request to get all diseases
    Then User validates status code is 200
    And User validates list of diseases

