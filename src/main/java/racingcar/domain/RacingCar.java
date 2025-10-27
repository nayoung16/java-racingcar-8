package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String carName;
    private int position;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.position += randomNumber;
        }
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
