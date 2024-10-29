package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DriverLab8 {
	private AVLTree<Integer> tree = new AVLTree<>();
	private TextArea textArea = new TextArea();
	private VBox layout = new VBox(10);
	
	public VBox createLayout() {
		
		layout.setAlignment(Pos.CENTER);

		TextField textField = new TextField();
		textField.setPromptText("Enter Integer");

		Button insertBtn = new Button("Insert");
		Button deleteBtn = new Button("Delete");
		Button printBtn = new Button("Print Tree");

		textArea.setEditable(false);

		insertBtn.setOnAction(e -> {
			try {
				int value = Integer.parseInt(textField.getText());
				tree.insert(value);
				textField.clear();
				textArea.setText("Inserted: " + value + "\n" + printTree());
			} catch (NumberFormatException nfe) {
				textArea.setText("Please enter a valid integer.");
			}
		});

		deleteBtn.setOnAction(e -> {
			try {
				int value = Integer.parseInt(textField.getText());
				tree.delete(value);
				textField.clear();
				textArea.setText("Deleted: " + value + "\n" + printTree());
			} catch (NumberFormatException nfe) {
				textArea.setText("Please enter a valid integer.");
			}
		});

		printBtn.setOnAction(e -> textArea.setText(printTree()));

		layout.getChildren().addAll(textField, insertBtn, deleteBtn, printBtn, textArea);
		return layout;
	}

	private String printTree() {
		StringBuilder sb = new StringBuilder();
		tree.preOrder(tree.getRoot(), sb);
		return sb.toString();
	}
}
