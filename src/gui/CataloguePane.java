package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class CataloguePane extends GridPane {

	private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();
	private ItemButton selectedItemButton = null;

	public CataloguePane() {
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);
		ItemButton woodBtn = new ItemButton("Wood");
		itemButtonList.add(woodBtn);
		this.add(woodBtn, 0, 0);
		ItemButton ironBtn = new ItemButton("Iron");
		itemButtonList.add(ironBtn);
		this.add(ironBtn, 1, 0);
		ItemButton ironPlateBtn = new ItemButton("Iron Plate");
		itemButtonList.add(ironPlateBtn);
		this.add(ironPlateBtn, 2, 0);
		ItemButton ironSwordBtn = new ItemButton("Iron Sword");
		itemButtonList.add(ironSwordBtn);
		this.add(ironSwordBtn, 0, 1);
		ItemButton gemBtn = new ItemButton("Gem");
		itemButtonList.add(gemBtn);
		this.add(gemBtn, 1, 1);
		ItemButton otherBtn = new ItemButton("Other");
		itemButtonList.add(otherBtn);
		this.add(otherBtn, 2, 1);
		for (ItemButton e : itemButtonList) {
			e.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					setSelectedButton(e);
				}
			});
		}
	}

	public void setSelectedButton(ItemButton selectedItemButton) {
		this.selectedItemButton = selectedItemButton;
		//unhi all
		for (ItemButton e : itemButtonList) {
			e.unhighlight();
		}
		//hi there
		this.selectedItemButton.highlight();
		this.getSelectedButton();
	}

	public ItemButton getSelectedButton() {
		return selectedItemButton;
	}

}
