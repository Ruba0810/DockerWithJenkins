package com.cucumber.testng.stepdefination;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.cucumber.testng.hook.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
    WebDriver driver = Hook.driver;
    
    Actions action = new Actions(driver);

    @Given("I am on the Google homepage")
    public void i_am_on_the_google_homepage() {
        driver.get("https://www.google.co.uk/");
    }
    @When("I enter {string} in the search bar")
    public void i_enter_in_the_search_bar(String sheet) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys(sheet);
    }


    @When("I press Enter")
    public void i_press_enter() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(Keys.ENTER);
        
        // Ensure the page has loaded with the expected search result
        wait.until(ExpectedConditions.titleContains("Google Search"));
    }

    @Then("I should see {string}")
    public void i_should_see(String expectedResult) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.titleContains(expectedResult)); // Wait for the title to load
        String searchResult = driver.getTitle();
        
        // Debugging Output
        System.out.println("Actual Page Title: " + searchResult);
        System.out.println("Expected Title: " + expectedResult);

        Assert.assertTrue(searchResult.contains(expectedResult),
            "Title does not match expected result. Expected: " + expectedResult + ", but found: " + searchResult);
    }
    @Then("I should see the W3Schools page title as {string}")
    public void i_should_see_the_w3schools_page_title_as(String expectedTitle) {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    	    try {
    	        // Wait until the title contains the expected value
    	        boolean titleIsCorrect = wait.until(ExpectedConditions.titleIs(expectedTitle));

    	        // Assertion: Verify title matches
    	        Assert.assertTrue(titleIsCorrect, "Expected page title: " + expectedTitle + ", but got: " + driver.getTitle());
    	        System.out.println("Page title is as expected: " + driver.getTitle());
    	    } catch (TimeoutException e) {
    	        Assert.fail("Page title did not match expected: " + expectedTitle + ". Current title: " + driver.getTitle());
    	    }
       
    }

   

    @Then("I should see an error message or the page should not load as expected")
    public void i_should_see_an_error_message_or_the_page_should_not_load_as_expected() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        try {
            // Check if page title contains "Error" or "Not Found" (common error indicators)
            boolean errorPageLoaded = wait.until(ExpectedConditions.or(
                ExpectedConditions.titleContains("Error"),
                ExpectedConditions.titleContains("Not Found")
            ));

            Assert.assertTrue(errorPageLoaded, "Expected an error page, but the page loaded normally with title: " + driver.getTitle());
            System.out.println("Error page loaded as expected: " + driver.getTitle());
        } catch (TimeoutException e) {
            // If no error title is found, fail the test
            Assert.fail("Page loaded successfully, but an error was expected. Current title: " + driver.getTitle());
        }
    }

    @When("I click on the link")
    public void i_click_on_the_link() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    	 try {
             WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='yuRUbf']//h3[text()='W3Schools Online Web Tutorials']")));
    	        System.out.println("Found the link, clicking now...");
    	        link.click();
    	        System.out.println("Successfully clicked on the link.");
    	    } catch (Exception e) {
    	        Assert.fail("The link was not found or not clickable: " + e.getMessage());
    	    }
    }
    @When("I click Login")
    public void i_click_login() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    	WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(normalize-space(text()), 'Log in')]")));
    	loginButton.click();
    	}


    @Then("I should see Login page {string}")
    public void i_should_see_login_page(String expectedTitle) {
        assertTrue(driver.getTitle().contains(expectedTitle), "Expected login page not displayed.");
    }

    @Then("I will see login {string} and {string}")
    public void i_will_see_login_and(String email, String password) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(password);
        } catch (Exception e) {
            System.out.println("Error entering login credentials: " + e.getMessage());
        }
    }

    @When("I will click on Login button")
    public void i_will_click_on_login_button() {
        try {
            driver.findElement(By.xpath("//button[text()='Login']")).click();
        } catch (Exception e) {
            System.out.println("Error clicking login button: " + e.getMessage());
        }
    }

    @Then("I will visit {string}")
    public void i_will_visit(String expectedTitle) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        assertTrue(driver.getTitle().contains(expectedTitle), "Navigation to expected profile page failed.");    }

    @Then("I should  not Visit {string}")
    public void i_should_not_visit(String expectedTitle) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleContains(expectedTitle)));

        System.out.println("Current Page Title: " + driver.getTitle());
        Assert.assertFalse(driver.getTitle().contains(expectedTitle), 
            "User was able to access the profile page unexpectedly.");    
    }
  
    

    @When("I click forgot button")
    public void i_click_forgot_button() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Forgot Password?']"))).click();
        } catch (Exception e) {
            System.out.println("Error clicking forgot password button: " + e.getMessage());
        }
    }

    @Then("I will visit reset password page {string}")
    public void i_will_visit_reset_password_page(String expectedUrl) {
        assertTrue(driver.getCurrentUrl().contains(expectedUrl), "Reset password page not reached.");
    }

    @Then("I will search for {string}")
    public void i_will_search_for(String query) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tnb-google-search-input")));
        searchBox.sendKeys(query, Keys.ENTER);
    }

    @Then("I will click on next button with {string}")
    public void i_will_click_on_next_button_with(String expectedTitle) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Next ❯')]"))).click();
            assertTrue(driver.getTitle().contains(expectedTitle), "Next page title mismatch.");
        } catch (Exception e) {
            System.out.println("Error clicking next button: " + e.getMessage());
        }
    }

    @Then("I need to click HTML topic section with {string}")
    public void i_need_to_click_html_topic_section_with(String topic) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + topic + "']"))).click();
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 300)");
        } catch (Exception e) {
            System.out.println("Error clicking HTML topic section: " + e.getMessage());
        }
    }

    @Then("I need to search {string} {string} {string}")
    public void i_need_to_search(String columnName, String country, String expectedValue) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	try {
            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='ws-table-all']")));
            List<WebElement> headers = table.findElements(By.tagName("th"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            int columnIndex = -1;
            boolean flag = false;

            // Find the column index
            for (int i = 0; i < headers.size(); i++) {
                if (headers.get(i).getText().equalsIgnoreCase(columnName)) {
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex != -1) {
                for (int i = 1; i < rows.size(); i++) {
                    List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
                    if (cells.size() > columnIndex && cells.get(columnIndex).getText().equalsIgnoreCase(country)) {
                        for (WebElement cell : cells) {
                            if (cell.getText().trim().equalsIgnoreCase(expectedValue)) {
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }

            Assert.assertTrue(flag, "Detail not present in table.");
        } catch (Exception e) {
            System.out.println("Error searching table: " + e.getMessage());
        }
    }
}
