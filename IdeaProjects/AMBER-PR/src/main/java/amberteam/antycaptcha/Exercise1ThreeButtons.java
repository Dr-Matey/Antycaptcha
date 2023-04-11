package amberteam.antycaptcha;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Exercise1ThreeButtons extends MainPage {

    public Exercise1ThreeButtons(Page page) {
        super(page);
    }

    public String userGetsExpectedResult() {
        return page.innerText("//td[contains(text(),'Trail set to:')]/code");
    }

    public void userClicksTheTaskButtonsInTheCorrectOrder() {
        String b1 = "b1";
        String b2 = "b2";
        String expectedValue = "";
        for (int i = 1; i <= 5; i += 2) {
            if (userGetsExpectedResult().charAt(i) == '1') {
                page.click("//button[@id='btnButton1']");
                expectedValue = getExpectedValue(i, 1, expectedValue, b1);
                expectedValue = getExpectedValue(i, 3, expectedValue, b1);
                expectedValue = getExpectedValue(i, 5, expectedValue, b1);
            } else {
                page.click("//button[@id='btnButton2']");
                expectedValue = getExpectedValue(i, 1, expectedValue, b2);
                expectedValue = getExpectedValue(i, 3, expectedValue, b2);
                expectedValue = getExpectedValue(i, 5, expectedValue, b2);
            }
        }
    }

    public void userClicksCheckSolutionButton() {
        page.click("//button[@id='solution']");
    }

    public void userChecksIfSolutionIsCorrect() {
        assertThat(page.locator("//code[@class='wrap']")).containsText("OK. Good answer");
    }

    private String getExpectedValue(int currentLoopIteration, int expectedLoopValue,
                                    String expectedValue, String buttonNumber) {
        if (currentLoopIteration == expectedLoopValue) {
            int button1 = page.querySelectorAll("//pre[@id='trail']" +
                    "//code[contains(text(),'" + expectedValue + buttonNumber + "')]").size();
            while (button1 != 1) {
                button1 = page.querySelectorAll("//pre[@id='trail']" +
                        "//code[contains(text(),'" + expectedValue + buttonNumber + "')]").size();
            }
            expectedValue = expectedValue + buttonNumber;
        }
        return expectedValue;
    }
}