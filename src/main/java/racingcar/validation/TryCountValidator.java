package racingcar.validation;

public class TryCountValidator {
    private static final String NULL_OR_BLANK_ERROR = "이동 횟수를 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR = "이동 횟수는 숫자만 입력할 수 있습니다.";
    private static final String NOT_POSITIVE_ERROR = "이동 횟수는 1 이상의 정수여야 합니다.";

    public static int validate(String input) {
        validateRawInput(input);
        int validatedIfNumber = validateIfNumber(input);
        validateIfPositiveNumber(validatedIfNumber);
        return validatedIfNumber;
    }

    public static void validateRawInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_BLANK_ERROR);
        }
    }

    public static int validateIfNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    public static void validateIfPositiveNumber(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR);
        }
    }
}
