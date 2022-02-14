package racingcar.domain;

public class Car {

	private static final String PROGRESS_BAR = "-";
	private static final String COLON = " : ";
	private static final int GO_FORWARD_NUMBER = 4;
	private final Name name;
	private int location;

	public Car(Name name) {
		this.name = name;
	}

	private void increaseLocation() {
		this.location++;
	}

	public void goForwardOrStop(int pickNumber) {
		if (pickNumber >= GO_FORWARD_NUMBER) {
			increaseLocation();
		}
	}

	public boolean isWinner(int farthestLocation) {
		return location == farthestLocation;
	}

	@Override
	public String toString() {
		return name + COLON + PROGRESS_BAR.repeat(location);
	}

	public Name getName() {
		return this.name;
	}

	public int getLocation() {
		return this.location;
	}
}
