package uitests;

import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClassUseProperties {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
//        System.setProperty("browser", "firefox");

//       driver = WebDriverFactory3.getDriver();

        driver = WebDriverHolder.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebDriverHolder.getInstance().getDriver();
//        WebDriverHolder.getInstance().getDriver().manage().window().maximize();
//        WebDriverHolder.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void afterClass() {
//        if (driver != null) {
//            driver.quit();
//        }
        WebDriverHolder.getInstance().driverQuit();
    }

//    public static void main(String[] args) {
//        System.getProperties().forEach((k, v) -> System.out.println(k + "   " + v));
//    }


    public void goToUrl(String url) {
 //       driver.get(url);
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToUrl() {

        goToUrl(ConfigProvider.getInstance().getProperty("app.base.url"));
    }

    public void goToPart(String part) {

        goToUrl(ConfigProvider.getInstance().getProperty("app.base.url") + part);
    }
}
