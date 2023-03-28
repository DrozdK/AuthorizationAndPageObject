package tests;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static enums.Column.*;
import static enums.MenuItem.GRID;
import static helpers.GridPageHelper.*;
import static helpers.MainHelper.*;
import static org.junit.jupiter.api.Assertions.*;

public class GridPageTest {

    @BeforeAll
    static void setUp() {
        goToTheMainPage();
        clickToTheButtonMenu(GRID.getItem());
    }

    @Test
    public void shouldCheckOrderAnalystsButton() {
        //given
        String orderAnalysts = "Order analytics dashboard";
        List<String> items = new ArrayList<>();
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
        openActionButton(orderAnalysts);
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
        String orderParameters = "Order parameters";
        //when
        GRID_CONTAINER.shouldBe(visible);
        openActionButton(orderParameters);
        //then
        PARAMETERS_MODAL_WINDOW.shouldHave(exactText(modalWindowText));
        //when
        CLOSE_MODAL_WINDOW.click();
    }

    @Test
    public void shouldCheckExecutionReportsButton() {
        //given
        String executionReports = "Execution reports";
        //when
        GRID_CONTAINER.shouldBe(visible);
        openActionButton(executionReports);
        //then
        EXECUTION_REPORT_CONTAINER.shouldBe(visible);
        //when
        CLOSE_MODAL_WINDOW.click();
    }

    @Test
    public void shouldCheckPDFReportButton() {
        //given
        String pdfReport = "PDF report";
        //when
        GRID_CONTAINER.shouldBe(visible);
        openActionButton(pdfReport);
        //then
        SUCCESS_MODAL_WINDOW.shouldBe(visible);
        //when
        CLOSE_MODAL_WINDOW.click();
    }

    @Test
    public void shouldCheckGridPage() {
        //given
        String text = "Total";
        List<String> columns = new ArrayList<>();
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
        //when
        GRID_CONTAINER.shouldBe(visible);
        //then
        assertEquals(columns, getGridColumnItems());
        TOTAL_FIELD.shouldHave(text(text));
    }

    @AfterAll
    static void tearDown() {
        closeBrowser();
    }
}
