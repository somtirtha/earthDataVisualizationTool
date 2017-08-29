package com.somtirtha.earthDataVisualizationTool;

import java.io.File;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

public class MainController {
	private MapView mapView;
	
	@FXML
	private Button fileButton;

	@FXML
	private MenuItem menuItem;

	@FXML
	private MenuButton fileMenuButton;

	@FXML
	private StackPane mapContainer;

	@FXML
	private ListView listView;
	
	@FXML
	private AnchorPane anchorPane;

	// initialize
	public void setMapElement() {
		// create an ArcGISMap with the a Basemap instance with an Imagery base layer
		ArcGISMap map = new ArcGISMap(Basemap.createImagery());
		// set the map to be displayed in this view
		mapView = new MapView();
		mapView.setMap(map);

		// add the map view to mapContainer
		mapContainer = new StackPane();
		anchorPane.getChildren().addAll(mapView);

	}

	// Open Filechooser to open dialog box to choose files
	public void ButtonAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		File selectedFile = fc.showOpenDialog(null);

		if (selectedFile != null) {
			listView.getItems().add(selectedFile.getName());
		} else {
			System.out.println("File not valid!");
		}

	}

}
