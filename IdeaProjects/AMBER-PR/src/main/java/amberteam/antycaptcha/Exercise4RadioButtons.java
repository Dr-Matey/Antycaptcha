package amberteam.antycaptcha;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Exercise4RadioButtons extends MainPage {

    public Exercise4RadioButtons(Page page) {
        super(page);
    }

    public String userGetsExpectedOutcome() {
        return page.innerText("//td[contains(text(),'Trail set to:')]/code");
    }

    public void userGetsExpectedValuesAndSelectCorrectOptions() throws InterruptedException {
        String step0 = "v" + userGetsExpectedOutcome().substring(1, 2) + "0";
        String step1 = "v" + userGetsExpectedOutcome().substring(4, 5) + "1";
        String step2 = "v" + userGetsExpectedOutcome().substring(7, 8) + "2";
        String step3 = "v" + userGetsExpectedOutcome().substring(10, 11) + "3";
        page.click("//input[@value='" + step0 + "']");
        Thread.sleep(100);
        page.click("//input[@value='" + step1 + "']");
        Thread.sleep(100);
        page.click("//input[@value='" + step2 + "']");
        Thread.sleep(100);
        page.click("//input[@value='" + step3 + "']");
        Thread.sleep(100);
    }

    public void userClicksCheckSolutionButton() throws InterruptedException {
        page.click("//button[@id='solution']");
        Thread.sleep(100);
    }

    public void userChecksIfSolutionIsCorrect() {
        assertThat(page.locator("//code[@class='wrap']")).containsText("OK. Good answer");
    }
}