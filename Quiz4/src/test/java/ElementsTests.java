import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ElementsTests {

    public ElementsTests() {
        Configuration.timeout = 3000;
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize ="1920x1080";
    }
    @Test
    public void TestOne() {
        // Open the home page
        open("/");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickElementByText("Elements");
        SelenideElement element = $("#" + "item-2" + " span").shouldHave(Condition.text("Radio Button"));
        element.click();
        element = $("#impressiveRadio");
        element.click();
        element = $("span.text-success");
        element.shouldHave(Condition.text("Impressive"));
    }
    @Test (dependsOnMethods = "TestOne")
    public void TestTwo() {
        open("/");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickElementByText("Elements");
        SelenideElement element = $("#" + "item-2" + " span").shouldHave(Condition.text("Buttons"));
        element.click();

    }
}