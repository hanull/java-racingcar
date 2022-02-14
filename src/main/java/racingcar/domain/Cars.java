package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.controller.NumberPicker;

public class Cars {

	private final List<Car> cars = new ArrayList<>();

	public Cars(Names names) {
		names.getNames().forEach(name -> cars.add(new Car(name)));
	}

	public void play(NumberPicker numberPicker) {
		for (Car car : cars) {
			car.goForwardOrStop(numberPicker.pickNumber());
		}
	}

	public List<String> getStatuses() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.toList());
	}

	public List<String> getWinnerNames() {
		int farthestLocation = getFarthestLocation();
		return cars.stream()
			.filter(car -> car.isWinner(farthestLocation))
			.map(Car::getName)
			.map(Name::getName)
			.collect(Collectors.toList());
	}

	private int getFarthestLocation() {
		List<Integer> carLocations = cars.stream()
			.map(Car::getLocation)
			.collect(Collectors.toList());

		return Collections.max(carLocations);
	}
}
