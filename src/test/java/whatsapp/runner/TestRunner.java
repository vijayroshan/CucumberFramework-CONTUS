package whatsapp.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import whatsapp.base.JVMReport;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources" }, glue = {
		"whatsapp.stepdefinition" }, monochrome = true, snippets = SnippetType.CAMELCASE, plugin = {
				"json:src\\test\\resources\\reports\\jsonReport.json" })

public class TestRunner {
	@AfterClass
	public static void afterClass() {
		JVMReport.generateJVMReport("src\\test\\resources\\reports\\jsonReport.json");
	}
}
