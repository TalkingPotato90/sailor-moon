package potato.day0926;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 포함 테스트")
class SubstringTest {

    private Substring substring;

    @BeforeEach
    void createInstance() {
        substring = new Substring();
    }

//    @Test
//    @DisplayName("길이 확인 1")
//    void myStringLengthCheck() {
//        assertThat(substring.validateLength("adkew")).isEqualTo(5);
//        assertThat(substring.validateLength("a")).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("길이 확인 2")
//    void targetLengthCheck() {
//        assertThat(substring.validateLength("sfdawkw")).isEqualTo(7);
//        // 예외 처리
////        assertThat(substring.validateLength("")).isEqualTo(0);
//    }

    // 반환형이 void로 바뀌면서 테스트가 갈 곳을 잃었다
    // 예외 처리하는 메서드는 void여도 괜찮지 않을까?
//    @Test
//    @DisplayName("소문자 확인")
//    void smallLetterCheck(){
//        assertThat(substring.validateLetter("asde")).isTrue();
//        // 예외 처리로 이동
////        assertThat(substring.validateLetter("as2de")).isFalse();
////        assertThat(substring.validateLetter("as@de")).isFalse();
////        assertThat(substring.validateLetter("Gasde")).isFalse();
////        assertThat(substring.validateLetter("asdeㄱ")).isFalse();
//    }

    //    @ParameterizedTest
//    @DisplayName("길이 통합 확인")
//    @CsvSource({"adkew, 5", "a, 1", "sfdawkw, 7"})
//    void integratedLengthTest(String str, int length) {
//        assertThat(substring.validateLength(str)).isEqualTo(length);
//    }

    @ParameterizedTest
    @DisplayName("길이 예외 확인")
    @ValueSource(strings = {"", " ", "      "})
    void lengthExceptionCheck(String input) {
        assertThatThrownBy(() -> substring.validateLength(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("소문자가 아니면 예외")
    @ValueSource(strings = {"as2de", "as@de", "Gasde", "asdeㄱ"})
    void letterExceptionCheck(String str) {
        assertThatThrownBy(() -> substring.validateLetter(str)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("포함 확인")
    @CsvSource({"banana, ana, 1", "banana, banana, 1", "owahrlwohewo, owjr, 0", "a, eowhorfa, 0"})
    void containCheck(String my_string, String target, int expected) {
        assertThat(substring.containSubstring(my_string, target)).isEqualTo(expected);
    }

}