package amberteam.antycaptcha;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {

    Page page;
    static Logger logger = LoggerFactory.getLogger(MainPage.class);

    public MainPage(Page page) {
        this.page = page;
    }

    public static void openMainPage(Page page) {
        logger.info("User opens antycaptcha.amberteam main page.");
        page.navigate("http://antycaptcha.amberteam.pl/");
    }

    public void userOpensExercise(int exerciseNumber) {
        logger.info("User opens Exercise " + exerciseNumber + ".");
        page.click("//a[contains(@href,'exercise" + exerciseNumber + "')]");
    }
}