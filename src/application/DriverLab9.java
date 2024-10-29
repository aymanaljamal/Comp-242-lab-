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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DriverLab9 extends Application {

	private SHash<String> hashTable;
	private TableView<LinkedList<String>> tableView;
	

	public VBox hashTable2() {
		 VBox layout = new VBox(10);

		hashTable = new SHash<>(10);

		// Create the UI components
		Label inputLabel = new Label("Enter data:");
		TextField inputField = new TextField();
		Button addButton = new Button("Add to Hash Table");
		Button deleteButton = new Button("Delete from Hash Table");
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

		deleteButton.setOnAction(event -> {
			String input = inputField.getText();
			if (!input.isEmpty()) {
				hashTable.delete(input);
				inputField.clear();
				updateTableView();
			}
		});

		showButton.setOnAction(event -> updateTableView());

		// Create the TableView and its columns
		tableView = new TableView<>();
		TableColumn<LinkedList<String>, Integer> indexColumn = new TableColumn<>("Index");
		TableColumn<LinkedList<String>, String> dataColumn = new TableColumn<>("Data");

		indexColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(
				tableView.getItems().indexOf(cellData.getValue())));
		dataColumn.setCellValueFactory(
				cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().toString()));

		tableView.getColumns().addAll(indexColumn, dataColumn);

		// Apply styles directly in code
		inputLabel.setStyle("-fx-font-size: 14pt; -fx-font-weight: bold;");
		addButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
		deleteButton.setStyle("-fx-background-color: #D70000; -fx-text-fill: white; -fx-font-size: 12pt;");
		showButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
		tableView.setStyle("-fx-table-cell-border-color: transparent;");
		indexColumn.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
		dataColumn.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");

		// Layout the UI components
		HBox inputBox = new HBox(10, inputLabel, inputField, addButton, deleteButton);
		inputBox.setPadding(new Insets(10));
		layout = new VBox(10, inputBox, showButton, tableView);
		layout.setPadding(new Insets(10));
		return layout;

		
	}

	private void updateTableView() {
		LinkedList<String>[] table = hashTable.getHashTable();
		ObservableList<LinkedList<String>> data = FXCollections.observableArrayList();
		for (LinkedList<String> list : table) {
			data.add(list);
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
