package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RacingServiceTest {
    @Test
    @DisplayName("자동차 이름 리스트로 레이스를 시작하면 각 자동차가 정상적으로 생성된다")
    void startRace_createsCarsSuccessfully() {
        // given
        RacingService service = new RacingService();
        List<String> carNames = List.of("pobi", "woni", "jun");

        // when
        List<List<String>> roundResults = service.startRace(carNames, 1);

        // then
        assertThat(roundResults).isNotEmpty();
        assertThat(roundResults.get(0)).hasSize(3);
        assertThat(roundResults.get(0).get(0)).contains("pobi :");
    }

    @Test
    @DisplayName("시도 횟수(tryCount)만큼 라운드 결과가 생성된다")
    void startRace() {
        // given
        RacingService service = new RacingService();
        List<String> carNames = List.of("pobi", "woni");
        int tryCount = 5;

        // when
        List<List<String>> roundResults = service.startRace(carNames, tryCount);

        // then
        assertThat(roundResults).hasSize(tryCount);
    }

    @Test
    @DisplayName("라운드별 결과 문자열이 자동차 이름과 위치를 포함한다")
    void getCurrentPositions() {
        // given
        RacingService service = new RacingService();
        List<String> carNames = List.of("pobi", "woni");
        int tryCount = 1;

        // when
        List<List<String>> roundResults = service.startRace(carNames, tryCount);
        List<String> firstRound = roundResults.get(0);

        // then
        assertThat(firstRound.get(0)).matches("pobi : [-]*");
        assertThat(firstRound.get(1)).matches("woni : [-]*");
    }

    @Test
    @DisplayName("endRace()는 최종 우승자를 반환한다 (공동 우승 포함)")
    void endRace_returnsWinnersCorrectly() {
        // given
        RacingService service = new RacingService();
        List<String> carNames = List.of("pobi", "woni", "jun");
        service.startRace(carNames, 3);

        // when
        List<RacingCar> cars = List.of(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("jun")
        );
        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();

        List<String> winners = service.endRace();

        // then
        assertThat(winners).isNotEmpty();
        assertThat(winners).containsAnyOf("pobi", "woni", "jun");
    }
}