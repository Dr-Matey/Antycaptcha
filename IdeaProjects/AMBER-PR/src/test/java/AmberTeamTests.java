import amberteam.antycaptcha.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AmberTeamTests {

    public Playwright playwright;
    public Browser browser;
    public Page page;
    public MainPage mainPage;
    public Exercise1ThreeButtonsPage exercise1ThreeButtonsPage;
    public Exercise2EditBoxPage exercise2EditBoxPage;
    public Exercise3DropdownListPage exercise3DropdownListPage;
    public Exercise4RadioButtonsPage exercise4RadioButtonsPage;

    @BeforeEach
    void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        MainPage.openMainPage(page);
    }

    @AfterEach
    void closeBrowser() {
        playwright.close();
    }

    @Test
    public void exercise1ThreeButtons() {
        mainPage = new MainPage(page);
        mainPage.openExercise(1);

        exercise1ThreeButtonsPage = new Exercise1ThreeButtonsPage(page);
        exercise1ThreeButtonsPage.userClicksTheTaskButtonsInTheCorrectOrder();
        exercise1ThreeButtonsPage.userClicksCheckSolutionButton();
        exercise1ThreeButtonsPage.userChecksIfSolutionIsCorrect();
    }

    @Test
    public void exercise2EditBox() {
        mainPage = new MainPage(page);
        mainPage.openExercise(2);

        exercise2EditBoxPage = new Exercise2EditBoxPage(page);
        exercise2EditBoxPage.userExecutesEditBoxExerciseSteps();
        exercise2EditBoxPage.userClicksCheckSolutionButton();
        exercise2EditBoxPage.userChecksIfSolutionIsCorrect();
    }

    @Test
    public void exercise3DropdownList() {
        mainPage = new MainPage(page);
        mainPage.openExercise(3);

        exercise3DropdownListPage = new Exercise3DropdownListPage(page);
        exercise3DropdownListPage.userSelectsExpectedOption();
        exercise3DropdownListPage.userClicksCheckSolutionButton();
        exercise3DropdownListPage.userChecksIfSolutionIsCorrect();
    }

    @Test
    public void exercise4RadioButtons() {
        mainPage = new MainPage(page);
        mainPage.openExercise(4);

        exercise4RadioButtonsPage = new Exercise4RadioButtonsPage(page);
        exercise4RadioButtonsPage.userGetsExpectedValuesAndSelectCorrectOptions();
        exercise4RadioButtonsPage.userClicksCheckSolutionButton();
        exercise4RadioButtonsPage.userChecksIfSolutionIsCorrect();
    }
}