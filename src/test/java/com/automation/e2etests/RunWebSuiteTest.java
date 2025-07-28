package com.automation.e2etests;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE; 

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/spec/features"}, //toujours mettre le nom du fichier global
		plugin = {"pretty",
				  "html:target/report/cucumber-report.html",
				  "json:target/report/cucumber.json"}, //pour la génération des rapports, son emplacement doit être dans target dans lequel je dois créer un fichier cucumber-report. 
		//glue = {"com.automation.e2etests.steps_definitions"}, on a pas besoin de glue dans ce cas car RunWebSuiteTest et steps_definitions sont dans le même package. C'est l'optimisation de code
		tags = ("@Login"),
		monochrome = true, //pour un bon affichage sur la console 
		snippets = CAMELCASE //
		)
public class RunWebSuiteTest {

}
