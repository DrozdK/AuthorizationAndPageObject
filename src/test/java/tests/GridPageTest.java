package tests;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static enums.Columns.*;
import static enums.MenuItems.GRID;
import static helpers.GridPageHelper.*;
import static helpers.Helper.*;
import static org.junit.jupiter.api.Assertions.*;

public class GridPageTest {

    @BeforeEach
    public void setUp(){
        goToTheMainPage();
        clickToTheButtonMenu(GRID.getItem());
    }

    @Test
    public void shouldCheckOrderAnalystsButton() {
        //given
        ArrayList<String> items = new ArrayList<>();
        items.add(ID.getColumn());
        items.add(TYPE.getColumn());
        items.add(SIDE.getColumn());
        items.add(INSTRUMENT.getColumn());
        items.add(AVG_FILL_PRICE.getColumn());
        items.add(EXEC_SIZE.getColumn());
        items.add(BENCHMARK_PRICE.getColumn());
        items.add(PRICE_TICKS.getColumn());
        items.add(PRICE_AMOUNT.getColumn());
        //when
        GRID_CONTAINER.shouldBe(visible);
        ORDER_ANALYTICS_BUTTON.click();
        BACK_TO_ORDERS_BUTTON.shouldBe(visible);
        //then
        assertEquals(items, getAnalystsItems());
        CHART_CONTAINER.shouldBe(visible);
        EXECUTIONS_CONTAINER.shouldBe(visible);
        ORDER_STATS_CONTAINER.shouldBe(visible);
        ORDER_PARAM_CONTAINER.shouldBe(visible);
        //when
        BACK_TO_ORDERS_BUTTON.click();
    }

    @Test
    public void shouldCheckOrderParametersButton() {
        //given
        String modalWindowText = " Order does not have any parameters. ";
        //when
        GRID_CONTAINER.shouldBe(visible);
        ORDER_PARAMETERS_BUTTON.click();
        //then
        PARAMETERS_MODAL_WINDOW.shouldHave(exactText(modalWindowText));
        //when
        CLOSE_MODAL_WINDOW.click();
    }

    @Test
    public void shouldCheckExecutionReportsButton() {
        //when
        GRID_CONTAINER.shouldBe(visible);
        EXECUTION_REPORTS_BUTTON.click();
        //then
        EXECUTION_REPORT_CONTAINER.shouldBe(visible);
        //when
        CLOSE_MODAL_WINDOW.click();
    }

    @Test
    public void shouldCheckPDFReportButton() {
        //when
        GRID_CONTAINER.shouldBe(visible);
        PDF_REPORT_BUTTON.click();
        //then
        SUCCESS_MODAL_WINDOW.shouldBe(visible);
        //when
        CLOSE_MODAL_WINDOW.click();
    }

    @Test
    public void shouldCheckGridPage() {
        //given
        String text = "Total";
        ArrayList<String> columns = new ArrayList<>();
        columns.add(ID.getColumn());
        columns.add(TYPE.getColumn());
        columns.add(INSTRUMENT.getColumn());
        columns.add(SIDE.getColumn());
        columns.add(START_TIME.getColumn());
        columns.add(END_TIME.getColumn());
        columns.add(EXEC_TYPE.getColumn());
        columns.add(AVG_FILL_PRICE.getColumn());
        columns.add(EXEC_SIZE.getColumn());
        columns.add(NUM_OF_EXECUTIONS.getColumn());
        columns.add(PRICE.getColumn());
        //when
        GRID_CONTAINER.shouldBe(visible);
        //then
        assertEquals(columns, getGridColumnItems());
        TOTAL_FIELD.shouldHave(text(text));
    }

    @AfterEach
    public void tearDown(){
        closeBrowser();
    }
}
