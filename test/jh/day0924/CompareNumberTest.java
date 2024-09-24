package jh.day0924;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("숫자 비교 테스트")
public class CompareNumberTest {

    private CompareNumber compareNumber;

    @BeforeEach
    void createInstance() {
        compareNumber = new CompareNumber();
    } // createInstance

    @Test
    @DisplayName("같은지 확인")
    void isEqual() {
        assertThat(compareNumber.compareNumber(0, 0)).isEqualTo(1);
        assertThat(compareNumber.compareNumber(10000, 10000)).isEqualTo(1);
    } // isEqual

    @Test
    @DisplayName("다른지 확인")
    void isNotEqual() {
        assertThat(compareNumber.compareNumber(0, 10000)).isEqualTo(-1);
        assertThat(compareNumber.compareNumber(10000, 0)).isEqualTo(-1);
    } // isNotEqual

    @Test
    @DisplayName("예외 확인")
    void testException() {
        assertThatThrownBy(() -> compareNumber.compareNumber(-1, 10001))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> compareNumber.compareNumber(10001, -1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> compareNumber.compareNumber(-1, 10000))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> compareNumber.compareNumber(10000, -1))
                .isInstanceOf(IllegalArgumentException.class);
    } // testException

} // class