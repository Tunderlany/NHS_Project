@searchBars
Feature: Testing the search bars on dashboard page

  Background:
    Given User navigates to NHS app site
    When User enters username 'Lola' and password 'Lola'
    Then User validates the page title is 'NHS patients'

  @NA-54
  Scenario: Testing search bar of patients waiting table
    Given User clicks add patient link
    When User fills out patient information 'Lily', 'James', '111', '11/10/2000', 'Female'
    And User selects patient disease
      | Allergies |
      | Headache  |
    And User clicks add patient button
    Then User validates patient 'Lily James' has successfully been added to waiting list
    Then User validates searching with name
      | Lily       |
      | James      |
      | Lily James |
    And User validates searching with patient ID '111'



