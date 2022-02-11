package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

	private final NumberPicker numberPicker;
	private final InputView inputView;
	private final OutputView outputView;

	public RacingCarController(NumberPicker numberPicker, InputView inputView, OutputView outputView) {
		this.numberPicker = numberPicker;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		Cars cars = initCars();
		Round round = initRound();
		playGame(cars, round);
		announceWinners(cars);
	}

	private Cars initCars() {
		outputView.printMessageOfRequestCarNames();
		return new Cars(inputView.requestCarNames());
	}

	private Round initRound() {
		outputView.printMessageOfRequestRound();
		return new Round(inputView.requestGameRound());
	}

	private void playGame(Cars cars, Round round) {
		outputView.printEmptyLine();
		outputView.printMessageTitleOfStatus();
		while (!round.isFinish()) {
			cars.play(numberPicker);
			outputView.printCarStatuses(cars.getStatuses());
			round.decreaseCount();
			outputView.printEmptyLine();
		}
	}

	private void announceWinners(Cars cars) {
		outputView.printMessageOfWinners(cars.getWinnerNames());
	}
}
