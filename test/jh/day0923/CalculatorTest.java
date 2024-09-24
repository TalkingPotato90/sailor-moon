package jh.day0923;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("계산기 테스트")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void createInstance() {
        calculator = new Calculator();
    } // createInstance

    @Test
    @DisplayName("더하기 테스트")
    void testPlus() { // 왜 default 일까?
        assertEquals(3, calculator.plus(1, 2));
        assertEquals(5, calculator.plus(2, 3));
        assertEquals(2, calculator.plus(1, 1));
        assertEquals(-1, calculator.plus(0, -1));
        assertEquals(0, calculator.plus(1, -1));
        assertEquals(-5, calculator.plus(-2, -3));
    } // testPlus

    @Test
    @DisplayName("나누기 테스트")
    void testDivide() {
        assertEquals(1, calculator.divide(2, 2));
    } // testDivide

    @Test
    @DisplayName("나누기 예외 테스트")
    void testDivideException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    } // testDivideException

    @Test
    @DisplayName("빼기 테스트")
    void testMinus() {
        assertThat(1).isEqualTo(calculator.minus(3, 2));
    } // testMinus

} // class