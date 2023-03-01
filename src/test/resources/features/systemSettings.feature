@systemSettings
  Feature: Testing the system settings functionalities on NHS app web page

    Background:
      Given User navigates to NHS app site
      When User enters username 'admin' and password 'admin'
      Then User validates the page title is 'NHS patients'

      @NA-46
    Scenario: Testing the add disease functionality
      Given User clicks system settings link
      When User fills out disease information 'Influenza' and '2'
      And User clicks add disease button
      Then User validates disease 'Influenza' has successfully been added
      And User validates diseases are sorted by disease name

      @NA-46
    Scenario: Deleting disease functionality
      Given User clicks system settings link
      When User selects disease 'Influenza'
      And User clicks delete diseases button
      Then User validates disease 'Influenza' has successfully been deleted
