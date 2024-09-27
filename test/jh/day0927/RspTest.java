package jh.day0927;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("가위바위보 입출력 테스트")
public class RspTest {

    private Rsp rsp;

    @BeforeEach
    void createInstance() {
        rsp = new Rsp();
    } // createInstance

    public static InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    } // generateInput

    @ParameterizedTest
    @DisplayName("입력 예외 테스트")
    @ValueSource(strings = {"가위아님", "바위아님", "보아님"})
    void testInputException(String input) {
        InputStream inputStream = generateInput(input);
        System.setIn(inputStream);

        assertThatThrownBy(() -> rsp.playRsp()).isInstanceOf(InputMismatchException.class)
                .hasMessage("가위/바위/보 중 하나만 입력 가능합니다.");
    } // testInput

    @ParameterizedTest
    @DisplayName("아웃풋 테스트")
    @CsvSource(value = {"가위, 바위", "바위, 보", "보, 가위"})
    void testOutput(String input, String output) {
        InputStream inputStream = generateInput(input);
        System.setIn(inputStream);

        assertThat(rsp.playRsp()).isEqualTo(output);
    } // testOutput

} // class