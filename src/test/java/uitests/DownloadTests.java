package uitests;

import org.example.uitests.utils.MyFilesUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DownloadTests extends BaseTestClassUseProperties {
    @Test
    public void downloadTest() throws IOException, InterruptedException {
        File file = MyFilesUtils.generateLoremFile();
        String text = MyFilesUtils.readFile(file.getAbsolutePath());
        goToUrl();
        driver.findElement(By.id("textbox")).sendKeys(text);
        driver.findElement(By.id("create")).click();
        driver.findElement(By.id("link-to-download")).click();

        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File("/Users/nats/Downloads", "easyinfo.txt"));
        String text2 = MyFilesUtils.readFile(file1.getAbsolutePath());

        Assert.assertEquals(text, text2);

          file1.deleteOnExit();
          file.deleteOnExit();

    }

}
