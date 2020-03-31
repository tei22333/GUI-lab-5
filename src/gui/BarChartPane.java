package gui;

import static javafx.scene.layout.BorderStrokeStyle.SOLID;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class BarChartPane extends VBox {
	private ObservableList<Data<String, Number>> barChartDataList = FXCollections.observableArrayList();
	public BarChartPane () {
		
		// TODO Implements BarChartPane's contructor
		/*final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> chart = new BarChart<String, Number>(xAxis, yAxis);
		chart.setTitle("Item Summary");*/
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
		CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(400);
		this.setSpacing(10);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.getChildren().addAll(this.createHeaderLabel(),this.createBarChart());
		/*XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		for(Data e : barChartDataList) {
			series1.getData().add(new XYChart.Data(e.getName(), e.getPieValue()));
		}*/
	}
	
	public int addItem(String item, int amount) {
		int amount2  = 0;
		for (Data e : this.barChartDataList) {
			if(e.getXValue().equals(item)) {
				amount2 = (int)e.getYValue()+amount;
				e.setYValue((int)e.getYValue()+amount);
				
			}
		}
		return amount2;
		// TODO Implements addItem(String item, int amount)
	}
	
	private Label createHeaderLabel() {
		Label x = new Label("Item Summary");
		x.setFont(Font.font(24));
		return x;
		// TODO Implements and return a Label for the header

	}
	
	private BarChart<String, Number> createBarChart() {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> chart = new BarChart<String, Number>(xAxis, yAxis);
		xAxis.setLabel("Item");
		yAxis.setLabel("Amount");
		barChartDataList.add(new Data("Wood",0));
		barChartDataList.add(new Data("Iron",0));
		barChartDataList.add(new Data("Iron Plate",0));
		barChartDataList.add(new Data("Iron Sword",0));
		barChartDataList.add(new Data("Gem",0));
		barChartDataList.add(new Data("Other",0));
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>(this.barChartDataList);
		chart.getData().add(series);
		return chart;
	}
	
}
