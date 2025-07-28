package com.automation.e2etests.pages_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.e2etests.utils.BasePage;
import com.automation.e2etests.utils.Setup;

public class LoginPage extends BasePage {

	@FindBy(how = How.NAME, using = "username")
	private static WebElement username;

	@FindBy(how = How.NAME, using = "password")
	private static WebElement password;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private static WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = "//h6[normalize-space() = 'Dashboard']")
	private static WebElement textDashboard;

	public LoginPage() {
		super(Setup.getDriver());
	}

	public static WebElement getUsername() {

		return username;
	}

	public static WebElement getPassword() {

		return password;
	}

	public static WebElement getBtnLogin() {

		return btnLogin;
	}
	public static WebElement getTextDashboard() {

		return textDashboard;

	} 
}
