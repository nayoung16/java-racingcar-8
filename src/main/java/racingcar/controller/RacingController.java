package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final RacingService racingService = new RacingService();

    public void run() {
        try {
            List<String> carNames = InputView.inputCarNames();
            int tryCount = InputView.inputTryCount();

            OutputView.printRoundMessage();

            List<List<String>> roundResults = racingService.startRace(carNames, tryCount);

            OutputView.printRoundResult(roundResults);

            List<String> winners = racingService.endRace();

            OutputView.printWinners(winners);

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
