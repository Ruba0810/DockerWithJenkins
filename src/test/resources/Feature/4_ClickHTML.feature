Feature: Search HTML tutorial

Background: 
    Given I am on the Google homepage
    
@Positive
Scenario Outline:: Search for HTML tutorial
    When I enter "<searchTerm>" in the search bar
    And I press Enter
    Then I should see "<expectedResult>"
    When I click on the link 
    When I click Login 
    Then I should see Login page "Log in - W3Schools"
    Then I will see login "<username>" and "<password>"
    When I will click on Login button
    Then I will search for "<search>"
    Examples:
    |searchTerm| expectedResult |username | password|search|
    |W3school   | W3school - Google Search       |rubavathy0810@gmail.com | Rubavathy@0810|HTML|
    