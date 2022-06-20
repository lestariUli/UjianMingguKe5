package com.juaracoding.ujianminggu5;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-reports.html"},
		features = {"src/main/resources/features"}
		)
public class RunnerTest {
	
}
