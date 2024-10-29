package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class DriverLab6 extends Application {

	private SQueue<Integer> queue = new SQueue<>();

	private int min = 0;
	private int totalIn = 0;
	private int totalOut = 0;
	private int totalWaitingTime = 0;
	private VBox vbox = new VBox(10);
	private TextArea textArea = new TextArea();
	private Button startSimulation = new Button("Start Simulation");
	private TextField timeInput = new TextField();

	public int addCustomer() {
		Random random = new Random();
		int newCustomers = random.nextInt(4);
		if (newCustomers == 0 || newCustomers == 3) {
			return 0;
		} else if (newCustomers == 2) {
			queue.enqueue(min + 1);
			queue.enqueue(min + 1);
			totalIn += 2;
			return 2;
		} else {
			queue.enqueue(min + 1);
			totalIn++;
			return 1;
		}
	}

	public int[] processCustomer() {
		int waitingTime = 0;
		int pr = 0;
		if (!queue.isEmpty()) {
			int processTime = queue.dequeue();

			waitingTime = min - processTime + 1;
			totalWaitingTime += waitingTime;
			totalOut++;
			totalIn--;
			pr = 1;

		}
		int[] info = { pr, waitingTime };
		return info;
	}

	public void simulate(int time) {
		textArea.appendText(
				String.format("%-15s %-15s %-15s %-15s %-15s\n", "Min", "In", "Total", "Out", "Waiting Time"));
		textArea.appendText("-------------------------------------------------\n");
		for (int i = 0; i < time; i++) {
			min = i;
			int in = addCustomer();
			int[] out = processCustomer();
			textArea.appendText(String.format("%-15d %-15d %-15d %-15d %-30d\n", i, in, totalIn, out[0], out[1]));
		}
		while (!queue.isEmpty()) {
			min++;
			processCustomer();
		}
		double averageWaitingTime = (double) totalWaitingTime / totalOut;
		textArea.appendText("\nSimulation complete.\n");
		textArea.appendText(String.format("Average Waiting Time: %.2f minutes\n", averageWaitingTime));
	}

	@Override
	public void start(Stage primaryStage) {
		timeInput.setPromptText("Enter minutes for simulation");
		startSimulation.setOnAction(e -> {
			textArea.clear();
			queue.clear();
			min = 0;
			totalIn = 0;
			totalOut = 0;
			totalWaitingTime = 0;
			try {
				int time = Integer.parseInt(timeInput.getText().trim());
				simulate(time);
			} catch (NumberFormatException ex) {
				textArea.setText("Error: Please enter a valid integer for minutes.\n");
			}
		});

		HBox controls = new HBox(10, startSimulation, timeInput);
		controls.setPadding(new Insets(10));
		vbox.getChildren().addAll(controls, textArea);

		vbox.setPadding(new Insets(10));
		Scene scene = new Scene(vbox, 600, 400);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

}
