package potato.day0925;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("숨어있는 숫자의 덧셈")
class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void createInstance() {
        stringCalculator = new StringCalculator();
    }

//    @Test
//    @DisplayName("파라미터 길이 확인")
//    void checkParameterLength(){
//        assertThat(stringCalculator.checkParameterLength("jdh293DSshA1").length()).isBetween(1,1000);
//        assertThat(stringCalculator.checkParameterLength("j").length()).isBetween(1,1000);
//    }

    @Test
    @DisplayName("길이 범위 초과시 예외")
    void checkParameter2() {
        assertThatThrownBy(() -> stringCalculator.checkParameter(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> stringCalculator.checkParameter("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("파라미터에 숫자가 없을 때 합계")
    void checkParameterContainsDigit() {
        assertThat(stringCalculator.add("wsoehwoDWoehaS")).isEqualTo(0);
    }

    @Test
    @DisplayName("파라미터에서 숫자 찾기")
    void checkParameterContainsDigit2() {
        assertThat(stringCalculator.setOnlyDigits("soehir2bkb1b3b4")).isEqualTo("2134");
    }

    @Test
    @DisplayName("숫자 합 계산")
    void checkAdd() {
        assertThat(stringCalculator.add("1ws23S5woEf")).isEqualTo(11);
    }

    @Test
    @DisplayName("알파벳과 정수외의 문자가 있으면 예외")
    void checkValidateParam() {
        assertThatThrownBy(() -> stringCalculator.add("-")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> stringCalculator.add("a!Towehdrbo")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> stringCalculator.add("일이삼사오")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("알파벳과 정수외의 문자가 있으면 예외2")
    @ValueSource(strings = {"-", "a!Towehdrbo", "일이삼사오"})
    void checkValidateParam2(String str) {
        assertThatThrownBy(() -> stringCalculator.add(str)).isInstanceOf(IllegalArgumentException.class);
    }


}