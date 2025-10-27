package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printRoundMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<String> result) {
        for (String line : result) {
            System.out.println(line);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnerLine = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerLine);
    }
}
