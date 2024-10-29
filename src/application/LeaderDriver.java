package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class LeaderDriver extends Application {
	TabPane root = new TabPane();
	Tab tablab0;
	Tab tablab1;
	Tab tablab2;
	Tab tablab3;
	Tab tablab4;
	Tab tablab5;
	Tab tablab6;
	Tab tablab8;
	Tab tablab9;
	Tab tablab1_1;

	@Override
	public void start(Stage primaryStage) throws Exception {
		tablab0 = new Tab();
		tablab0.setText("Lab 0");
		tablab1 = new Tab();
		tablab1.setText("Lab 1");
		tablab2 = new Tab();
		tablab2.setText("Lab 2-->LinkedList");
		tablab3 = new Tab();
		tablab3.setText("Lab 3-->DLinkedList");
		tablab4 = new Tab();
		tablab4.setText("Lab 4-->cursorArray");
		tablab5 = new Tab();
		tablab5.setText("Lab 5-->CStack");
		tablab6 = new Tab();
		tablab6.setText("Lab 6-->SQueue");
		tablab8 = new Tab();
		tablab8.setText("Lab 8-->AVL tree");
		tablab9 = new Tab();
		tablab9.setText("Lab 9-->SHASH");
		tablab1_1 = new Tab();
		tablab1_1.setText("Lab 9-->OHASH");

		DriverLab0 DriverLab0 = new DriverLab0();
		DriverLab1 DriverLab1 = new DriverLab1();
		DriverLab2 DriverLab2 = new DriverLab2();
		DriverLab3 DriverLab3 = new DriverLab3();
		DriverLab4 DriverLab4 = new DriverLab4();
		DriverLab5 DriverLab5 = new DriverLab5();
		DriverLab6 DriverLab6 = new DriverLab6();
		DriverLab8 DriverLab8 = new DriverLab8();
		DriverLab9 DriverLab9 = new DriverLab9();
		DriverLab91 DriverLab1_1 = new DriverLab91();

		tablab0.setContent(DriverLab0.getPane());
		tablab1.setContent(DriverLab1.getGridPane());
		tablab2.setContent(DriverLab2.getBorderPane());
		tablab3.setContent(DriverLab3.getBorderPane());
		tablab4.setContent(DriverLab4.getBorderPane());
		tablab5.setContent(DriverLab5.getBorderPane());
		tablab6.setContent(DriverLab6.getVbox());
		tablab8.setContent(DriverLab8.createLayout());
		tablab9.setContent(DriverLab9.hashTable2());
		tablab1_1.setContent(DriverLab1_1.hashTable1());

		root.getTabs().addAll(tablab0, tablab1, tablab2, tablab3, tablab4, tablab5, tablab6, tablab8, tablab9,
				tablab1_1);
		DriverLab0.start(primaryStage);
		DriverLab1.start(primaryStage);
		DriverLab3.start(primaryStage);
		DriverLab2.start(primaryStage);
		DriverLab4.start(primaryStage);
		DriverLab5.start(primaryStage);
		DriverLab6.start(primaryStage);
		DriverLab9.start(primaryStage);
		
		Scene scene = new Scene(root, 900, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
