package com.somtirtha.earthDataVisualizationTool;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	 private MapView mapView;

	@Override
	public void start(Stage primaryStage) {
		try {

			// create stack pane and application scene
			StackPane stackPane = new StackPane();
			Scene scene = new Scene(stackPane);

			// set title, size, and add scene to stage
			primaryStage.setTitle("Data Vis");
			primaryStage.setWidth(800);
			primaryStage.setHeight(700);
			primaryStage.setScene(scene);
			primaryStage.show();

			// create a ArcGISMap with the a Basemap instance with an Imagery base layer
			ArcGISMap map = new ArcGISMap(Basemap.createImagery());

			// set the map to be displayed in this view
			mapView = new MapView();
			mapView.setMap(map);

			// add the map view to stack pane
			stackPane.getChildren().addAll(mapView);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// try {
		//// BorderPane root = new BorderPane();
		// Parent root =
		// FXMLLoader.load(getClass().getResource("/resources/toolLayout.fxml"));
		// Scene scene = new Scene(root);
		//// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		// primaryStage.setTitle("Vis App");
		// primaryStage.setScene(scene);
		// primaryStage.show();
		// } catch(Exception e) {
		// e.printStackTrace();
		// }
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Stops and releases all resources used in application.
	 */
	@Override
	public void stop() throws Exception {

	  if (mapView != null) {
	    mapView.dispose();
	  }
	}
}
