package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    @DisplayName("랜덤 값이 4 이상이면 position이 1 증가한다")
    void carMovesWhenRandomNumberIsGreaterOrEqualThan4() {
        // given
        RacingCar car = new RacingCar("pobi");

        // when
        Map<Integer, Integer> result = car.move();

        // then
        int randomNumber = result.keySet().iterator().next();
        int position = result.values().iterator().next();

        // 검증
        if (randomNumber >= 4) {
            assertThat(position).isEqualTo(1);
        } else {
            assertThat(position).isEqualTo(0);
        }
    }


    @Test
    @DisplayName("자동차는 이름을 가진다")
    void carHasName() {
        RacingCar car = new RacingCar("pobi");

        assertThat(car.getCarName()).isEqualTo("pobi");
    }
}