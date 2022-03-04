#language:en
Feature: Display and close an alert
  As an user I want to display and close the alerts in order to obtain valuable information about the system

  Scenario: successful opening and closing  alerts
    Given Maria goes to demoqa home page
    When She interacts with the different alerts types
    Then she should see a text displayed by the alerts