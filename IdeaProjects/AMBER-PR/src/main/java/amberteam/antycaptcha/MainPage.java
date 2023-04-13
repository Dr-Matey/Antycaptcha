package amberteam.antycaptcha;

import com.microsoft.playwright.Page;


public class MainPage {

    Page page;

    public MainPage(Page page) {
        this.page = page;
    }

    public static void openMainPage(Page page) {
        page.navigate("http://antycaptcha.amberteam.pl/");
    }

    public void openExercise(int exerciseNumber) {
        page.click("//a[contains(@href,'exercise" + exerciseNumber + "')]");
    }
}