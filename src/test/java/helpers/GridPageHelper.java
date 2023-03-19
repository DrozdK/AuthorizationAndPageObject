package helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class GridPageHelper {

    public static final SelenideElement GRID_CONTAINER = $x("//div[contains(@class, 'fullscreen')]");
    public static final SelenideElement ORDER_ANALYTICS_BUTTON = $x("(//div[contains(@class,'action-icon') and contains(@title,'analytics ')])[1]");
    public static final SelenideElement ORDER_PARAMETERS_BUTTON = $x("(//div[contains(@class,'action-icon') and contains(@title,'parameters')])[1]");
    public static final SelenideElement EXECUTION_REPORTS_BUTTON = $x("(//div[contains(@class,'action-icon') and contains(@title,'reports')])[1]");
    public static final SelenideElement PDF_REPORT_BUTTON = $x("(//div[contains(@class,'action-icon') and contains(@title,'PDF')])[1]");
    public static final SelenideElement CHART_CONTAINER = $x("//div[text()='Chart']/../../../..");
    public static final SelenideElement EXECUTIONS_CONTAINER = $x("//div[text()='Executions']/../../../..");
    public static final SelenideElement ORDER_STATS_CONTAINER = $x("//div[contains(text(), 'stats')]/../../../..");
    public static final SelenideElement ORDER_PARAM_CONTAINER = $x("//div[contains(text(), 'params')]/../../../..");
    public static final SelenideElement BACK_TO_ORDERS_BUTTON = $x("//div[contains(@title, 'Back')]/..");
    public static final SelenideElement PARAMETERS_MODAL_WINDOW = $x("//div[@class='modal-content']/div[2]/div");
    public static final SelenideElement CLOSE_MODAL_WINDOW = $x("//button[@class='close']/span");
    public static final SelenideElement EXECUTION_REPORT_CONTAINER = $x("//div[contains(@class,'executions-grid')]/../..");
    public static final SelenideElement SUCCESS_MODAL_WINDOW = $x("//div[contains(@class, 'alert-success')]/..");
    public static final SelenideElement TOTAL_FIELD = $x("//div[@ref='eStatusBarLeft']//div[text()]");

    public static List<String> getAnalystsItems(){
        ElementsCollection items = Selenide.$$x("//div[contains(@class, 'align-items-center')]/b[@title]");
        List<String> item = new ArrayList<>();
        items.forEach(x -> item.add(x.getOwnText()));
        return item;
    }

    public static List<String> getGridColumnItems(){
        ElementsCollection items = Selenide.$$x("//div[@ref='eHeaderViewport']//div[@col-id]//div[@ref='eLabel']/span[text()]");
        List<String> item = new ArrayList<>();
        items.forEach(x -> item.add(x.getOwnText()));
        return item;
    }
}
