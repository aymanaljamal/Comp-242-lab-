package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DriverLab0 extends Application {

	static MyList<Name> list = new MyList<>(16);

	Tab tab = new Tab();
	BorderPane pane = new BorderPane();
	

	public static void read() throws FileNotFoundException {
		File file = new File("Namelist.txt");

		try (Scanner scan = new Scanner(file)) {
			while (scan.hasNext()) {
				String line = scan.nextLine();
				String[] linesplit = line.split(",");

				if (linesplit.length == 3) {
					String name = linesplit[0];
					String gender = linesplit[1];
					String number = linesplit[2];

					if (gender != null && !gender.isEmpty()) {
						list.add(new Name(name, gender, number));
					} else {
						System.out.println("Invalid gender value in the file.");

					}
				} else {
					System.out.println("Invalid line format in the file.");

				}
			}
		}
	}

	public static void WriteToFile(Name berson) {

		String fileName = "Namelist.txt";

		try {

			FileWriter fileWriter = new FileWriter(fileName, true);

			PrintWriter printWriter = new PrintWriter(fileWriter);

			printWriter.println(berson.toString());

			printWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void start(Stage primaryStage) {
		try {

			TextField textcomboo = new TextField();
			textcomboo.setPromptText("=============");
			Button butadd = new Button("       add           ");
			butadd.setOnAction(e -> add(primaryStage));

			Button butfind = new Button("         find        ");
			butfind.setOnAction(e -> find(primaryStage));

			Button butsize = new Button("        size         ");

			TextField textsize = new TextField();
			butsize.setOnAction(e -> textsize.setText("" + list.size()));
			Button butclear = new Button("        clear       ");
			TextField textclear = new TextField();
			butclear.setOnAction(e -> {
				list.clear();
				textclear.setText("It has been cleaned");
			});
			Button butdelet = new Button("     delete      ");
			butdelet.setOnAction(e -> delete(primaryStage));

			Button butisEmpty = new Button("      isEmpty         ");
			TextField textisEmpty = new TextField();
			butisEmpty.setOnAction(e -> textisEmpty.setText(" " + list.isEmpty()));
			Button butlodd = new Button("       lodd           ");
			Button butcleaning = new Button("       cleaning           ");
			Button but = new Button("Display information");
			ComboBox<String> comboBox = new ComboBox<>();
			comboBox.setOnAction(e -> comboBoxEvant(comboBox, textcomboo));
			ComboBox<String> comboBox1 = new ComboBox<>();
			comboBox.getItems().addAll("The most gender", "The least gender", "Number of men", "Number of women");
			comboBox.setValue("Choose one");
			VBox vBox = new VBox(10);

			GridPane gridPane = new GridPane();
			gridPane.setHgap(10);
			gridPane.setVgap(5);
			gridPane.setPadding(new Insets(30, 50, 50, 30));

			gridPane.add(butadd, 0, 0);
			gridPane.add(butfind, 1, 0);
			gridPane.add(butdelet, 2, 0);
			gridPane.add(butsize, 0, 1);
			gridPane.add(textsize, 1, 1);
			gridPane.add(butclear, 0, 2);
			gridPane.add(textclear, 1, 2);
			gridPane.add(butisEmpty, 0, 3);
			gridPane.add(textisEmpty, 1, 3);
			gridPane.add(comboBox, 0, 5);
			gridPane.add(butlodd, 0, 6);
			gridPane.add(butcleaning, 1, 6);

			gridPane.add(textcomboo, 1, 5);
			gridPane.setAlignment(Pos.CENTER);
			butlodd.setOnAction(e -> {
				try {
					read();
				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}
			});
			butcleaning.setOnAction(e -> {
				textcomboo.clear();
				textclear.clear();
				textsize.clear();
				textisEmpty.clear();
			});
			pane.setCenter(gridPane);
			pane.setAlignment(gridPane, Pos.CENTER);
			HBox hBox2 = new HBox(10);
	        RadioButton option1 = new RadioButton("Green");
	        RadioButton option2 = new RadioButton("Red");
	        RadioButton option3 = new RadioButton("Blue");
	        RadioButton option4 = new RadioButton("White");
	        ToggleGroup group = new ToggleGroup();
	        option1.setToggleGroup(group);
	        option2.setToggleGroup(group);
	        option3.setToggleGroup(group);
	        option4.setToggleGroup(group);
	        Scene scene = new Scene(pane, 600, 400);
	        option2.setOnAction(e -> scene.getRoot().setStyle("-fx-background-color: red;"));
	        option1.setOnAction(e -> scene.getRoot().setStyle("-fx-background-color: green;"));
	        option3.setOnAction(e -> scene.getRoot().setStyle("-fx-background-color: blue;"));
	        option4.setOnAction(e -> scene.getRoot().setStyle("-fx-background-color: white;"));

	        hBox2.getChildren().addAll(option1, option2, option3, option4);

	        hBox2.setPadding(new Insets(20));

	        hBox2.setAlignment(Pos.CENTER);
	        pane .setBottom(hBox2);
			tab.setText("Lab 0");
			tab.setContent(pane);
			
			primaryStage.setScene(scene);
            primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
        launch(args);
    }

	public void add(Stage Stage) {
		Label labname = new Label("name");
		Label labgndar = new Label("gender");
		Label labfrequency = new Label("frequency");
		TextField textname = new TextField();
		TextField textgndar = new TextField();
		TextField textfrequency = new TextField();
		Button butadd = new Button("       add           ");
		GridPane gridPane = new GridPane();
		gridPane.add(labname, 0, 0);
		gridPane.add(textname, 1, 0);
		gridPane.add(labgndar, 0, 1);
		gridPane.add(textgndar, 1, 1);
		gridPane.add(labfrequency, 0, 2);
		gridPane.add(textfrequency, 1, 2);
		
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(butadd);
		gridPane.add(hBox, 0, 3);
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		gridPane.setPadding(new Insets(10));
		Scene scene = new Scene(gridPane, 300, 200);
		butadd.setOnAction(e -> {
			String name = textname.getText().trim();
			String gender = textgndar.getText().trim();
			String frequency = textfrequency.getText().trim();

			Name newName = new Name(name, gender, frequency);

			list.add(newName);

			WriteToFile(newName);
		});
		Stage.setScene(scene);

	}

	public void find(Stage Stage) {
		Label labname = new Label("name");

		TextField textname = new TextField();

		Button butfind = new Button("       find          ");
		
		GridPane gridPane = new GridPane();
		gridPane.add(labname, 0, 0);
		gridPane.add(textname, 1, 0);
		
		Label labfind = new Label("");
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(butfind);
		gridPane.add(hBox, 0, 3);
		gridPane.add(labfind, 1, 3);
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		gridPane.setPadding(new Insets(10));
		Scene scene = new Scene(gridPane, 300, 200);

		butfind.setOnAction(e -> {

			if (find(textname.getText().trim())) {
				labfind.setText("I found it >__<");
				labfind.setFont(Font.font(15));
			} else {
				labfind.setText("I didn't find it <------>");
				labfind.setFont(Font.font(15));
			}
		});

		Stage.setScene(scene);

	}

	public void delete(Stage Stage) {
		Label labname = new Label("name");

		TextField textname = new TextField();

		Button butdelete = new Button("       delete         ");
		GridPane gridPane = new GridPane();
		gridPane.add(labname, 0, 0);
		gridPane.add(textname, 1, 0);
		
		Label labdelete = new Label("");
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(butdelete);
		gridPane.add(hBox, 0, 3);
		gridPane.add(labdelete, 1, 3);
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		gridPane.setPadding(new Insets(10));
		Scene scene = new Scene(gridPane, 300, 200);
		butdelete.setOnAction(e -> {
			String name = textname.getText().trim();
			if (delete(name)) {
				labdelete.setText("Operation accomplished successfully");
				labdelete.setFont(Font.font(15));
			} else {
				labdelete.setText("The operation was not completed successfully");
				labdelete.setFont(Font.font(15));
			}
		});
		Stage.setScene(scene);

	}

	private static void comboBoxEvant(ComboBox comboBox, TextField textField) {
		String ayman = (String) comboBox.getValue();
		int countF = 0, countM = 0, max = 0, man = 0;
		String mostFrequent = "", lestFrequent = "";

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getGender().charAt(0) == 'M') {
				countM += Integer.parseInt(list.get(i).getFrequency());
			} else {
				countF += Integer.parseInt(list.get(i).getFrequency());
			}
		}

		if (countF > countM) {

			mostFrequent = "F";
			lestFrequent = "M";
		} else {

			mostFrequent = "M";
			lestFrequent = "F";

		}

		switch (ayman) {
		case "The most gender":
			textField.setText(" " + mostFrequent);
			break;
		case "The least gender":
			textField.setText(" " + lestFrequent);
			break;
		case "Number of men":
			textField.setText(" " + countM);
			break;
		case "Number of women":
			textField.setText(" " + countF);
			break;

		default:
			break;
		}

	}

	public boolean find(String name) {
		if (name != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null && list.get(i).getName().compareTo(name) == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean delete(String name) {
		if (name != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null && list.get(i).getName().compareTo(name) == 0) {
					for (int j = i; j < list.size() - 1; j++) {
						list.set(list.get(j + 1), j);
					}
					list.set(null, list.count - 1);

					list.setcount(list.count - 1);

					return true;
				}
			}
		}
		return false;
	}

	public Tab getTab() {
		return this.tab;
	}

	public void setTab(Tab tab) {
		this.tab = tab;
	}

	public BorderPane getPane() {
		return this.pane;
	}

	public void setPane(BorderPane pane) {
		this.pane = pane;
	}
	
}
