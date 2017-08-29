package com.somtirtha.earthDataVisualizationTool;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

public class Main extends Application {
	private Stage primaryStage;
	private MapView mapView;
	private AnchorPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Data Viz");
		// initialize root layout
		initRootLayout();

	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

//	public StackPane getMapContainer() {
//		return mapContainer;
//	}

	/**
	 * intitialize the root layout
	 * 
	 * @param args
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Layout.fxml"));
            rootLayout = (AnchorPane) loader.load();
			
			
////			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
			Scene scene = new Scene(rootLayout);
//			scene.getStylesheets().add(getClass().getResource("/resources/application.css").toExternalForm());

			// set title, size, and add scene to stage
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();

			// create an ArcGISMap with the a Basemap instance with an Imagery base layer
//			ArcGISMap map = new ArcGISMap(Basemap.createImagery());
//			// set the map to be displayed in this view
//			mapView = new MapView();
//			mapView.setMap(map);

			// add the map view to mapContainer
//			root.getC
//			StackPane mapContainer = new StackPane();
			
//			mapContainer.getChildren().addAll(mapView);
			
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("Layout.fxml"));
			rootLayout.getChildren().add(loader.load());
			MainController mc = loader.getController();
			mc.setMapElement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * set the basemap layout separately if necessary
	 * 
	 * @param args
	 */
	public void mapLayout() {

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
