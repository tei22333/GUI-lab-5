package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class EventManager {

	private BarChartPane barChartPane;
	private ItemLogPane itemLogPane;
	private CataloguePane cataloguePane;

	public EventManager(BarChartPane barChartPane, ItemLogPane itemLogPane, CataloguePane cataloguePane) {
		this.barChartPane = barChartPane;
		this.itemLogPane = itemLogPane;
		this.cataloguePane = cataloguePane;
	}

	public void setUpAddButtonEvent(Button addButton, InputField amountInput) {
		addButton.setOnAction(new AddButtonEventHandler(amountInput));
	}

	private class AddButtonEventHandler implements EventHandler<ActionEvent> {

		private InputField amountInput;

		public AddButtonEventHandler(InputField amountInput) {
			this.amountInput = amountInput;
		}

		@Override
		public void handle(ActionEvent arg0) {
			try {
				if (cataloguePane.getSelectedButton() == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("");
					alert.setHeaderText(null);
					alert.setContentText("Please Select An Item To Be Added");
					alert.showAndWait();
					// TODO Implements an alert
				}
				int amount; /* TODO Parses input value to int */
				amount = Integer.parseInt(this.amountInput.getText());
				if (amount >= 0) {
					// TODO Implements an alert
					int total = barChartPane.addItem(cataloguePane.getSelectedButton().getItem(), amount);
					itemLogPane.addData(cataloguePane.getSelectedButton().getItem(), amount, total);
				} else {
					// TODO add data to BarChartPane and ItemLogPane
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("");
					alert.setHeaderText(null);
					alert.setContentText("Please Fill In Positive Vote Value");
					alert.showAndWait();
				}
			} catch (NumberFormatException e) {
				if (amountInput.getText().equals("")) {
					// TODO Implements an alert
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("");
					alert.setHeaderText(null);
					alert.setContentText("Amount Cannot Be Empty");
					alert.showAndWait();
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("");
					alert.setHeaderText(null);
					alert.setContentText("Incorrect Vote Format");
					alert.showAndWait();
					// TODO Implements an alert
				}
			}
		}

	}
}
