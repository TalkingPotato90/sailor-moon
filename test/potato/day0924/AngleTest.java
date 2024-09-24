package potato.day0924;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("각도기 테스트")
class AngleTest {
    private Angle angle;

    @BeforeEach
    void createInstance() {
        angle = new Angle();
    }

    @Test
    @DisplayName("직각 테스트")
    void check90Degree() {
        assertThat(angle.angle(90)).isEqualTo(2);
    }

    @Test
    @DisplayName("평각 테스트")
    void check180Degree() {
        assertThat(angle.angle(180)).isEqualTo(4);
    }

    @Test
    @DisplayName("예각 테스트")
    void checkSmallDegree() {
        assertThat(angle.angle(1)).isEqualTo(1);
        assertThat(angle.angle(89)).isEqualTo(1);
    }

    @Test
    @DisplayName("둔각 테스트")
    void checkLargeDegree() {
        assertThat(angle.angle(91)).isEqualTo(3);
        assertThat(angle.angle(179)).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 범위 초과 예외 테스트")
    void checkDegreeRange() {
        assertThatThrownBy(() -> angle.angle(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> angle.angle(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> angle.angle(181)).isInstanceOf(IllegalArgumentException.class);
    }


}