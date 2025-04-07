@Positive
Feature: Search Feature

  Scenario Outline:: Search for a term and see the results
    Given I am on the Google homepage
    When I enter "<searchTerm>" in the search bar
    And I press Enter
    Then I should see "<expectedResult>"
    
    Examples:
    |searchTerm| expectedResult |
    |W3school  | W3school - Google Search |
