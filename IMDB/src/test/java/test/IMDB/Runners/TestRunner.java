package test.IMDB.Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/test/IMDB/FeatureFiles", glue={"test.IMDB.StepDefinitions"})
public class TestRunner {

}
