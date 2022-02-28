package step_definitions;

import io.cucumber.java.en.Given;
import pages.LoginPage;

import java.awt.*;

public class Steps {

    @Given("I am on the login page Yandex")
    public void i_am_on_the_login_page_Yandex() throws AWTException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.informStupidPeople();
    }

}
