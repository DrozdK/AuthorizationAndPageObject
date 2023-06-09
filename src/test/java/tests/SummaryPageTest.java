package tests;

import enums.Color;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static enums.DashboardItem.*;
import static enums.Widget.*;
import static helpers.MainHelper.*;
import static helpers.SummaryPageHelper.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SummaryPageTest {

    @BeforeAll
    public void setUp() {
        goToTheMainPage();
    }

    @Test
    public void shouldHaveAllDashboardItems() {
        //given
        List<String> items = new ArrayList<>();
        items.add(DATA_INTERVAL.getItem());
        items.add(TOTAL_ORDERS.getItem());
        items.add(TOTAL_WINNING_ORDERS.getItem());
        items.add(TOTAL_LOSING_ORDERS.getItem());
        //when
        DASHBOARD.shouldBe(visible);
        //then
        Assertions.assertEquals(getDashboardItems(), items);
    }

    @Test
    public void shouldHaveAllWidgetItems() {
        //given
        List<String> widgets = new ArrayList<>();
        widgets.add(ORDERS_GRID.getWidget());
        widgets.add(ALGO_PERFORMANCE.getWidget());
        widgets.add(ORDERS_BY_INSTRUMENT_OR_ALGO.getWidget());
        widgets.add(PRICE_BY_INSTRUMENT.getWidget());
        widgets.add(PRICE_BY_CURRENCY.getWidget());
        widgets.add(ORDERS_BY_ALGO.getWidget());
        widgets.add(ORDERS_BY_INSTRUMENT.getWidget());
        widgets.add(ALGO_PERFORMANCE_TIMELINE.getWidget());
        widgets.add(ORDERS_BY_ALGO_TIMELINE.getWidget());
        //when
        WIDGETS.shouldBe(visible);
        //then
        Assertions.assertEquals(getWidgets(), widgets);
    }

    @Test
    public void shouldCheckAlgoPerformanceWidget() {
        //given
        String negativeSquare = "Negative";
        String positiveSquare = "Positive";
        String neutralSquare = "Neutral";
        //when
        WIDGETS.shouldBe(visible);
        expandWidget(ALGO_PERFORMANCE_TIMELINE.getWidget());
        //then
        DASHBOARD.shouldBe(visible);
        TIMELINE_CONTAINER.shouldBe(visible);
        getColorSquare(negativeSquare).shouldHave(cssValue("background-color", Color.RED_COLOR.getColor()));
        getColorSquare(positiveSquare).shouldHave(cssValue("background-color", Color.GREEN_COLOR.getColor()));
        getColorSquare(neutralSquare).shouldHave(cssValue("background-color", Color.GRAY_COLOR.getColor()));
        //when
        collapseWidget(ALGO_PERFORMANCE_TIMELINE.getWidget());
    }

    @AfterAll
    public void tearDown() {
        closeBrowser();
    }
}
