package helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ScatterPlotPageHelper {

    public static final SelenideElement SCATTER_PLOT_CONTAINER = $x("//div[@class='scatter-plot-container']");
    public static final SelenideElement SCATTER_PLOT_SETTINGS = $x("//div[@class='visualization__controls']");
    public static final SelenideElement SCATTER_PLOT_X_ATTRIBUTE_NAME = $("text.scatter-plot-x-label");
    public static final SelenideElement SCATTER_PLOT_Y_ATTRIBUTE_NAME = $("text.scatter-plot-y-label");
    public static final SelenideElement SCATTER_PLOT_POINT = $("g.scatter_element");
    public static final SelenideElement SCATTER_PLOT_TABLE = $x("//div[@ref='rootWrapperBody']/../../..//ag-grid-angular[contains(@class, 'flex-1')]");
}