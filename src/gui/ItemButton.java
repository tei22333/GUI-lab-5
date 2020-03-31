package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ItemButton extends Button {

	private String item;
	//constructor
	public ItemButton(String item) {
		this.setPadding(new Insets(5));
		this.setBorder(new Border(
				new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.unhighlight();
		String url;
		switch (item) {
		case "Wood":
			url = "Wood.png";
			break;
		case "Iron":
			url = "Iron_ore.png";
			break;
		case "Iron Plate":
			url = "Iron_plate.png";
			break;
		case "Iron Sword":
			url = "Iron_Sword.png";
			break;
		case "Gem":
			url = "Gem.png";
			break;
		default:
			url = "Other.png";
		}
		Image img = new Image(ClassLoader.getSystemResource(url).toString());
		this.setGraphic(new ImageView(img));
		this.item = item;
	}

	public void highlight() {
		this.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void unhighlight() {
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public String getItem() {
		return this.item;
	}

}
