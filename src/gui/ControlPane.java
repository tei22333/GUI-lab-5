package gui;

import java.awt.TextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ControlPane extends VBox {
	
	private CataloguePane catalogue;
	private Label catalogueLabel;
	private InputField amountInputField;
	private Button addButton;
	
	public ControlPane () {
		
		// TODO Implements CataloguePane's constructor
		//super();
		setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
		CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(200);
		this.setSpacing(15);
		catalogueLabel = new Label("Choose an item");
		catalogueLabel.setFont(Font.font(18));
		catalogue = new CataloguePane();
		amountInputField = new InputField("Amount to add", "Input number here");
		addButton = new Button("Add");
		/*addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(catalogue.getSelectedButton().getItem()+getAmountInputField().getText());
			}
		});*/
		
		addButton.setPrefWidth(150);
		this.getChildren().addAll(catalogueLabel,catalogue,amountInputField,addButton);
	}

	public CataloguePane getCatalogue() {
		return catalogue;
	}

	public Label getCatalogueLabel() {
		return catalogueLabel;
	}

	public InputField getAmountInputField() {
		return amountInputField;
	}

	public Button getAddButton() {
		return addButton;
	}
	
	// TODO Implements getters for each field

}
