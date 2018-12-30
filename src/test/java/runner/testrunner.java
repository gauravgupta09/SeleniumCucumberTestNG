package runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.File;
import org.junit.AfterClass;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/features"
,glue= {"seleniumgluecodesteps"}
,plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extentReports/report.html"
		,"pretty","html:target/cucumber-html-reports","json:target/cucumber-html-reports/cucumber.json"
}
,monochrome = true
,tags = {"@testing"}
)

public class testrunner {
	
	//Required to load extent report template
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
    }
}
