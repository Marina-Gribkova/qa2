package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommentPage {

    private final By TITLE = By.xpath(".//h1[contains(@class, 'article-title')]");
    private BaseFunc baseFunc;

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        return baseFunc.findElement(TITLE).getText();
    }

}

