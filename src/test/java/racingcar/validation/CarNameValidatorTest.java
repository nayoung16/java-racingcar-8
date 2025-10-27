package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {

    @Test
    @DisplayName("쉼표로 구분된 자동차 이름들을 정상적으로 파싱하고 반환한다")
    void validate() {
        String input = "pobi,woni,jun";
        List<String> names = CarNameValidator.validate(input);
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("빈 문자열 또는 공백만 입력되면 예외를 던진다")
    void blankInput_throwsException() {
        assertThatThrownBy(() -> CarNameValidator.validate("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어 있을 수 없습니다");
    }

    @Test
    @DisplayName("자동차 이름이 비어 있으면 예외를 던진다 (예: 'pobi,' 처럼 마지막 이름 없음)")
    void emptyName_throwsException() {
        String input = "pobi,";
        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 던진다")
    void tooLongName_throwsException() {
        String input = "abcdef,car";

        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

}