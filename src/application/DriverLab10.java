package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DriverLab10 extends Application {
	SHash<Martyr> hashTable1 = new SHash<>(10);
	OHashD<Martyr> hashTable2 = new OHashD<>(5);
	OHashQ<Martyr> hashTable3 = new OHashQ<>(5);
	OHashL<Martyr> hashTable4 = new OHashL<>(5);
	private FileChooser fileChooser = new FileChooser();

	@Override
	public void start(Stage stage) {
		Button loadButton = createButton("Load Data");

		Label label = createLabel("");
		Label label1 = createLabel("SHash Average Collisions: ");
		Label label2 = createLabel("OHashD Average Collisions: ");
		Label label3 = createLabel("OHashQ Average Collisions: ");
		Label label4 = createLabel("OHashL Average Collisions: ");

		loadButton.setOnAction(event -> {
			File file = fileChooser.showOpenDialog(stage);
			if (file != null) {
				processFile(file, label);
				label.setText("File loaded successfully.");
				label1.setText("SHash Average Collisions: " + hashTable1.getAverageCollisions());
				label2.setText("OHashD Average Collisions: " + hashTable2.getAverageCollisions());
				label3.setText("OHashQ Average Collisions: " + hashTable3.getAverageCollisions());
				label4.setText("OHashL Average Collisions: " + hashTable4.getAverageCollisions());
			} else {
				label.setText("No file selected.");
			}
		});

		VBox vBox = new VBox(20, loadButton, label, label1, label2, label3, label4);
		vBox.setAlignment(Pos.CENTER);
		vBox.setStyle("-fx-background-color: #D3D3D3;");

		Scene scene = new Scene(vBox, 500, 500);
		stage.setTitle("Data Processing");
		stage.setScene(scene);
		stage.show();
	}

	private void processFile(File file, Label statusLabel) {
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				try {
					processLine(line);
				} catch (Exception e) {
					System.out.println("Error processing line: " + line);
					e.printStackTrace();
				}
			}
			statusLabel.setText("File processed successfully.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			statusLabel.setText("File not found.");
		}
	}

	private boolean processLine(String line) {
		try {
			String[] info = line.split(",");
			if (info.length < 6) {
				return false;
			}

			String name = info[0].trim();
			String date = info[1].trim();
			String age = info[2].trim();

			String locationName = info[3].trim();
			String districtName = info[4].trim();
			String gender = info[5].trim();

			Martyr martyrInsert = new Martyr(name, age, locationName, date, gender, districtName);

			hashTable1.add(martyrInsert);
			hashTable2.add(martyrInsert);
			hashTable3.add(martyrInsert);
			hashTable4.add(martyrInsert);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private Button createButton(String text) {
		Button button = new Button(text);
		button.setMaxHeight(25);
		button.setMaxWidth(250);
		button.setFont(new Font("Arial", 14));
		button.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
		button.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
		return button;
	}

	private Label createLabel(String text) {
		Label label = new Label(text);
		label.setFont(new Font("Arial", 16));
		label.setTextFill(Color.BLACK);
		label.setPadding(new Insets(12, 24, 12, 24));
		return label;
	}

	public static void main(String[] args) {
		launch(args);
	}
}