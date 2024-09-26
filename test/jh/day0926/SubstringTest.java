package jh.day0926;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("부분 문자열인지 확인")
public class SubstringTest {

    private Substring substring;

    @BeforeEach
    void createInstance() {
        substring = new Substring();
    } // createInstance

    @ParameterizedTest
    @DisplayName("my_string, target의 길이 확인")
    @CsvSource(value = {"banana, ''",
            "dfjsdifjdisddfjfsijsdfkjdsklfjsdlkfjlsdkfjsdklfjdsjfsdfjdksdkfjsdklfjsdklfjsdfsdfsdfdfsdfsfddsfsfsdfs, wxyz"})
    void testLength(String my_string, String target) {
        assertThat(substring.checkLength(my_string, target)).isFalse();
    } // testLength

    @ParameterizedTest
    @DisplayName("my_string, target이 영소문자인지 확인")
    @CsvSource(value = {"BANANA, NAN", "바나나, 나나"})
    void testLowerCase(String my_string, String target) {
        assertThat(substring.checkLowerCase(my_string, target)).isFalse();
    } // testLowCase

    @ParameterizedTest
    @DisplayName("부분 문자열 확인")
    @CsvSource(value = {"banana, nan, 1", "banana, wxyz, 0"})
    void testSubstring(String my_string, String target, int expected) {
        assertThat(substring.doesContainSubstring(my_string, target)).isEqualTo(expected);
    } // testSubstring

    @ParameterizedTest
    @DisplayName("예외 처리 확인")
    @CsvSource(value = {"banana, ''", "'', nana"})
    void testException(String my_string, String target) {
        assertThatThrownBy(() -> substring.doesContainSubstring(my_string, target))
                .isInstanceOf(IllegalArgumentException.class);
    } // testException

} // class