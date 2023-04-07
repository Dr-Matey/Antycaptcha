package amberteam.antycaptcha;

import com.microsoft.playwright.*;

public class MainPage {

    Page page;

    public MainPage(Page page){
        this.page = page;
    }

    public static void openMainPage(Page page) {
        page.navigate("http://antycaptcha.amberteam.pl/");
    }

    public void openExercise1() {
        page.click("//a[contains(@href,'exercise1')]");
    }

    public void openExercise2() {
        page.click("//a[contains(@href,'exercise2')]");
    }

    public void openExercise3() {
        page.click("//a[contains(@href,'exercise3')]");
    }

    public void openExercise4() {
        page.click("//a[contains(@href,'exercise4')]");
    }
}

