package helpers;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotHelper {
    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            String filename = generateScreenshotFilename(screenshotName);
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .coordsProvider(new WebDriverCoordsProvider())
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "PNG", new File(filename));
            attachScreenshotToAllure(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateScreenshotFilename(String screenshotName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return "src/test/resources/screenshots/" + screenshotName + "_" + LocalDateTime.now().format(formatter) + ".png";
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshotToAllure (String filename) throws IOException {
        File screenshotFile = new File(filename);
        return Files.toByteArray(screenshotFile);
    }
}