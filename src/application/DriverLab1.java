package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DriverLab1 extends Application {

	GridPane gridPane = new GridPane();

	@Override
	public void start(Stage primaryStage) {
		lab1 lab11 = new lab1();
		gridPane.setHgap(10);
		gridPane.setVgap(5);
		gridPane.setPadding(new Insets(30, 50, 50, 30));

		Button Sum = new Button("Sum of num digit");

		Button butBinary = new Button("Binary search");
		Button butReverse = new Button("Reverse each character in the word");
		Button butpower = new Button("power of digit");
		Button butletters = new Button("The number of letters in a sentence");
		Button butcleaning = new Button("cleaning");
		double buttonWidth = 100;
		Sum.setMinWidth(buttonWidth);
		butBinary.setMinWidth(buttonWidth);
		butReverse.setMinWidth(buttonWidth);
		butpower.setMinWidth(buttonWidth);
		butletters.setMinWidth(buttonWidth);
		butcleaning.setMinWidth(buttonWidth);
		double buttonHeight = 25;
		Sum.setMinHeight(buttonHeight);
		butBinary.setMinHeight(buttonHeight);
		butReverse.setMinHeight(buttonHeight);
		butpower.setMinHeight(buttonHeight);
		butletters.setMinHeight(buttonHeight);
		butcleaning.setMinHeight(buttonHeight);
		TextField textSum = new TextField();
		textSum.setPromptText("Enter the number");
		TextField textBinary = new TextField();
		textBinary.setPromptText("n1,n2,n3,....");
		TextField textreverse = new TextField();
		textreverse.setPromptText("Enter the sentence");
		TextField textPower = new TextField();
		textPower.setPromptText("Enter n,power");

		TextField textBinary1 = new TextField();
		textBinary1.setPromptText("Enter kay");
		TextField textcountCher = new TextField();
		textcountCher.setPromptText("Enter the sentence");
		TextField textcountCher2 = new TextField();
		textcountCher2.setPromptText("Enter the char");
		Label lab1 = new Label(" ===========");
		Label lab2 = new Label(" ===========");
		Label lab3 = new Label(" ===========");
		Label lab4 = new Label(" ===========");
		Label lab5 = new Label(" ===========");
		Label lab6 = new Label(" ===========");

		textSum.setMinWidth(buttonWidth);
		textBinary.setMinWidth(buttonWidth);
		textreverse.setMinWidth(buttonWidth);
		textPower.setMinWidth(buttonWidth);
		textcountCher.setMinWidth(buttonWidth);
		textBinary1.setMinWidth(buttonWidth);

		textSum.setMinHeight(buttonHeight);
		textBinary.setMinHeight(buttonHeight);
		textreverse.setMinHeight(buttonHeight);
		textPower.setMinHeight(buttonHeight);
		textBinary1.setMinHeight(buttonHeight);
		textcountCher.setMinHeight(buttonHeight);
		textcountCher2.setMinHeight(buttonHeight);
		gridPane.add(Sum, 0, 0);
		gridPane.add(textSum, 1, 0);
		gridPane.add(lab1, 2, 0);
		gridPane.add(butBinary, 0, 1);
		gridPane.add(textBinary, 1, 1);

		gridPane.add(lab2, 3, 1);
		gridPane.add(textBinary1, 2, 1);
		gridPane.add(butReverse, 0, 2);
		gridPane.add(textreverse, 1, 2);
		gridPane.add(lab3, 2, 2);
		gridPane.add(butpower, 0, 3);
		gridPane.add(textPower, 1, 3);
		gridPane.add(lab4, 2, 3);
		gridPane.add(butletters, 0, 4);
		gridPane.add(textcountCher, 1, 4);
		gridPane.add(textcountCher2, 2, 4);
		gridPane.add(lab5, 3, 4);
		gridPane.add(butcleaning, 2, 5);
		Sum.setOnAction(e -> {
			try {
				lab1.setText(" " + lab11.SumDigits(Integer.parseInt(textSum.getText())));
				lab1.setTextFill(Color.GOLD);
				lab1.setFont(Font.font(15));
			}

			catch (Exception e1) {
				lab1.setText(" " + "Read the text, then enter. ");
				lab1.setTextFill(Color.RED);
				lab1.setFont(Font.font(15));
			}

		});
		butBinary.setOnAction(e -> {
			try {
				String s = textBinary.getText();

				String[] numbr = s.split(",");
				int[] arrya = new int[numbr.length];
				int g = 0;
				int kay = 0;
				for (int i = 0; i < numbr.length; i++) {
					g = Integer.parseInt(numbr[i].trim());
					arrya[i] = g;
				}
				kay = Integer.parseInt(textBinary1.getText().trim());
				lab2.setText(" " + lab11.binarySearch(arrya, kay));
				lab2.setTextFill(Color.GOLD);
				lab2.setFont(Font.font(15));
			}

			catch (Exception e1) {
				lab2.setText(" " + "Read the text, then enter.");
				lab2.setTextFill(Color.RED);
				lab2.setFont(Font.font(15));
			}

		});
		butReverse.setOnAction(e -> {
			try {
				lab3.setText(" " + lab11.reverse(textreverse.getText()));
				lab3.setTextFill(Color.GOLD);
				lab3.setFont(Font.font(15));
			}

			catch (Exception e1) {
				lab3.setText(" " + "Read the text, then enter.");
				lab3.setTextFill(Color.RED);
				lab3.setFont(Font.font(15));
			}

		});
		butpower.setOnAction(e -> {
			try {
				String s = textPower.getText();
				String[] numper = s.split(",");
				int num = Integer.parseInt(numper[0]);
				int pow = Integer.parseInt(numper[1]);
				lab4.setText(" " + lab11.Power(num, pow));
				lab4.setTextFill(Color.GOLD);
				lab4.setFont(Font.font(15));
			}

			catch (Exception e1) {
				lab4.setText(" " + "Read the text, then enter.");
				lab4.setTextFill(Color.RED);
				lab4.setFont(Font.font(15));
			}

		});
		butletters.setOnAction(e -> {
			try {
				String s = textcountCher.getText();
				char c = textcountCher2.getText().trim().charAt(0);

				lab5.setText(" " + lab11.countCher(s, c));
				lab5.setTextFill(Color.GOLD);
				lab5.setFont(Font.font(15));
			}

			catch (Exception e1) {
				lab5.setText(" " + "Read the text, then enter.");
				lab5.setTextFill(Color.RED);
				lab5.setFont(Font.font(15));
			}

		});
		butcleaning.setOnAction(e -> {
			textSum.clear();
			textBinary.clear();
			textreverse.clear();
			textPower.clear();
			textcountCher.clear();
			textBinary1.clear();
			textSum.clear();

			textBinary.clear();

			textreverse.clear();

			textPower.clear();

			textBinary1.clear();

			textcountCher.clear();

			textcountCher2.clear();
			
			lab1.setText(" ===========");
			lab1.setTextFill(Color.BLACK);
			lab2.setText(" ===========");
			lab2.setTextFill(Color.BLACK);
			lab3.setText(" ===========");
			lab3.setTextFill(Color.BLACK);
			lab4.setText(" ===========");
			lab4.setTextFill(Color.BLACK);
			lab5.setText(" ===========");
			lab5.setTextFill(Color.BLACK);
			lab6.setText(" ===========");
			lab6.setTextFill(Color.BLACK);
		});
		gridPane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(gridPane, 800, 510);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
	}

}
