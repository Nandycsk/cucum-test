import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(format = { "html:src/report" }, monochrome = true)
public class FeesTest {

}
