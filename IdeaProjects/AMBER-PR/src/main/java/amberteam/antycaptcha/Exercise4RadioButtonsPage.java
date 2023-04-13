package amberteam.antycaptcha;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Exercise4RadioButtonsPage extends MainPage {

    public Exercise4RadioButtonsPage(Page page) {
        super(page);
    }

    public String userGetsExpectedOutcome() {
        return page.innerText("//td[contains(text(),'Trail set to:')]/code");
    }

    public void userGetsExpectedValuesAndSelectCorrectOptions() {
        logger.info("User clicks correct options");
        String step0 = "v" + userGetsExpectedOutcome().substring(1, 2) + "0";
        String step1 = "v" + userGetsExpectedOutcome().substring(4, 5) + "1";
        String step2 = "v" + userGetsExpectedOutcome().substring(7, 8) + "2";
        String step3 = "v" + userGetsExpectedOutcome().substring(10, 11) + "3";
        for (int i = 0; i < 5; i++) {
            page.click("//input[@value='" + step0 + "']");
            page.click("//input[@value='" + step1 + "']");
            page.click("//input[@value='" + step2 + "']");
            page.click("//input[@value='" + step3 + "']");
            if (page.querySelectorAll("//code[@class='wrap' and not(contains(text(),'-1'))]").size() > 0){
                break;
            }
        }
    }

    public void userClicksCheckSolutionButton() {
        page.click("//button[@id='solution']");
    }

    public void userChecksIfSolutionIsCorrect() {
        logger.info("User checks right answer");
        assertThat(page.locator("//code[@class='wrap']")).containsText("OK. Good answer");
    }
}