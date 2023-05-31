import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class HomePage {
    public void open() {
    }

    public ElementsCollection getCardElements() {
        return $$(".category-cards .card");
    }

    public void clickElementByText(String text) {
        ElementsCollection cardElements = getCardElements();
        for (SelenideElement card : cardElements) {
            SelenideElement cardBody = card.$(".card-body");
            SelenideElement element = cardBody.$(By.xpath(".//h5[text()='" + text + "']"));
            if (element.exists()) {
                element.click();
                break; // If you only want to click the first matching element, remove this line.
            }
        }
    }
}
