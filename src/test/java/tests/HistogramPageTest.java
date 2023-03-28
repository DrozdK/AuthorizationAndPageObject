package tests;

import org.junit.jupiter.api.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static enums.Column.*;
import static enums.MenuItem.*;
import static helpers.MainHelper.*;
import static helpers.HistogramPageHelper.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HistogramPageTest {

    @BeforeAll
    static void setUp() {
        goToTheMainPage();
        clickToTheButtonMenu(HISTOGRAM.getItem());
    }

    @Test
    public void shouldCheckHistogramPage() {
        //then
        HISTOGRAM_CONTAINER.shouldBe(visible);
        HISTOGRAM_SETTINGS_CONTAINER.shouldBe(visible);
    }

    static Stream<Arguments> getAttributeParams() {
        return Stream.of(
                Arguments.of(AVG_FILL_PRICE.getColumn(), AVG_FILL_PRICE.getColumn()),
                Arguments.of(EXEC_SIZE.getColumn(), EXEC_SIZE.getColumn()),
                Arguments.of(NUM_OF_EXECUTIONS.getColumn(), NUM_OF_EXECUTIONS.getColumn()),
                Arguments.of(PRICE.getColumn(), PRICE.getColumn()),
                Arguments.of(SIZE.getColumn(), SIZE.getColumn()),
                Arguments.of(EXECUTION_PRICE_VOLATILITY.getColumn(), EXECUTION_PRICE_VOLATILITY.getColumn()),
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
    @MethodSource("getAttributeParams")
    public void shouldChooseAttribute(String value, String expected) {
        //given
        String name = "Attribute";
        //when
        selectByValue(name, value);
        //then
        HISTOGRAM_NAME.shouldHave(text(expected));
    }

    @ParameterizedTest
    @MethodSource("getIntervalParams")
    public void shouldChooseInterval(String value, String expected) {
        //given
        String name = "Interval";
        //when
        selectByValue(name, value);
        //then
        getDropDownTitle(expected);
    }

    @Test
    public void shouldTableDisplayedWhenClickedOnTheValue() {
        //when
        HISTOGRAM_COLUMN.click();
        //then
        HISTOGRAM_GRID_TABLE.shouldBe(visible);
    }

    @AfterAll
    static void tearDown() {
        closeBrowser();
    }
}
