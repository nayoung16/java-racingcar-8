package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void printRoundMessage() {
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // when
        OutputView.printRoundMessage();

        // then
        assertThat(outContent.toString()).contains("실행 결과");
    }

    @Test
    void printRoundResult() {
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        List<String> roundSnapshot = List.of(
                "pobi : --",
                "woni : -",
                "jun : "
        );

        // when
        OutputView.printRoundResult(roundSnapshot);

        // then
        String output = outContent.toString();
        assertThat(output)
                .contains("pobi : --")
                .contains("woni : -")
                .contains("jun :");
    }

    @Test
    void printWinners() {
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        List<String> winners = List.of("pobi", "jun");

        // when
        OutputView.printWinners(winners);

        // then
        String output = outContent.toString().trim();
        assertThat(output).isEqualTo("최종 우승자 : pobi, jun");
    }
}