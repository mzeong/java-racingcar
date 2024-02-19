package racing.domain;

import java.util.Collections;
import java.util.List;
import racing.util.MovableStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        validateDuplicate(cars);
    }

    private void validateDuplicate(List<Car> cars) {
        int count = (int) cars.stream().distinct().count();
        if (count != cars.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    public void moveAll(MovableStrategy movableStrategy) {
        cars.stream()
                .filter(car -> movableStrategy.isMove())
                .forEach(Car::move);
    }

    public List<Car> findWinners() {
        Collections.sort(cars);
        return cars.stream().filter(car -> car.isSame(cars.get(0))).toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
