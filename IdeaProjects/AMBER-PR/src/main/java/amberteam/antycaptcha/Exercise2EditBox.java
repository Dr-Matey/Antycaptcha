package amberteam.antycaptcha;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Exercise2EditBox extends MainPage {

    public Exercise2EditBox(Page page) {
        super(page);
    }

    public String getExpectedResult() {
        return page.innerText("(//td/code)[1]");
    }

    public void userExecutesEditBoxExerciseSteps() {
        page.locator("xpath=//*[@id='t14']").fill(getExpectedResult());
        page.click("//button[@id='btnButton1']");
    }

    public void userClicksCheckSolutionButton() {
        page.click("//button[@id='solution']");
    }

    public void userChecksIfSolutionIsCorrect() {
        assertThat(page.locator("//code[@class='wrap']")).containsText("OK. Good answer");
    }
}