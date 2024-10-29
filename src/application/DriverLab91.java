package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class DriverLab91 extends Application {

	private OHashp<String> hashTable;
	private TableView<HNodep<String>> tableView;


	
	public VBox   hashTable1() {
		 VBox layout = new VBox(10);
		hashTable = new OHashp<>(10);

		// Create the UI components
		Label inputLabel = new Label("Enter data:");
		TextField inputField = new TextField();
		Button addButton = new Button("Add to Hash Table");
		Button showButton = new Button("Show Hash Table");

		// Add functionality to buttons
		addButton.setOnAction(event -> {
			String input = inputField.getText();
			if (!input.isEmpty()) {
				hashTable.add(input);
				inputField.clear();
				updateTableView();
			}
		});

		showButton.setOnAction(event -> updateTableView());

		// Create the TableView and its columns
		tableView = new TableView<>();
		TableColumn<HNodep<String>, Integer> indexColumn = new TableColumn<>("Index");
		TableColumn<HNodep<String>, String> dataColumn = new TableColumn<>("Data");
		TableColumn<HNodep<String>, String> flagColumn = new TableColumn<>("Flag");

		indexColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(
				tableView.getItems().indexOf(cellData.getValue())));
		dataColumn.setCellValueFactory(cellData -> cellData.getValue().dataProperty().asString());
		flagColumn.setCellValueFactory(cellData -> cellData.getValue().flagProperty());

		tableView.getColumns().addAll(indexColumn, dataColumn, flagColumn);

		// Apply styles directly in code
		inputLabel.setStyle("-fx-font-size: 14pt; -fx-font-weight: bold;");
		addButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
		showButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
		tableView.setStyle("-fx-table-cell-border-color: transparent;");
		indexColumn.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
		dataColumn.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
		flagColumn.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");

		// Add drop shadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(3.0);
		dropShadow.setOffsetY(3.0);
		dropShadow.setColor(Color.color(0.4, 0.5, 0.5));

		addButton.setEffect(dropShadow);
		showButton.setEffect(dropShadow);

		// Layout the UI components
		HBox inputBox = new HBox(10, inputLabel, inputField, addButton);
		inputBox.setPadding(new Insets(10));
		layout = new VBox(10, inputBox, showButton, tableView);
		layout.setPadding(new Insets(10));
		return layout;

		
		
		
	}

	private void updateTableView() {
		HNodep<String>[] table = hashTable.getHashTable();
		ObservableList<HNodep<String>> data = FXCollections.observableArrayList();
		for (HNodep<String> hNode : table) {
			data.add(hNode);
		}
		tableView.setItems(data);
	}

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
