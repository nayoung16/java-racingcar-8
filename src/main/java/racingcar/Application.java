package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.CarNameValidator;
import racingcar.validation.TryCountValidator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        List<String> validatedNames = CarNameValidator.validate(carNames);
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();
        int validatedNum = TryCountValidator.validate(tryCount);
    }
}
