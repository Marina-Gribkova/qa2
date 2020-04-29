package PageObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TitleTests {

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void titleCheck () {
        baseFunc.openHomePage();

        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle = homePage.getTitleById(2);
        homePage.goToArticleById(2);

        ArticlePage articlePage = new ArticlePage(baseFunc);
        String articlePageTitle = articlePage.getTitle();

        CommentPage commentPage = new CommentPage(baseFunc);
        String commentPageTitle = commentPage.getTitle();

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong title text!");
        Assertions.assertEquals(homePageTitle, commentPageTitle,"Wrong title text!");

        baseFunc.closeBrowser();
    }
}
