package amberteam.antycaptcha;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Exercise2EditBoxPage extends MainPage {

    public Exercise2EditBoxPage(Page page) {
        super(page);
    }

    public String getExpectedResult() {
        return page.innerText("(//td/code)[1]");
    }

    public void userExecutesEditBoxExerciseSteps() {
        logger.info("User enters correct text and clicks correct button.");
        page.locator("xpath=//*[@id='t14']").fill(getExpectedResult());
        page.click("//button[@id='btnButton1']");
    }

    public void userClicksCheckSolutionButton() {
        logger.info("User clicks 'CHECK SOLUTION' button.");
        page.click("//button[@id='solution']");
    }

    public void userChecksIfSolutionIsCorrect() {
        logger.info("User checks if solution is correct.");
        assertThat(page.locator("//code[@class='wrap']")).containsText("OK. Good answer");
    }
}