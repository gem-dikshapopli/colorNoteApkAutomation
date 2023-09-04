package implementation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import locators.Locators;
import logger.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Implementation {
    public static AppiumDriver driver;
    public static LongPressOptions longPressOptions = new LongPressOptions();
    public static TouchAction action;

    /**
     * Opens the Notepad application.
     */
    @Test
    public static void openApplication() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", ConfigReader.getProperty("appium.deviceName"));
            cap.setCapability("platformName", ConfigReader.getProperty("appium.platformName"));
            cap.setCapability("app", ConfigReader.getProperty("appium.appPath"));
            cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

            URL url = new URL(ConfigReader.getProperty("appium.appUrl"));
            driver = new AndroidDriver(url, cap);
            action = new TouchAction(driver);
            driver.findElement(Locators.skip).click();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to open the Notepad application.");
        }
    }

    /**
     * Opens the text area and creates five text notes.
     */
    public static void openTextArea() {
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            for (int i = 0; i < 5; i++) {
                driver.findElement(Locators.add).click();
                driver.findElement(Locators.textButton).click();
                driver.findElement(Locators.addText).sendKeys("Text" + (i + 1));
                driver.findElement(Locators.tickButton).click();
                driver.findElement(Locators.backButton).click();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * Changes the color of each text note.
     */
    public static void changeTheColor() {
        try {
            List notes = driver.findElements(Locators.textNotes);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            for (int i = 0; i < notes.size(); i++) {
                longPressOptions.withElement(ElementOption.element((WebElement) notes.get(i)))
                        .withDuration(Duration.ofSeconds(2));
                action.longPress(longPressOptions).release().perform();
                driver.findElement(Locators.colorOption).click();
                driver.findElement(By.id("com.socialnmobile.dictapps.notepad.color.note:id/btn" + (i + 1))).click();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the creation time of each text note.
     */
    public static void printNotesCreationTime() {
        try {
            List time = driver.findElements(Locators.timeOfNotesCreated);
            for (Object element : time) {
                Logger.info(((WebElement) element).getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the first day of the week in settings.
     */
    public static void changeTheDayOfWeek() {
        try {
            driver.findElement(Locators.menuBar).click();
            driver.findElement(Locators.settings).click();
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(UiSelector().textContains(\"First day of week\").instance(0))")).click();
            driver.findElement(Locators.day).click();
            driver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for a specific text note.
     */
    public static void searchThirdTextNote() {
        try {
            driver.findElement(Locators.searchButton).click();
            driver.findElement(Locators.searchArea).sendKeys("Text3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifies the search result for a specific text note.
     */
    public static void verifyTheSearchResult() {
        try {
            String searchedResult = driver.findElement(Locators.searchedNote).getText();
            Assert.assertEquals(searchedResult, "Text3");
            driver.findElement(Locators.goBack).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes specific text notes.
     * long press action is performed on the note ,then it will delete the note
     */
    public static void deleteTextNotes() {
        try {

            WebElement note4 = driver.findElement(Locators.textNote4);
            WebElement note2 = driver.findElement(Locators.textNote2);
            longPressOptions.withElement(ElementOption.element((note4)))
                    .withDuration(Duration.ofSeconds(2));
            action.longPress(longPressOptions).release().perform();
            driver.findElement(Locators.deleteOption).click();
            driver.findElement(Locators.confirmOption).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            longPressOptions.withElement(ElementOption.element((note2)))
                    .withDuration(Duration.ofSeconds(2));
            action.longPress(longPressOptions).release().perform();
            driver.findElement(Locators.deleteOption).click();
            driver.findElement(Locators.confirmOption).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Archives the first text note.
     */
    public static void archiveFirstTextNote() {
        try {
            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
            WebElement note1 = driver.findElement(Locators.textNote1);
            longPressOptions.withElement(ElementOption.element((note1)))
                    .withDuration(Duration.ofSeconds(2));
            action.longPress(longPressOptions).release().perform();
            WebElement archive = driver.findElement(Locators.archiveOption);
            archive.click();
            driver.findElement(Locators.confirmOption).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifies the deleted notes.
     */
    public static void verifyDeletedNotes() {
            driver.findElement(Locators.navMenu).click();
            driver.findElement(Locators.trash).click();
            try {
                String note4 = driver.findElement(Locators.textNote4).getText();
                String note2 = driver.findElement(Locators.textNote2).getText();
                Assert.assertEquals(note4, "Text4");
                Assert.assertEquals(note2, "Text2");
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.navigate().back();
    }

    /**
     * Verifies the archived notes.
     */
    public static void verifyArchivedNotes() {
        try {
            driver.findElement(Locators.navMenu).click();
            driver.findElement(Locators.archive).click();
            try {
                String note1 = driver.findElement(Locators.textNote1).getText();
                Assert.assertEquals(note1, "Text1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes a screenshot with the given file name.
     *
     * @param fileName The name of the screenshot file.
     * @throws IOException If there is an error while taking the screenshot.
     */
    public static void screenshot(String fileName) throws IOException {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("C:\\Users\\Diksha.Popli\\IdeaProjects\\color-Notepad-Assessment\\src\\ScreenShots\\" + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
