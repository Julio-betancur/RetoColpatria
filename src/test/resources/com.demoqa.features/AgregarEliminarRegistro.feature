#language:en
Feature: Add and remove records from the table
  As an user I want to add and delete people to keep track

  Scenario: Successful registration and deletion
    Given Maria goes to demoqa home page
    When she register a new persona with their credentials
    And she removes any record from the table
    Then she should see that the record was deleted



