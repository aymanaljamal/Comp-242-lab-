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

public class DriverLab4 extends Application {
	private GridPane gridPane = new GridPane();
	private BorderPane borderPane = new BorderPane();
	CursorArray<Integer> CursorArray = new CursorArray(40);

	@Override
	public void start(Stage primaryStage) {
		gridPane.setHgap(10);
		gridPane.setVgap(5);
		gridPane.setPadding(new Insets(50, 50, 50, 50));
		Button butlength = new Button("length");

		Button butfind = new Button("find");

		Button buttraversListRe = new Button("travers List");

		Button butdelete = new Button("delete");

		Button butcler = new Button("clear");

		Button butcreateList = new Button(" create List ");

		Button butremoveList = new Button("remove List  ");

		Button InsertSorted = new Button("Insert Sorted ");
		Button mergewithsorted = new Button("merge with sorted");
		Button butcleaning = new Button("cleaning");
		TextArea textArea = new TextArea();
		double buttonWidth = 200;
		butlength.setMinWidth(buttonWidth);
		butfind.setMinWidth(buttonWidth);
		buttraversListRe.setMinWidth(buttonWidth);
		butdelete.setMinWidth(buttonWidth);
		butcler.setMinWidth(buttonWidth);
		butcleaning.setMinWidth(buttonWidth);
		butcreateList.setMinWidth(buttonWidth);
		butremoveList.setMinWidth(buttonWidth);

		mergewithsorted.setMinWidth(buttonWidth);
		InsertSorted.setMinWidth(buttonWidth);
		butcleaning.setMinWidth(buttonWidth);
		double buttonHeight = 30;
		butlength.setMinHeight(buttonHeight);
		butfind.setMinHeight(buttonHeight);
		buttraversListRe.setMinHeight(buttonHeight);
		butdelete.setMinHeight(buttonHeight);
		butremoveList.setMinHeight(buttonHeight);
		butcler.setMinHeight(buttonHeight);
		butcreateList.setMinHeight(buttonHeight);
		mergewithsorted.setMinHeight(buttonHeight);
		InsertSorted.setMinHeight(buttonHeight);

		TextField textInsertSorted = new TextField();
		textInsertSorted.setPromptText("---------");
		TextField textlength = new TextField();
		textlength.setPromptText("");

		TextField textfind = new TextField();
		textfind.setPromptText("");
		TextField textmergewithsorted = new TextField();
		textmergewithsorted.setPromptText("");
		TextField textdelete = new TextField();
		textdelete.setPromptText("");
		TextField textbutcler = new TextField();
		textbutcler.setPromptText("");
		TextField texttraversListRe = new TextField();
		texttraversListRe.setPromptText("");
		TextField textremoveList = new TextField();
		textremoveList.setPromptText("");

		textInsertSorted.setMinWidth(buttonWidth);
		textlength.setMinWidth(buttonWidth);
		textremoveList.setMinWidth(buttonWidth);

		textfind.setMinWidth(buttonWidth);
		textbutcler.setMinWidth(buttonWidth);
		texttraversListRe.setMinWidth(buttonWidth);
		textInsertSorted.setMinHeight(buttonHeight);
		textlength.setMinHeight(buttonHeight);

		textremoveList.setMinHeight(buttonHeight);
		texttraversListRe.setMinHeight(buttonHeight);
		textfind.setMinHeight(buttonHeight);
		textbutcler.setMinHeight(buttonHeight);

		gridPane.add(butlength, 0, 0);
		gridPane.add(textlength, 1, 0);
		gridPane.add(butcler, 0, 1);
		gridPane.add(textbutcler, 1, 1);

		gridPane.add(InsertSorted, 0, 2);
		gridPane.add(textInsertSorted, 1, 2);

		gridPane.add(butdelete, 0, 3);
		gridPane.add(textdelete, 1, 3);

		gridPane.add(butfind, 0, 4);
		gridPane.add(textfind, 1, 4);

		gridPane.add(mergewithsorted, 0, 5);
		gridPane.add(textmergewithsorted, 1, 5);

		gridPane.add(buttraversListRe, 0, 6);
		gridPane.add(texttraversListRe, 1, 6);

		gridPane.add(butcleaning, 0, 8);
		gridPane.add(butcreateList, 1, 8);
		gridPane.add(butremoveList, 0, 7);
		gridPane.add(textremoveList, 1, 7);

		butlength.setOnAction(e -> {
			try {
				int l = Integer.parseInt(textlength.getText().trim());
				textArea.setText("This is list length: " + CursorArray.listLength(l));
			} catch (NumberFormatException ex) {
				textArea.setText("Please enter a valid number.");
			} catch (Exception ex) {
				textArea.setText("An error occurred: \n" + ex.toString());
			}
		});

		butfind.setOnAction(e -> {
			try {
				String[] num_l = textfind.getText().trim().split(",");
				if (num_l.length != 2) {
					throw new IllegalArgumentException("Please enter two numbers separated by a comma.");
				}
				int num = Integer.parseInt(num_l[0]);
				int l = Integer.parseInt(num_l[1]);
				textArea.setText("I found it???--->" + CursorArray.find(l, num));
			} catch (NumberFormatException ex) {
				textArea.setText("Please enter valid numbers.");
			} catch (IllegalArgumentException ex) {
				textArea.setText(ex.getMessage());
			} catch (Exception ex) {
				textArea.setText("An error occurred: \n" + ex.toString());
			}
		});

		buttraversListRe.setOnAction(e -> {
			try {
				int l = Integer.parseInt(texttraversListRe.getText().trim());
				textArea.setText(CursorArray.toString(l));
			} catch (NumberFormatException ex) {
				textArea.setText("Please enter a valid number.");
			} catch (Exception ex) {
				textArea.setText("An error occurred: \n" + ex.toString());
			}
		});

		butdelete.setOnAction(e -> {
			try {
				String[] num_l = textdelete.getText().trim().split(",");
				if (num_l.length != 2) {
					throw new IllegalArgumentException("Please enter two numbers separated by a comma.");
				}
				int num = Integer.parseInt(num_l[0]);
				int l = Integer.parseInt(num_l[1]);
				textArea.setText("Delete successfully:??-->" + CursorArray.delete(l, num));
			} catch (NumberFormatException ex) {
				textArea.setText("Please enter valid numbers.");
			} catch (IllegalArgumentException ex) {
				textArea.setText(ex.getMessage());
			} catch (Exception ex) {
				textArea.setText("An error occurred: \n" + ex.toString());
			}
		});

		butcler.setOnAction(e -> {
			try {
				int p = Integer.parseInt(textbutcler.getText().trim());
				CursorArray.clear(p);
				textArea.setText("List cleared: " + CursorArray.toString(p));
			} catch (NumberFormatException ex) {
				textArea.setText("Please enter a valid number.");
			} catch (Exception ex) {
				textArea.setText("An error occurred: \n" + ex.toString());
			}
		});

		butcreateList.setOnAction(e -> {
			try {
				int d = CursorArray.createList();
				textArea.setText("List created: " + CursorArray.toString(d));
			} catch (Exception ex) {
				textArea.setText("An error occurred while creating the list: \n" + ex.toString());
			}
		});

		butremoveList.setOnAction(e -> {
			try {
				int p = Integer.parseInt(textremoveList.getText().trim());
				CursorArray.removeList(p);
				textArea.setText("List removed ");
			} catch (NumberFormatException ex) {
				textArea.setText("Please enter a valid number.");
			} catch (Exception ex) {
				textArea.setText("An error occurred while removing the list: \n" + ex.toString());
			}
		});

		InsertSorted.setOnAction(e -> {
			try {
				String[] num_l = textInsertSorted.getText().trim().split(",");
				if (num_l.length != 2) {
					throw new IllegalArgumentException("You must enter two numbers separated by a comma.");
				}
				Integer num = Integer.parseInt(num_l[0].trim());
				Integer l = Integer.parseInt(num_l[1].trim());
				CursorArray.insertSorted(num, l);
				textArea.setText("Number inserted: " + num);
			} catch (NumberFormatException ex) {
				textArea.setText("Please enter valid numbers.");
			} catch (IllegalArgumentException ex) {
				textArea.setText(ex.getMessage());
			} catch (Exception ex) {
				textArea.setText("An error occurred while inserting: \n" + ex.toString());
			}
		});

		butcleaning.setOnAction(e -> {

			textArea.clear();
			textInsertSorted.clear();
			textfind.clear();

			textmergewithsorted.clear();
			textdelete.clear();
			textremoveList.clear();
			textlength.clear();
			texttraversListRe.clear();
			textbutcler.clear();
		});
		mergewithsorted.setOnAction(e -> {
			try {
				String[] num_l = textmergewithsorted.getText().trim().split(",");
				if (num_l.length != 2) {
					throw new IllegalArgumentException("You must enter two numbers separated by a comma.");
				}
				Integer l1 = Integer.parseInt(num_l[0].trim());
				Integer l2 = Integer.parseInt(num_l[1].trim());
				int num=CursorArray.mergeAndSortLists(l1,l2);
				textArea.setText(" "+CursorArray.toString(num));
			} catch (NumberFormatException ex) {
				textArea.setText("Please enter valid numbers.");
			} catch (IllegalArgumentException ex) {
				textArea.setText(ex.getMessage());
			} catch (Exception ex) {
				textArea.setText("An error occurred while inserting: \n" + ex.toString());
			}
		});
		borderPane.setBottom(textArea);
		textArea.setPrefColumnCount(10);
		textArea.setPrefRowCount(3);
		textArea.setWrapText(true);
		textArea.setPromptText("All results of operations will appear here");
		borderPane.setCenter(gridPane);
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
