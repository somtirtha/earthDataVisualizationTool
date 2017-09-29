package com.somtirtha.earthDataVisualizationTool;

// Old imports for the HDF library
//import ncsa.hdf.object.Dataset;
//import ncsa.hdf.object.Datatype;
//import ncsa.hdf.object.FileFormat;
//import ncsa.hdf.object.Group;
//import ncsa.hdf.object.h4.H4File;
//import ncsa.hdf.object.h5.H5File;

// imports from the new hdf library from NCSA
import hdf.hdflib.*;
import hdf.hdflib.HDFLibrary;
import hdf.hdf5lib.H5;
import hdf.hdf5lib.HDF5Constants;

public class HDFFileHandler {

	public static void readHDF() {

		try {
			// open file and retrieve the file structure
			// H5File h5file = new H5File("~/Downloads/h5ex_d_checksum.h5");
			// h5file.open();
//			HDFLibrary.Hopen("~/Downloads/h5ex_d_checksum.h5", 1);
			
			String fname = "~/Downloads/h5ex_d_checksum.h5";
			int file_id = H5.H5Fopen(fname, HDF5Constants.H5F_ACC_RDWR, HDF5Constants.H5P_DEFAULT);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public static void main(String[] args) {
		// read HdfFiles
		// HDFFileHandler hdfh = new HDFFileHandler();
		HDFFileHandler.readHDF();
	}

}
