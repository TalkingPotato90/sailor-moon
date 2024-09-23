package potato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("계산기 테스트")
class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void createInstance(){
        calculator = new Calculator();
    }

    @Test
    void testPlus(){
        assertEquals(3,calculator.plus(1,2));
        assertEquals(-1,calculator.plus(-4,3));
        assertEquals(4,calculator.plus(2,2));
    }

    @Test
    void testDivide(){
        assertEquals(1,calculator.divide(2,2));
    }

    @Test
    void testDivideException(){
        assertThrows(ArithmeticException.class,()->calculator.divide(1,0));
    }

    @Test
    @DisplayName("마이너스 테스트")
    void testMinus(){
        assertThat(calculator.minus(1,2)).isEqualTo(-1);
    }
}