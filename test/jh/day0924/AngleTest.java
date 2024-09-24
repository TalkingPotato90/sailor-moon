package jh.day0924;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("각도기 테스트")
public class AngleTest {

    private Angle angle;

    @BeforeEach
    void createInstance() { angle = new Angle(); } // createInstance

    @Test
    @DisplayName("예각 확인")
    void testAcute() {
        assertThat(angle.checkAngle(1)).isEqualTo(1);
        assertThat(angle.checkAngle(89)).isEqualTo(1);
        // assertThat(angle.checkAngle(0)).isEqualTo(1);
        // assertThat(angle.checkAngle(90)).isEqualTo(1);
    } // testAcute

    @Test
    @DisplayName("직각 확인")
    void testRight() {
        assertThat(angle.checkAngle(90)).isEqualTo(2);
    } // testRight

    @Test
    @DisplayName("둔각 확인")
    void testObtuse() {
        assertThat(angle.checkAngle(91)).isEqualTo(3);
        assertThat(angle.checkAngle(179)).isEqualTo(3);
        // assertThat(angle.checkAngle(90)).isEqualTo(3);
        // assertThat(angle.checkAngle(180)).isEqualTo(3);
    } // testObtuse

    @Test
    @DisplayName("평각 확인")
    void testSquare() {
        assertThat(angle.checkAngle(180)).isEqualTo(4);
    } // testSquare

    @Test
    @DisplayName("예외 확인")
    void testException() {
        assertThatThrownBy(() -> angle.checkAngle(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 0 초과 180 미만이어야 합니다.");

        assertThatThrownBy(() -> angle.checkAngle(181))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 0 초과 180 미만이어야 합니다.");
    } // testException

} // class