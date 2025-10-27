package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.CarNameValidator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        List<String> validatedNames = CarNameValidator.validate(carNames);
    }
}
