package amberteam.antycaptcha;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Exercise1ThreeButtonsPage extends MainPage {

    public Exercise1ThreeButtonsPage(Page page) {
        super(page);
    }

    public String userGetsExpectedResult() {
        return page.innerText("//td[contains(text(),'Trail set to:')]/code");
    }

    public void userClicksTheTaskButtonsInTheCorrectOrder() {
        logger.info("User clicks correct buttons.");
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
        logger.info("User clicks 'CHECK SOLUTION' button.");
        page.click("//button[@id='solution']");
    }

    public void userChecksIfSolutionIsCorrect() {
        logger.info("User checks if solution is correct.");
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