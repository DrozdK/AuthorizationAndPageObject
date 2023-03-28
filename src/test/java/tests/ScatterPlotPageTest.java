package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static enums.Column.*;
import static enums.Column.PRICE_AMOUNT;
import static enums.MenuItem.*;
import static helpers.MainHelper.*;
import static helpers.ScatterPlotPageHelper.*;

public class ScatterPlotPageTest {

    @BeforeAll
    static void setUp() {
        goToTheMainPage();
        clickToTheButtonMenu(SCATTER.getItem());
    }

    static Stream<Arguments> getXAttributeParams() {
        return Stream.of(
                Arguments.of(AVG_FILL_PRICE.getColumn(), AVG_FILL_PRICE.getColumn()),
                Arguments.of(NUM_OF_EXECUTIONS.getColumn(), NUM_OF_EXECUTIONS.getColumn()),
                Arguments.of(PRICE.getColumn(), PRICE.getColumn()),
                Arguments.of(SIZE.getColumn(), SIZE.getColumn()),
                Arguments.of(EXECUTION_PRICE_VOLATILITY.getColumn(), EXECUTION_PRICE_VOLATILITY.getColumn()),
                Arguments.of(PERMANENT_MARKET_IMPACT.getColumn(), PERMANENT_MARKET_IMPACT.getColumn()),
                Arguments.of(REALIZED_MARKET_IMPACT.getColumn(), REALIZED_MARKET_IMPACT.getColumn()),
                Arguments.of(PARTICIPATION_RATE.getColumn(), PARTICIPATION_RATE.getColumn()),
                Arguments.of(SHORTFALL.getColumn(), SHORTFALL.getColumn()),
                Arguments.of(MULTIPLIER.getColumn(), MULTIPLIER.getColumn()),
                Arguments.of(TICK_SIZE.getColumn(), TICK_SIZE.getColumn()),
                Arguments.of(CURRENCY_CODE.getColumn(), CURRENCY_CODE.getColumn()),
                Arguments.of(SEQUENCE_NUMBER.getColumn(), SEQUENCE_NUMBER.getColumn()),
                Arguments.of(DB_SEQUENCE_NUMBER.getColumn(), DB_SEQUENCE_NUMBER.getColumn()),
                Arguments.of(BENCHMARK_PRICE.getColumn(), BENCHMARK_PRICE.getColumn()),
                Arguments.of(EXEC_SIZE.getColumn(), EXEC_SIZE.getColumn()),
                Arguments.of(PRICE_TICKS.getColumn(), PRICE_TICKS.getColumn()),
                Arguments.of(PRICE_AMOUNT.getColumn(), PRICE_AMOUNT.getColumn())
        );
    }

    static Stream<Arguments> getYAttributeParams() {
        return Stream.of(
                Arguments.of(AVG_FILL_PRICE.getColumn(), AVG_FILL_PRICE.getColumn()),
                Arguments.of(EXEC_SIZE.getColumn(), EXEC_SIZE.getColumn()),
                Arguments.of(NUM_OF_EXECUTIONS.getColumn(), NUM_OF_EXECUTIONS.getColumn()),
                Arguments.of(PRICE.getColumn(), PRICE.getColumn()),
                Arguments.of(SIZE.getColumn(), SIZE.getColumn()),
                Arguments.of(EXECUTION_PRICE_VOLATILITY.getColumn(), EXECUTION_PRICE_VOLATILITY.getColumn()),
                Arguments.of(PERMANENT_MARKET_IMPACT.getColumn(), PERMANENT_MARKET_IMPACT.getColumn()),
                Arguments.of(REALIZED_MARKET_IMPACT.getColumn(), REALIZED_MARKET_IMPACT.getColumn()),
                Arguments.of(PARTICIPATION_RATE.getColumn(), PARTICIPATION_RATE.getColumn()),
                Arguments.of(SHORTFALL.getColumn(), SHORTFALL.getColumn()),
                Arguments.of(MULTIPLIER.getColumn(), MULTIPLIER.getColumn()),
                Arguments.of(TICK_SIZE.getColumn(), TICK_SIZE.getColumn()),
                Arguments.of(CURRENCY_CODE.getColumn(), CURRENCY_CODE.getColumn()),
                Arguments.of(SEQUENCE_NUMBER.getColumn(), SEQUENCE_NUMBER.getColumn()),
                Arguments.of(DB_SEQUENCE_NUMBER.getColumn(), DB_SEQUENCE_NUMBER.getColumn()),
                Arguments.of(BENCHMARK_PRICE.getColumn(), BENCHMARK_PRICE.getColumn()),
                Arguments.of(PRICE_TICKS.getColumn(), PRICE_TICKS.getColumn()),
                Arguments.of(PRICE_AMOUNT.getColumn(), PRICE_AMOUNT.getColumn())
        );
    }

    static Stream<Arguments> getIntervalParams() {
        return Stream.of(
                Arguments.of("5", "5"),
                Arguments.of("10", "10"),
                Arguments.of("25", "25"),
                Arguments.of("50", "50")
        );
    }

    @ParameterizedTest
    @MethodSource("getXAttributeParams")
    public void shouldChooseXAttribute(String value, String expected) {
        //given
        String name = "X Attribute";
        //when
        selectByValue(name, value);
        //then
        SCATTER_PLOT_X_ATTRIBUTE_NAME.shouldHave(text(expected));
    }

    @ParameterizedTest
    @MethodSource("getYAttributeParams")
    public void shouldChooseYAttribute(String value, String expected) {
        //given
        String name = "Y Attribute";
        //when
        selectByValue(name, value);
        //then
        SCATTER_PLOT_Y_ATTRIBUTE_NAME.shouldHave(text(expected));
    }

    @ParameterizedTest
    @MethodSource("getIntervalParams")
    public void shouldChooseInterval(String value, String expected) {
        //given
        String name = "Intervals";
        //when
        selectByValue(name, value);
        //then
        getDropDownTitle(expected);
    }

    @Test
    public void shouldCheckScatterPlotPage() {
        //then
        SCATTER_PLOT_CONTAINER.shouldBe(visible);
        SCATTER_PLOT_SETTINGS.shouldBe(visible);
    }

    @Test
    public void shouldCheckScatterPlotPoint() {
        //when
        SCATTER_PLOT_POINT.click();
        //then
        SCATTER_PLOT_TABLE.shouldBe(visible);
    }

    @AfterAll
    static void tearDown() {
        closeBrowser();
    }
}
