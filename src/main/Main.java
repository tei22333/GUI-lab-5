package main;

import gui.BarChartPane;
import gui.CataloguePane;
import gui.ControlPane;
import gui.EventManager;
import gui.InputField;
import gui.ItemButton;
import gui.ItemLogPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		ControlPane a = new ControlPane();
		BarChartPane bar = new BarChartPane();
		CataloguePane catalog = a.getCatalogue();
		HBox root = new HBox();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setSpacing(10);
		ItemLogPane log = new ItemLogPane();
		root.getChildren().addAll(a,bar,log);
		Scene scene = new Scene(root, 1000, 500);
		EventManager manager = new EventManager(bar, log, catalog);
		manager.setUpAddButtonEvent(a.getAddButton(), a.getAmountInputField());
		/*a.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int amount = Integer.parseInt(a.getAmountInputField().getText());
				int total = bar.addItem(a.getCatalogue().getSelectedButton().getItem(), amount);
				log.addData(a.getCatalogue().getSelectedButton().getItem(), amount, total);
			}
		});*/
		primaryStage.setTitle("Blacksmith's Inventory Manager"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
