package helpers;

import com.codeborne.selenide.*;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class SummaryPageHelper {

    public static final SelenideElement DASHBOARD = $x("//div[contains(@class, 'summary-dashboard__totals')]");
    public static final SelenideElement WIDGETS = $x("//div[contains(@class, 'direction')]/../..");
    public static final SelenideElement TIMELINE_CONTAINER = $x("//div[@class='bar-chart-container']");

    public static List<String> getDashboardItems(){
        ElementsCollection dashboardItems = Selenide.$$x("//div[contains(@class, 'dashboard__title')]");
        List<String> item = new ArrayList<>();
        dashboardItems.forEach(x -> item.add(x.getOwnText()));
        return item;
    }

    public static List<String> getWidgets(){
        ElementsCollection widgets = Selenide.$$x("//div[contains(@class, 'app-title') and contains(@class, 'widget__header')]");
        List<String> widget = new ArrayList<>();
        widgets.forEach(x -> widget.add(x.getOwnText()));
        return widget;
    }

    public static void expandWidget(String widgetName){
        $x("//div[text()='"+widgetName+"']/..//div[@title='Expand']").click();
    }

    public static void collapseWidget(String widgetName){
        $x("//div[text()='"+widgetName+"']/..//div[@title='Collapse']").click();
    }

    public static SelenideElement getColorSquare(String square){
        SelenideElement element = $x("//div[@title='"+square+"']/../div[1]");
        return element;
    }
}
