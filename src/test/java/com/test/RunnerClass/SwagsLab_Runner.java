package com.test.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/test/resources/Features/LoginPage.feature",
		glue="com.test.Stepdefinitions",
		plugin= {
				"pretty","json:Report Cucumber/cucumber.json",
				"json:Report Cucumber/cucumber.html",
                "html:target/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                },
		monochrome=true
        //tags="@Smoke"
		)
public class SwagsLab_Runner {

}
