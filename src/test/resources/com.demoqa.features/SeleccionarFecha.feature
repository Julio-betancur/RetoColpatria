#language:en
Feature: Select a date
  As an user I want to select a date in order to get an appointment

  Scenario: Successful date selection
    Given Maria goes to demoqa home page
    When she select a date without time
    And she select a date with time
    Then she should see that the dates are displayed