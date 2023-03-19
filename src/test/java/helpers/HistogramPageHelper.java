package helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HistogramPageHelper {
    public static final SelenideElement HISTOGRAM_CONTAINER = $x("//div[@class='histogram-container']");
    public static final SelenideElement HISTOGRAM_SETTINGS_CONTAINER = $x("//div[@class='histogram-controls']");
    public static final SelenideElement OPEN_ATTRIBUTE_DROPDOWN = $x("//div[text()='Attribute']/..//deltix-ng-autocomplete/div");

    public static void selectAttributeByValue(String value) {
        OPEN_ATTRIBUTE_DROPDOWN.click();
        $x("//div[@class='autocomplete-dropdown-menu-wrapper']//ul//li[@title='"+value+"']").click();
        OPEN_ATTRIBUTE_DROPDOWN.click();
    }

    public static void getAttributeTitle(String value) {
        $x("//input[@title='"+value+"']").shouldBe(visible);
    }
}
