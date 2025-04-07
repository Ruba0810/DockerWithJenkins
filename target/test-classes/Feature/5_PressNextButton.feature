Feature: Click on next button

Background: 
    Given I am on the Google homepage
#    
#@Positive
#Scenario Outline:: click on next button in w3school
#    When I enter "<searchTerm>" in the search bar
#    And I press Enter
#    Then I should see "<expectedResult>"
#    When I click on the link 
#    When I click Login 
#    Then I should see Login page "Log in - W3Schools"
#    Then I will see login "<username>" and "<password>"
#    When I will click on Login button
#    Then I will search for "<search>"
#    Then I will click on next button with "Introduction to HTML"
#    Examples:
#      |searchTerm| expectedResult |username | password|search|
#    |W3school   | W3school - Google Search        |rubavathy0810@gmail.com | Rubavathy@0810|HTML|
#    
#    
#@Negative
#Scenario Outline:: Can't click next button
#    When I enter "<searchTerm>" in the search bar
#    And I press Enter
#    Then I should see "<expectedResult>"
#    When I click on the link 
#    When I click Login 
#    Then I should see Login page "Log in - W3Schools"
#    Then I will see login "<username>" and "<password>"
#    When I will click on Login button
#    Then I will search for "<search>"
#    Then I unable to click on next button withh "Introduction to HTML"
#    Examples:
#     |searchTerm| expectedResult |username | password|search|
#    |W3school   | W3school - Google Search       |rubavathy0810@gmail.com | Rubavathy@0810|HTML|
#    
@usabilitytesting
Scenario Outline:: click on next button in w3school
    When I enter "<searchTerm>" in the search bar
    And I press Enter
    Then I should see "<expectedResult>"
    When I click on the link 
    When I click Login 
    Then I should see Login page "Log in - W3Schools"
    Then I will see login "<username>" and "<password>"
    When I will click on Login button
    Then I will search for "<search>"
    Then I will click on next button with "Introduction to HTML"
    Then I need to click HTML topic section with "<topic>"
    Then I need to search "Country" "Germany" "Maria Anders"
    Examples:
     |searchTerm| expectedResult |username | password|search|topic |
    |W3school   |W3school - Google Search       |rubavathy0810@gmail.com | Rubavathy@0810|HTML|HTML Tables|

    