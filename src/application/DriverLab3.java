package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DriverLab3 extends Application {
	private GridPane gridPane = new GridPane();
	private BorderPane borderPane = new BorderPane();
	private DLinkedList<Integer> dLinkedList = new DLinkedList<>();

	@Override
	public void start(Stage primaryStage) {

		gridPane.setHgap(10);
		gridPane.setVgap(5);
		gridPane.setPadding(new Insets(50, 50, 50, 50));
		Button butlength = new Button("length");
		Button lengthRecursion = new Button("length Recursion");

		Button butfind = new Button("find");

		Button butadd = new Button("add");

		Button butdelete = new Button("delete");

		Button butPrintdata = new Button("Print data");

		Button butcleaning = new Button("cleaning");

		Button butRemove = new Button(" Remove Duplicate  ");
		Button butRemoveRecursion = new Button(" Remove Duplicate Recursion  ");

		Button buttravars = new Button("travars");
		Button buttravarsRecursive = new Button(" travars Recursive ");

		Button butreverseRecursion = new Button("reverse with Recursion ");
		Button buttravaersBakeRecursive = new Button("travaers Bake Recursive");
		Button buttravaersBake = new Button("travaers Bake  ");

		Button count = new Button("count data");
		Button butcountRecursive = new Button("count  data Recursive  ");

		TextArea textArea = new TextArea();
		double buttonWidth = 200;
		butlength.setMinWidth(buttonWidth);
		butfind.setMinWidth(buttonWidth);
		butadd.setMinWidth(buttonWidth);
		butdelete.setMinWidth(buttonWidth);
		butRemove.setMinWidth(buttonWidth);
		butcleaning.setMinWidth(buttonWidth);
		lengthRecursion.setMinWidth(buttonWidth);
		butRemove.setMinWidth(buttonWidth);
		butRemoveRecursion.setMinWidth(buttonWidth);

		buttravars.setMinWidth(buttonWidth);
		buttravarsRecursive.setMinWidth(buttonWidth);

		butreverseRecursion.setMinWidth(buttonWidth);

		buttravaersBakeRecursive.setMinWidth(buttonWidth);
		buttravaersBake.setMinWidth(buttonWidth);
		count.setMinWidth(buttonWidth);
		butcountRecursive.setMinWidth(buttonWidth);

		butreverseRecursion.setMinWidth(buttonWidth);
		double buttonHeight = 30;
		butlength.setMinHeight(buttonHeight);
		butfind.setMinHeight(buttonHeight);
		butadd.setMinHeight(buttonHeight);
		butdelete.setMinHeight(buttonHeight);
		butRemove.setMinHeight(buttonHeight);
		butcleaning.setMinHeight(buttonHeight);
		butreverseRecursion.setMinHeight(buttonHeight);
		lengthRecursion.setMinHeight(buttonHeight);
		butRemove.setMinHeight(buttonHeight);
		butRemoveRecursion.setMinHeight(buttonHeight);
		buttravars.setMinHeight(buttonHeight);
		buttravarsRecursive.setMinHeight(buttonHeight);

		butreverseRecursion.setMinHeight(buttonHeight);
		buttravaersBakeRecursive.setMinHeight(buttonHeight);
		buttravaersBake.setMinHeight(buttonHeight);
		count.setMinHeight(buttonHeight);
		butcountRecursive.setMinHeight(buttonHeight);

		TextField textlength = new TextField();
		textlength.setPromptText("---------");
		TextField textfind = new TextField();
		textfind.setPromptText("Enter the data to findit");
		TextField textadd = new TextField();
		textadd.setPromptText("Enter the  data to add");
		TextField textdelete = new TextField();
		textdelete.setPromptText("Enter the  data to delete");

		TextField textreverse = new TextField();
		textreverse.setPromptText("...............");

		Label lab1 = new Label(" ===========");

		textlength.setMinWidth(buttonWidth);
		textfind.setMinWidth(buttonWidth);
		textreverse.setMinWidth(buttonWidth);
		textadd.setMinWidth(buttonWidth);
		textdelete.setMinWidth(buttonWidth);
		textreverse.setMinWidth(buttonWidth);
		butPrintdata.setMinWidth(buttonWidth);
		textlength.setMinHeight(buttonHeight);
		textfind.setMinHeight(buttonHeight);
		textreverse.setMinHeight(buttonHeight);
		textadd.setMinHeight(buttonHeight);
		textdelete.setMinHeight(buttonHeight);
		textreverse.setMinHeight(buttonHeight);
		butPrintdata.setMinHeight(buttonHeight);

		gridPane.add(butlength, 0, 0);
		gridPane.add(lengthRecursion, 1, 0);

		gridPane.add(butadd, 0, 1);
		gridPane.add(textadd, 1, 1);

		gridPane.add(butfind, 0, 2);
		gridPane.add(textfind, 1, 2);

		gridPane.add(butdelete, 0, 3);
		gridPane.add(textdelete, 1, 3);

		gridPane.add(count, 0, 4);
		gridPane.add(butcountRecursive, 1, 4);
		gridPane.add(textlength, 2, 4);

		gridPane.add(buttravaersBakeRecursive, 0, 5);
		gridPane.add(buttravaersBake, 1, 5);
		gridPane.add(buttravars, 3, 5);
		gridPane.add(buttravarsRecursive, 2, 5);

		gridPane.add(butRemove, 0, 6);
		gridPane.add(butcleaning, 1, 6);

		VBox vbox = new VBox(10);
		HBox hbox = new HBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(butRemoveRecursion, butreverseRecursion, butPrintdata);
		vbox.getChildren().addAll(hbox, textArea);

		borderPane.setBottom(vbox);
		textArea.setPrefColumnCount(10);
		textArea.setPrefRowCount(3);
		textArea.setWrapText(true);
		textArea.setPromptText("All results of operations will appear here");
		borderPane.setCenter(gridPane);

		butlength.setOnAction(e -> {
			textArea.setText("The number of elements:" + dLinkedList.length());
		});
		lengthRecursion.setOnAction(e -> {
			textArea.setText("The number of elements:" + dLinkedList.lengthRecursive());
		});

		butadd.setOnAction(e -> {
			try {

				int num = Integer.parseInt(textadd.getText().trim());
				dLinkedList.insert(num);
				textArea.setText("Added successfully--->" + num);
			} catch (Exception e2) {
				textArea.setText(
						"Before adding, before deleting, and before performing the finding process, you must write a number in the boxes in front of you, please."
								+ "/n" + e2.toString());
			}
		});
		butfind.setOnAction(e -> {
			try {
				int num = Integer.parseInt(textfind.getText().trim());

				textArea.setText("I found it???--->" + dLinkedList.find(num));
			} catch (Exception e2) {
				textArea.setText(
						"Before adding, before deleting, and before performing the finding process, you must write a number in the boxes in front of you, please."
								+ "/n" + e2.toString());
			}
		});
		butdelete.setOnAction(e -> {
			try {
				int num = Integer.parseInt(textdelete.getText().trim());

				textArea.setText("Delete successfully:??-->" + dLinkedList.delete(num));
			} catch (Exception e2) {
				textArea.setText(
						"Before adding, before deleting, and before performing the finding process, you must write a number in the boxes in front of you, please."
								+ "/n" + e2.toString());
			}
		});

		butPrintdata.setOnAction(e -> {
			try {

				textArea.setText(dLinkedList.toString());
			} catch (Exception e2) {
				textArea.setText(e2.toString());
			}
		});

		butcleaning.setOnAction(e -> {
			textArea.clear();
			textlength.clear();
			textfind.clear();
			textreverse.clear();
			textadd.clear();
			textdelete.clear();
			textreverse.clear();
		});
		butRemove.setOnAction(e -> {
			try {
				dLinkedList.romoveDuplicate();
			} catch (Exception e2) {
				textArea.setText(e2.toString());
			}
		});
		butRemoveRecursion.setOnAction(e -> {
			try {
				dLinkedList.romoveDuplicateRecursive();
			} catch (Exception e2) {
				textArea.setText(e2.toString());
			}
		});
		buttravars.setOnAction(e -> {
			System.out.println("");
			dLinkedList.travars();
			textArea.setText("This process shows its results on the screen or console, not on Java FX");
		});
		butreverseRecursion.setOnAction(e -> {

			dLinkedList.reverseRecursive();
			textArea.setText("");
		});
		buttravaersBakeRecursive.setOnAction(e -> {
			System.out.println("");
			dLinkedList.travaersBakeRecursive();
			textArea.setText("This process shows its results on the screen or console, not on Java FX");
		});
		buttravaersBake.setOnAction(e -> {
			System.out.println("");
			dLinkedList.travaersBakeRecursive();
			textArea.setText("This process shows its results on the screen or console, not on Java FX");
		});
		butcountRecursive.setOnAction(e -> {
			try {
				int num = Integer.parseInt(textlength.getText().trim());

				textlength.setText("" + dLinkedList.countRecursive(num));
			} catch (Exception e2) {
				textArea.setText(
						"Before adding, before deleting, and before performing the finding process, you must write a number in the boxes in front of you, please."
								+ "/n" + e2.toString());
			}
		});
		count.setOnAction(e -> {
			try {
				int num = Integer.parseInt(textlength.getText().trim());

				textlength.setText("" + dLinkedList.count(num));
			} catch (Exception e2) {
				textArea.setText(
						"Before adding, before deleting, and before performing the finding process, you must write a number in the boxes in front of you, please."
								+ "/n" + e2.toString());
			}
		});
		buttravarsRecursive.setOnAction(e -> {
			System.out.println("");
			dLinkedList.travaersBakeRecursive();
			textArea.setText("This process shows its results on the screen or console, not on Java FX");
		});
		gridPane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(borderPane, 900, 600);
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

	public BorderPane getBorderPane() {
		return borderPane;
	}

	public void setBorderPane(BorderPane borderPane) {
		this.borderPane = borderPane;
	}
}
