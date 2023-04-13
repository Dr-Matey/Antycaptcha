package amberteam.antycaptcha;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainPage {

    Page page;
    Logger logger = LoggerFactory.getLogger(MainPage.class);


    public MainPage(Page page) {
        this.page = page;
    }

    public static void openMainPage(Page page) {
        System.out.println("User opens antycaptcha.amberteam main page.");
        page.navigate("http://antycaptcha.amberteam.pl/");
    }

    public void openExercise(int exerciseNumber) {
        System.out.println("User opens Exercise"+exerciseNumber+" page");
        page.click("//a[contains(@href,'exercise" + exerciseNumber + "')]");
    }
}