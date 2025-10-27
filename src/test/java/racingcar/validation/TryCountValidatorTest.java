package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TryCountValidatorTest {

    @Test
    @DisplayName("정상 입력(양의 정수 문자열)은 int로 변환되어 반환된다")
    void validInput_returnsInt() {
        // given
        String input = "5";

        // when
        int result = TryCountValidator.validate(input);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("null 또는 공백 입력은 예외를 던진다")
    void blankInput_throwsException() {
        // null 입력
        assertThatThrownBy(() -> TryCountValidator.validate(null))
                .isInstanceOf(IllegalArgumentException.class);

        // 공백만 있는 입력
        assertThatThrownBy(() -> TryCountValidator.validate("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 값은 예외를 던진다 (예: 'abc', '1.5', '3a')")
    void nonNumericInput_throwsException() {
        assertThatThrownBy(() -> TryCountValidator.validate("abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> TryCountValidator.validate("1.5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> TryCountValidator.validate("3a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0 또는 음수 값은 예외를 던진다 (게임은 최소 1회 이상 시도해야 함)")
    void nonPositiveInput_throwsException() {
        assertThatThrownBy(() -> TryCountValidator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> TryCountValidator.validate("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}