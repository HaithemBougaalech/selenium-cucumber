package com.automation.e2etests.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Setup {

	private static WebDriver driver;
	private static final Logger LOGGER = (Logger) LogManager.getLogger(Setup.class.getName());

	/**
	 * Static method to initialize WebDriver based on the browser
	 **/

	/*
	 * Cette ligne permet de déclarer un logger statique et réutilisable pour toute
	 * la classe Setup. Un logger est un outil utilisé pour enregistrer des messages
	 * pendant l’exécution du programme. Il est particulièrement utile pour le suivi
	 * du déroulement d’un scénario ou le diagnostic des erreurs.
	 * 
	 * En définissant ce logger comme statique, on s’assure qu’il n’est instancié
	 * qu’une seule fois, peu importe combien d’objets de la classe Setup sont
	 * créés. Cela permet également d’y accéder facilement depuis n’importe quelle
	 * méthode statique ou non statique de la classe.
	 * 
	 * Le nom de ce logger est souvent basé sur le nom de la classe (par
	 * convention), ce qui permet de retrouver facilement la provenance des messages
	 * dans les fichiers de log.
	 * 
	 * Exemple d'utilisation : - LOGGER.info("Le scénario commence"); // Message
	 * d'information signalant le début du scénario -
	 * LOGGER.error("Erreur critique détectée", exception); // Message d’erreur
	 * critique avec la stack trace de l’exception
	 * 
	 * Grâce à ce logger, on peut produire des messages à différents niveaux (info,
	 * debug, warn, error, etc.) ce qui facilite la maintenance, le débogage et
	 * l’observation du comportement de l’application.
	 */

	@Before
	public void setWebDriver(Scenario scenario) {


		/*
		 * Cette ligne utilise le logger pour enregistrer un message d'information au
		 * début d’un scénario.
		 * 
		 * Plus précisément, elle indique que l’exécution d’un scénario vient de
		 * commencer. Le message inclut dynamiquement le nom du scénario, récupéré via
		 * la méthode scenario.getName(), ce qui permet de rendre les logs plus lisibles
		 * et contextualisés.
		 * 
		 * Exemple de sortie dans les logs : "Scenario : ConnexionUtilisateur - started"
		 * 
		 * Ce type de message est très utile pour suivre l'ordre d’exécution des
		 * scénarios lors des tests ou de l'exécution de scripts complexes, et il
		 * facilite le débogage en identifiant clairement à quel moment un scénario
		 * démarre.
		 */
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = "chrome"; // entre les deux guillemets on saisie le type du browser : chrome, edge ou ...
		}
		switch (browser) {
		case "chrome":
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--start-maximized");
			chromeoptions.addArguments("--disable-search-engine-choice-screen");
			setDriver(new ChromeDriver(chromeoptions));
			break;

		case "firefox":
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			firefoxoptions.setCapability("platform", Platform.WIN11);
			setDriver(new FirefoxDriver(firefoxoptions));
			break;

		case "edge":
			setDriver(new EdgeDriver());
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser : " + browser);
		}
	}

	/* GETTER */
	// Pour utiliser le driver depuis une classe externe puisqu'elle est private
	public static WebDriver getDriver() {
		return driver;
	}

	/* SETTER */
	// Pour utiliser le driver depuis cette classe

	public static void setDriver(WebDriver driver) {
		Setup.driver = driver;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
