package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class RacingCar {
    private String carName;
    private int position;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public Map<Integer, Integer> move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.position ++;
        }
        return Map.of(randomNumber, this.position);
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
