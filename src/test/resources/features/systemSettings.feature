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

      @NA-46
    Scenario: Testing the add room functionality
      Given User clicks system settings link
      When User adds new room 'Room 27'
      Then User validates room 'Room 27' has successfully been added
      And User validates rooms are sorted by room name

      @NA-46
    Scenario: Adding duplicate room
      Given User clicks system settings link
      When User adds  existing room 'Room 27'
      Then User validates room 'Room 27' has NOT been added again

      @NA-46
    Scenario: Deleting room functionality
      Given User clicks system settings link
      When User selects room 'Room 27'
      And User clicks delete room button
      Then User validates room 'Room 27' has successfully been deleted

