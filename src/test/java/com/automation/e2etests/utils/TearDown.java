package com.automation.e2etests.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class TearDown {

	/**
	 * Hook method executed after each Cucumber scenario.
	 * 
	 * This method performs the following actions if a WebDriver instance is active:
	 * 
	 * If the scenario has failed, it captures a screenshot and attaches it to the
	 * test report. Closes the WebDriver instance to free up resources. Logs the
	 * scenario name and its execution status (passed or failed).
	 * 
	 */
	@After
	public void quitDriver(Scenario scenario) {
		if (Setup.getDriver() != null) {
			if (scenario.isFailed()) {
				final byte[] screenshot = ((TakesScreenshot) Setup.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "screenshot");

			}

			Setup.getDriver().quit();
			Setup.getLogger().info("Scenario : " + scenario.getName() + "finished" + scenario.getStatus());

		}

	}

}
