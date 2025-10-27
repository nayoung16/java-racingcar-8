package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingControllerTest {

    @Test
    void run() {
        String fakeInput = "pobi,woni\n3\n";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RacingController controller = new RacingController();

        // when
        controller.run();

        // then
        String output = outContent.toString();

        assertThat(output).contains("실행 결과");
        assertThat(output).contains("pobi :");
        assertThat(output).contains("woni :");
        assertThat(output).contains("최종 우승자 :");
    }
}