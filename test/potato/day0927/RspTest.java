package potato.day0927;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@DisplayName("가위바위보 테스트")
class RspTest {

    private Rsp rsp;

    @BeforeEach
    void createInstance(){
        rsp = new Rsp();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","감자","rocks"})
    @DisplayName("예외테스트")
    void inputExceptionTest(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(()->rsp.validateInput()).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"가위,바위","바위,보","보,가위"})
    @DisplayName("이기는 경우 테스트")
    void winningTest(String input, String output){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(rsp.game()).isEqualTo(output);
    }
}