package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DriverLab2 extends Application {

	private GridPane gridPane = new GridPane();
	private BorderPane borderPane = new BorderPane();
	private LinkedList<Integer> LinkedList = new LinkedList<>();

	@Override
	public void start(Stage primaryStage) {

		gridPane.setHgap(10);
		gridPane.setVgap(5);
		gridPane.setPadding(new Insets(50, 50, 50, 50));
		Button butlength = new Button("length");
		Button butfind = new Button("find");
		Button butadd = new Button("add");
		Button butdelete = new Button("delete");
		Button butPrintdata = new Button("Print data");
		Button butreverse = new Button("reverse");
		Button butreverseRecursion = new Button("reverse with Recursion ");
		TextArea textArea = new TextArea();
		Button butcleaning = new Button("cleaning");
		Button buttravars = new Button(" Print the ");
		double buttonWidth = 240;
		butlength.setMinWidth(buttonWidth);
		butfind.setMinWidth(buttonWidth);
		butadd.setMinWidth(buttonWidth);
		butdelete.setMinWidth(buttonWidth);
		butreverse.setMinWidth(buttonWidth);
		butcleaning.setMinWidth(buttonWidth);
		buttravars.setMinWidth(buttonWidth);
		butreverseRecursion.setMinWidth(buttonWidth);
		double buttonHeight = 50;
		butlength.setMinHeight(buttonHeight);
		butfind.setMinHeight(buttonHeight);
		butadd.setMinHeight(buttonHeight);
		butdelete.setMinHeight(buttonHeight);
		butreverse.setMinHeight(buttonHeight);
		butcleaning.setMinHeight(buttonHeight);
		buttravars.setMinHeight(buttonHeight);
		butreverseRecursion.setMinHeight(buttonHeight);
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
		gridPane.add(textlength, 1, 0);
		gridPane.add(butadd, 0, 1);
		gridPane.add(textadd, 1, 1);
		gridPane.add(butfind, 0, 2);
		gridPane.add(textfind, 1, 2);

		gridPane.add(butdelete, 0, 3);
		gridPane.add(textdelete, 1, 3);

		VBox vbox = new VBox(10);
		HBox hbox = new HBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(butreverse, butreverseRecursion, butPrintdata);
		vbox.getChildren().addAll(hbox, textArea);

		borderPane.setBottom(vbox);
		textArea.setPrefColumnCount(10);
		textArea.setPrefRowCount(3);
		textArea.setWrapText(true);
		textArea.setPromptText("All results of operations will appear here");
		borderPane.setCenter(gridPane);
		gridPane.add(butcleaning, 1, 6);
		butlength.setOnAction(e -> {
			textlength.setText("The number of elements:" + LinkedList.length(LinkedList.head));
		});
		butadd.setOnAction(e -> {
			try {

				int num = Integer.parseInt(textadd.getText().trim());
				LinkedList.insert(num);
				textArea.setText("Added successfully--->" + num);
			} catch (Exception e2) {
				textArea.setText("Before adding, before deleting, and before performing the finding process, you must write a number in the boxes in front of you, please."+"/n"+e2.toString());
			}
		});
		butfind.setOnAction(e -> {
			try {
				int num = Integer.parseInt(textfind.getText().trim());

				textArea.setText("I found it???--->" + LinkedList.find(num));
			} catch (Exception e2) {
				textArea.setText("Before adding, before deleting, and before performing the finding process, you must write a number in the boxes in front of you, please."+"/n"+e2.toString());
			}
		});
		butdelete.setOnAction(e -> {
			try {
				int num = Integer.parseInt(textdelete.getText().trim());

				textArea.setText("Delete successfully:??-->" + LinkedList.delete(num));
			} catch (Exception e2) {
				textArea.setText("Before adding, before deleting, and before performing the finding process, you must write a number in the boxes in front of you, please."+"/n"+e2.toString());
			}
		});
		butreverse.setOnAction(e -> {
			try {
				LinkedList.reverse();
				
			} catch (Exception e2) {
				textArea.setText(e2.toString());
			}
		});
		butreverseRecursion.setOnAction(e -> {
			try {
				LinkedList.reverseRecursive();
				
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
		butPrintdata.setOnAction(e -> {
			try {

				textArea.setText(LinkedList.toString());
			} catch (Exception e2) {
				textArea.setText(e2.toString());
			}
		});

		gridPane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(borderPane, 800, 510);
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