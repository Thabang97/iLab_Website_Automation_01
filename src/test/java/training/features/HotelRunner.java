package training.features;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/training/features/BookHotel.feature",
        format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue={"training.stepdefinition"},
        tags = {"@run1"})




public class HotelRunner {

}
