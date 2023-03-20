package helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HistogramPageHelper {
    public static final SelenideElement HISTOGRAM_CONTAINER = $x("//div[@class='histogram-container']");
    public static final SelenideElement HISTOGRAM_SETTINGS_CONTAINER = $x("//div[@class='histogram-controls']");
    public static final SelenideElement OPEN_ATTRIBUTE_DROPDOWN = $x("//div[text()='Attribute']/..//deltix-ng-autocomplete/div");
    public static final SelenideElement HISTOGRAM_NAME = $("text.histogram-x-label");
    public static final SelenideElement HISTOGRAM_COLUMN = $("g.bar_container rect:first-child");
    public static final SelenideElement HISTOGRAM_GRID_TABLE = $x("//div[@ref='rootWrapperBody']/../../..//ag-grid-angular[contains(@class, 'flex-1')]");
}
