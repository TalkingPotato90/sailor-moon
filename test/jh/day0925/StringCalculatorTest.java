package jh.day0925;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("숨어있는 숫자의 덧셈 테스트")
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void createInstance() {
        stringCalculator = new StringCalculator();
    } // createInstance

    @Test
    @DisplayName("파라미터의 길이 확인")
    void testLength() {
        assertThatThrownBy(() -> stringCalculator.plusNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    } // testLength

    @Test
    @DisplayName("합이 맞는지 확인")
    void testSum() {
        assertThat(stringCalculator.plusNumber("aAb1B2cC34oOp")).isEqualTo(10);
    } // testSum

    @Test
    @DisplayName("소문자, 대문자, 한자리 자연수 확인")
    void testParam() {
        assertThatThrownBy(() -> stringCalculator.plusNumber("aB"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> stringCalculator.plusNumber("ab1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> stringCalculator.plusNumber("1AB"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> stringCalculator.plusNumber("+*"))
                .isInstanceOf(IllegalArgumentException.class);
    } // testParam

} // class