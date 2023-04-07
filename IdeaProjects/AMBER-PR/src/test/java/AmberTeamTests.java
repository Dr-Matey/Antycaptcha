import amberteam.antycaptcha.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

public class AmberTeamTests {
    public Playwright playwright;
    public Browser browser;
    public Page page;
    public MainPage mainPage;
    public Exercise1ThreeButtons exercise1ThreeButtons;
    public Exercise2EditBox exercise2EditBox;
    public Exercise3DropdownList exercise3DropdownList;
    public Exercise4RadioButtons exercise4RadioButtons;

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
        mainPage.openExercise1();

        exercise1ThreeButtons = new Exercise1ThreeButtons(page);
        exercise1ThreeButtons.userClicksTheTaskButtonsInTheCorrectOrder();
        exercise1ThreeButtons.userClicksCheckSolutionButton();
        exercise1ThreeButtons.userChecksIfSolutionIsCorrect();
    }

    @Test
    public void exercise2EditBox() {
        mainPage = new MainPage(page);
        mainPage.openExercise2();

        exercise2EditBox = new Exercise2EditBox(page);
        exercise2EditBox.getExpectedResult();
        exercise2EditBox.userExecutesEditBoxExerciseSteps();
        exercise2EditBox.userClicksCheckSolutionButton();
        exercise2EditBox.userChecksIfSolutionIsCorrect();
    }

    @Test
    public void exercise3DropdownList(){
        mainPage = new MainPage(page);
        mainPage.openExercise3();

        exercise3DropdownList = new Exercise3DropdownList(page);
        exercise3DropdownList.userSelectExpectedOption();
        exercise3DropdownList.userClicksCheckSolutionButton();
        exercise3DropdownList.userChecksIfSolutionIsCorrect();
    }

    @Test
    public void exercise4RadioButtons() throws InterruptedException {
        mainPage = new MainPage(page);
        mainPage.openExercise4();

        exercise4RadioButtons = new Exercise4RadioButtons(page);
        exercise4RadioButtons.userGetsExpectedValuesAndSelectCorrectOptions();
        exercise4RadioButtons.userClicksCheckSolutionButton();
        exercise4RadioButtons.userChecksIfSolutionIsCorrect();
    }
}
