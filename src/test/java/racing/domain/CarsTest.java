package racing.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("정상적인 Cars 객체 생성")
    void createCars() {
        assertThatCode(() -> new Cars("pobi,crong,honux")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("겹치는 자동차 이름이 존재하면 예외")
    void createCarsWithDuplicateName() {
        assertThatThrownBy(() -> new Cars("pobi, pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
