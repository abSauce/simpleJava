import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.*;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import java.net.URL;
 
public class SampleSauceTest {
 
  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
  public WebDriver driver;

  @Before
  public void setUp() throws Exception {
 
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "Windows 10");
    caps.setCapability("version", "latest");
 
    driver = new RemoteWebDriver(new URL(URL), caps);
  }

  @Test
  public void testMethod() {
    /**
     * Goes to Sauce Lab's guinea-pig page and prints title
     */
 
    driver.get("https://saucelabs.com/test/guinea-pig");

    // if (Assert.assertTrue(driver.getTitle().contains("guinea"))) {
    //   ((JavascriptExecutor)driver).executeScript("sauce:job-result=passed"); 
    // } else {
    //   ((JavascriptExecutor)driver).executeScript("sauce:job-result=failed"); 
    // }

    System.out.println("title of page is: " + driver.getTitle());
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
}