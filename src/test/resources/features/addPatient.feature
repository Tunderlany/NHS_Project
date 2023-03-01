@addPatient
  Feature: Testing add patient functionality

    Background:
      Given User navigates to NHS app site
      When User enters username 'admin' and password 'admin'
      Then User validates the page title is 'NHS patients'

    @NA-38
    Scenario: Testing the adding patient functionality of NHS web app
      Given User clicks add patient link
      When User fills out patient information 'Lily', 'James', '111', '11/10/2000', 'Female'
      And User selects patient disease
      | Allergies |
      | Headache  |
      And User clicks add patient button
      Then User validates patient 'Lily James' has successfully been added to waiting list


