package com.cucmber.testng.runner;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Feature",
		glue = {
				"com.cucumber.testng.stepdefination",
				"com.cucumber.testng.hook"
		},
		plugin = {"pretty", "html:target/cucumber-reports.html"},
		monochrome = true
		)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {

	

}