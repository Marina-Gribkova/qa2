import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DelfiHomework {
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'article-title')]");
    private final By COMMENT_PAGE = By.xpath(".//a[contains(@class,'btn-comments')]");
    private final Logger LOGGER = LogManager.getLogger(DelfiFirstTest.class);

    private WebDriver driver;

    @Test
    public void delfiSecondTitleTest() {
        LOGGER.info("Setting up driver path");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        LOGGER.info("Opening browser");
        driver = new ChromeDriver();
        LOGGER.info("Maximizing window");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LOGGER.info("Opening Delfi home page");
        driver.get("http://rus.delfi.lv");
        LOGGER.info("Getting all articles");
        List<WebElement> articles = driver.findElements(ARTICLE_TITLE);
        LOGGER.info("Getting 2nd article");
        WebElement article = articles.get(1);
        LOGGER.info("Get and save this element text");
        String secondTitleText = articles.get(1).getText();
        LOGGER.info("Click on this element");
        articles.get(1).click();
        LOGGER.info("Find article's title element and save it");
        String articleTitleText = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        LOGGER.info("Check");
        Assertions.assertEquals(secondTitleText, articleTitleText, "Wrong title on article page!");
        LOGGER.info("Click on comment page");
        driver.findElement(COMMENT_PAGE).click();
        LOGGER.info("Find comment's title element and save it");
        String commentTitleText = driver.findElement(COMMENT_PAGE_TITLE).getText();
        LOGGER.info("Check");
        Assertions.assertEquals(secondTitleText, commentTitleText, "Wrong title on comment page!");


    }
    
    @AfterEach
    public void closeBrowser () {

        driver.close();
    }
}
