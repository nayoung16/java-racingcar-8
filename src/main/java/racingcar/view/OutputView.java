package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printRoundMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<List<String>> roundResults) {
        for (List<String> round : roundResults) {
            for (String result : round) {
                System.out.println(result);
            }
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnerLine = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerLine);
    }
}
