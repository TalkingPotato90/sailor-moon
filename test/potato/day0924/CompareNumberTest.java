package potato.day0924;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("숫자 비교 테스트")
class CompareNumberTest {
    private CompareNumber compareNumber;

    @BeforeEach
    void createInstance() {
        compareNumber = new CompareNumber();
    }

    @Test
    @DisplayName("숫자가 같을 때")
    void checkMatchNumber() {
        assertThat(compareNumber.checkNumber(2, 2)).isEqualTo(1);
        assertThat(compareNumber.checkNumber(234, 234)).isEqualTo(1);
        assertThat(compareNumber.checkNumber(7777, 7777)).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 다를 때")
    void checkUnatchNumber() {
        assertThat(compareNumber.checkNumber(1, 2)).isEqualTo(-1);
        assertThat(compareNumber.checkNumber(293, 23)).isEqualTo(-1);
        assertThat(compareNumber.checkNumber(999, 9999)).isEqualTo(-1);
    }

    @Test
    @DisplayName("범위 밖 파라미터 예외처리")
    void checkNumberRange() {
        assertThatThrownBy(() -> compareNumber.checkNumber(-1,9999)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> compareNumber.checkNumber(-1,10000)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> compareNumber.checkNumber(0,10001)).isInstanceOf(IllegalArgumentException.class);
    }

}