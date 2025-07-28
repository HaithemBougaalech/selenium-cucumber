package com.automation.e2etests.steps_definitions;

import org.junit.jupiter.api.Assertions;

import com.automation.e2etests.pages_objects.LoginPage;
import com.automation.e2etests.utils.ConfigFileReader;
import com.automation.e2etests.utils.SeleniumUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	LoginPage loginPage;
	ConfigFileReader configFileReader;
	SeleniumUtils seleniumUtils;
	
	public LoginStepDefinition() {
		
		loginPage        = new LoginPage();
		configFileReader = new ConfigFileReader();
		seleniumUtils    = new SeleniumUtils(); 
		
	}

	@Given("j'accède à l'application orange")
	public void jAccèdeÀLApplicationOrange() throws InterruptedException {
		seleniumUtils.get(configFileReader.getProperty("home.url"));
		Thread.sleep(3000);

	}

	@When("Je saisis le username")
	public void jeSaisisLeUsername() {
		seleniumUtils.writeText(LoginPage.getUsername(),configFileReader.getProperty("home.username"));

	}

	@When("Je saisie le mot de passe")
	public void jeSaisieLeMotDePasse() {
		seleniumUtils.writeText(LoginPage.getPassword(), configFileReader.getProperty("home.password"));

	}

	@When("Je clique sur le bouton login")
	public void jeCliqueSurLeBoutonLogin() {
		seleniumUtils.click(LoginPage.getBtnLogin());
			}

	@Then("Je me redirige vers la page dashboard")
	public void jeMeRedirigeVersLaPageDashboard(String text) throws InterruptedException {
		String result = seleniumUtils.readText(LoginPage.getTextDashboard());
		Assertions.assertEquals(result, text);
	}

}
