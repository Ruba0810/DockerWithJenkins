Feature: Verify W3Schools Link

Background: 
    Given I am on the Google homepage
    
@Positive
Scenario Outline:: Search for a term and see the results

    When I enter "<searchTerm>" in the search bar
    And I press Enter
    Then I should see "<expectedResult>"
    When I click on the link 
    Then I should see the W3Schools page title as "W3Schools Online Web Tutorials"
    
    Examples:
    |searchTerm|row | expectedResult |
    |W3school   | 2 | W3school - Google Search      |
    


@Negative
Scenario Outline:: User tries to click on the "W3Schools" link but it is not working
   When I enter "<searchTerm>" in the search bar
    And I press Enter
    Then I should see "<expectedResult>"
    When I click in the link
    Then I should see an error message or the page should not load as expected
    
    Examples:
   |searchTerm|row | expectedResult |
    |W3school   | 2 | W3school - Google Search      |

