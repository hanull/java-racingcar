package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

	private final int numberOfGoForward = 5;
	private final int numberOfStop = 3;
	private Cars cars;

	@BeforeEach
	void setUpCars() {
		cars = new Cars(
			new Names(Arrays.asList(
				new Name("slow"),
				new Name("pobi"),
				new Name("if")
			))
		);
	}

	@Test
	void 우승자_한명_선정() {

		CustomNumberPicker customNumberPicker = new CustomNumberPicker(
			Arrays.asList(numberOfStop,
				numberOfGoForward,
				numberOfGoForward,
				numberOfStop,
				numberOfStop,
				numberOfGoForward)
		);

		cars.play(customNumberPicker);
		cars.play(customNumberPicker);

		List<String> winnerNames = cars.getWinnerNames();
		assertThat(winnerNames.size()).isEqualTo(1);

		assertThat(winnerNames.get(0)).isEqualTo("if");
	}

	@Test
	void 우승자_여러명_선정() {
		CustomNumberPicker customNumberPicker = new CustomNumberPicker(
			Arrays.asList(numberOfGoForward,
				numberOfGoForward,
				numberOfGoForward,
				numberOfGoForward,
				numberOfStop,
				numberOfGoForward)
		);

		cars.play(customNumberPicker);
		cars.play(customNumberPicker);

		List<String> winnerNames = cars.getWinnerNames();
		assertThat(winnerNames.size()).isEqualTo(2);

		List<String> expected = Arrays.asList("slow", "if");
		for (int i = 0; i < winnerNames.size(); i++) {
			assertThat(winnerNames.get(i)).isEqualTo(expected.get(i));
		}
	}
}
