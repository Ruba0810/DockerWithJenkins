Feature: Login into W3school

Background: 
    Given I am on the Google homepage
  
@Positive
Scenario Outline:: Login into w3school

    When I enter "<searchTerm>" in the search bar
    And I press Enter
    Then I should see "<expectedResult>"
    When I click on the link
    When I click Login 
    Then I should see Login page "Log in - W3Schools"
    Then I will see login "<username>" and "<password>"
    When I will click on Login button
    Then I will visit "W3Schools Online Web Tutorials"
    Examples:
   |searchTerm| expectedResult |username | password|
    |W3school   | W3school - Google Search      |rubavathy0810@gmail.com | Rubavathy@0810|
    
@Negativeh3
Scenario Outline:: Unable To Login 
   When I enter "<searchTerm>" in the search bar
    And I press Enter
    Then I should see "<expectedResult>"
    When I click on the link
    When I click Login 
    Then I should see Login page "Log in - W3Schools"
    Then I will see login "<username1>" and "<password1>"
    When I will click on Login button
    Then I should  not Visit "W3Schools Online Web Tutorials"
    
    
    Examples:
    |searchTerm| expectedResult |username1 | password1|
    |W3school  | W3school - Google Search      |rubavathy0810@gmail.com | Roobi@08|
    
@functionalTesting
Scenario Outline::Check forgot password is clickable
 When I enter "<searchTerm>" in the search bar
    And I press Enter
    Then I should see "<expectedResult>"
    When I click on the link
    When I click Login 
    Then I should see Login page "Log in - W3Schools"
    Then I will see login "<username>" and "<password>"
    When I will click on Login button
    When I click forgot button
    Then I will visit reset password page "https://profile.w3schools.com/reset-password"
    
     Examples:
    |searchTerm| expectedResult |username | password|
    |W3school   | W3school - Google Search     |rubavathy0810@gmail.com | Roo|
    
    