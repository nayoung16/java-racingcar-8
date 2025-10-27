package racingcar.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String SEPARATOR = ",";
    private static final String ERROR_MSG = "자동차 이름을 입력해 주세요.";
    private static final String EMTPY_ERROR_MSG = "자동차 이름은 비어 있을 수 없습니다.";

    public static List<String> validate(String input) {
        validateRawInput(input);
        List<String> splitNames = splitNames(input);
        validateEachName(splitNames);
        return splitNames;
    }

    public static void validateRawInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

    public static List<String> splitNames(String input) {
        return Arrays.stream(input.split(SEPARATOR, -1))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static void validateEachName(List<String> names) {
        for (String name : names) {
            validateSingleName(name);
        }
    }

    public static void validateSingleName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. (잘못된 값: " + name + ")");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMTPY_ERROR_MSG);
        }
    }

}
