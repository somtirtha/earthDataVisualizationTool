package com.somtirtha.earthDataVisualizationTool;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

public class MainController implements Initializable {
	private MapView mapView;

	// all FXML container ID's
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
	private StackPane stackPane;

	// intializing the list with list of items
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// change next line to DB load
		List<String> values = Arrays.asList("Layer1", "Layer2", "Layer3");

		// adds values to list view and treats the elements as observable
		// listView.setItems(FXCollections.observableList(values));

		// iterate and add values to list view
		for (String val : values) {
			listView.getItems().add(val);

		}
		
		// initialize world map in the mapContainer
		this.setMapElement();

	}

	// initialize map element
	public void setMapElement() {
		// create an ArcGISMap with the a Basemap instance with an Imagery base layer
		ArcGISMap map = new ArcGISMap(Basemap.createImagery());

		// set the map to be displayed in this view
		mapView = new MapView();
		mapView.setMap(map);

		// add the map view to mapContainer
		mapContainer.getChildren().addAll(mapView);

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
