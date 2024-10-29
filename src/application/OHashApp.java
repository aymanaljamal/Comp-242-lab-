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

public class OHashApp extends Application {

    private OHashL<String> hashTable;
    private TableView<HNode<String>> tableView;

    @Override
    public void start(Stage primaryStage) {
        // Initialize the hash table with a specified size
        hashTable = new OHashL<>(10);

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
        TableColumn<HNode<String>, Integer> indexColumn = new TableColumn<>("Index");
        TableColumn<HNode<String>, String> dataColumn = new TableColumn<>("Data");
        TableColumn<HNode<String>, Character> flagColumn = new TableColumn<>("Flag");

        indexColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(tableView.getItems().indexOf(cellData.getValue())));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        flagColumn.setCellValueFactory(new PropertyValueFactory<>("flag"));

        tableView.getColumns().addAll(indexColumn, dataColumn, flagColumn);

        // Apply styles directly in code
        inputLabel.setStyle("-fx-font-size: 14pt; -fx-font-weight: bold;");
        addButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
        showButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
        tableView.setStyle("-fx-table-cell-border-color: transparent;");
        indexColumn.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
        dataColumn.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");
        flagColumn.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 12pt;");

        // Layout the UI components
        HBox inputBox = new HBox(10, inputLabel, inputField, addButton);
        inputBox.setPadding(new Insets(10));
        VBox layout = new VBox(10, inputBox, showButton, tableView);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 500, 400);

        // Set up the stage
        primaryStage.setTitle("OHash JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateTableView() {
        HNode<String>[] table = hashTable.getHashTable();
        ObservableList<HNode<String>> data = FXCollections.observableArrayList();
        for (HNode<String> hNode : table) {
            data.add(hNode);
        }
        tableView.setItems(data);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
