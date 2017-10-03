package com.somtirtha.earthDataVisualizationTool;

import java.util.Arrays;

import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReference;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.arcgisruntime.layers.RasterLayer;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.raster.MosaicDatasetRaster;
import com.esri.arcgisruntime.raster.Raster;
import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;

public class DisplayData {

	public void displayPoints() {
		SpatialReference SPATIAL_REFERENCE = SpatialReferences.getWgs84();
		Point buoy1Loc = new Point(-2.72, 56.065, SPATIAL_REFERENCE);
		Point buoy2Loc = new Point(-2.69, 56.065, SPATIAL_REFERENCE);
		Point buoy3Loc = new Point(-2.66, 56.065, SPATIAL_REFERENCE);
		Point buoy4Loc = new Point(-2.63, 56.065, SPATIAL_REFERENCE);
		
		// create a red (0xFFFF0000) circle simple marker symbol
		SimpleMarkerSymbol redCircleSymbol = new SimpleMarkerSymbol(SimpleMarkerSymbol.Style.CIRCLE, 0xFFFF0000, 10);
		
//		graphicsOverlay.getGraphics().addAll(Arrays.asList(buoyGraphic1, buoyGraphic2, buoyGraphic3, buoyGraphic4));
	}
	
	public void displayRaster() {
		// create a raster from a raster file
		String rasterFilePath = "/path/to/raster.format";
		Raster raster = new Raster(rasterFilePath);
		
		RasterLayer rasterLayer = new RasterLayer(raster);

		// add as a basemap
		ArcGISMap map = new ArcGISMap(new Basemap(rasterLayer));

		// Alternatively you can create a raster layer from a mosaic dataset
		MosaicDatasetRaster mosaicDatasetRaster = new MosaicDatasetRaster("/path/to/mosaic.sqlite", "rasterName");
		RasterLayer mosaicDatasetRasterLayer = new RasterLayer(mosaicDatasetRaster);

		// add as an operational layer
		map.getOperationalLayers().add(mosaicDatasetRasterLayer);
	}
}
