package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void inputCarNames() {
        // given
        String fakeInput = "pobi,woni,jun\n";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes()));

        // when
        List<String> inputCarNames = InputView.inputCarNames();

        // then
        assertThat(inputCarNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void inputTryCount() {
        // given
        String fakeInput = "5\n";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes()));

        // when
        int tryCount = InputView.inputTryCount();

        // then
        assertThat(tryCount).isEqualTo(5);
    }
}