package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final List<RacingCar> cars = new ArrayList<>();

    public List<List<String>> startRace(List<String> carNames, int tryCount) {
        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(carName);
            cars.add(racingCar);
        }
        List<List<String>> roundResults = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            cars.forEach(RacingCar::move);
            roundResults.add(getCurrentPositions());
        }
        return roundResults;
    }

    private List<String> getCurrentPositions() {
        List<String> result = new ArrayList<>();
        for (RacingCar car : cars) {
            result.add(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        return result;
    }

    public List<String> endRace(List<RacingCar> cars) {
        int maxPosition = 0;
        List<String> wonCarNames = new ArrayList<>();
        for (RacingCar racingCar : cars) {
            if (racingCar.getPosition() >= maxPosition) {
                maxPosition = racingCar.getPosition();
                wonCarNames.add(racingCar.getCarName());
            }
        }
        return wonCarNames;
    }
}
