package org.smeled;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.smeled",
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@Run"
)
public class RunCucumberTests {
}

