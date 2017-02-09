Feature: Accessing to the actors data.

  Scenario: I want to retrieve all actors
    Given the actors data storage
    When all actors data requested
    Then should be retrieved all data


