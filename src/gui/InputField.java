package gui;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class InputField extends VBox {

	private TextField textField;

	public InputField(String title, String promptText) {
		this.setSpacing(5);
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		Label label = new Label(title);
		label.setFont(Font.font(18));
		TextField input = new TextField(promptText);
		this.textField = input;
		this.getChildren().addAll(label, input);
	}

	public String getText() {
		return this.textField.getText().trim();
	}
}
