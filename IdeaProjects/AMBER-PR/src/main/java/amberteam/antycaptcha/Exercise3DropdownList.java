package amberteam.antycaptcha;

import com.microsoft.playwright.Page;

import java.util.Objects;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Exercise3DropdownList extends MainPage {

    public Exercise3DropdownList(Page page) {
        super(page);
    }

    public String userGetsExpectedOption() {
        return page.innerText("(//td/code)[1]");
    }

    public void userSelectExpectedOption() {
        page.locator("select").selectOption(userGetsExpectedOption());
        isOptionSelectedCorrect();
    }

    public String getSolutionCode() {
        return page.innerText("(//td)[3]/code");
    }

    public void isOptionSelectedCorrect() {
        boolean compersionResult;
        do {
            compersionResult = Objects.equals(getSolutionCode(), page.innerText("//code[@class='wrap']"));

            if (compersionResult) {
                compersionResult = false;
            } else {
                compersionResult = true;
                page.reload();
                page.locator("select").selectOption(userGetsExpectedOption());
            }
        } while (compersionResult);
    }

    public void userClicksCheckSolutionButton() {
        page.click("//button[@id='solution']");
    }

    public void userChecksIfSolutionIsCorrect() {
        assertThat(page.locator("//code[@class='wrap']")).containsText("OK. Good answer");
    }
}
