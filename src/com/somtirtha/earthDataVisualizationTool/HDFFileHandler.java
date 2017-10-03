package com.somtirtha.earthDataVisualizationTool;

// Old imports for the HDF library
//import ncsa.hdf.object.Dataset;
//import ncsa.hdf.object.Datatype;
//import ncsa.hdf.object.FileFormat;
//import ncsa.hdf.object.Group;
//import ncsa.hdf.object.h4.H4File;
//import ncsa.hdf.object.h5.H5File;

// imports from the new hdf library from NCSA
import hdf.hdflib.HDFLibrary;
import hdf.hdf5lib.H5;
import hdf.hdf5lib.HDF5Constants;

import java.io.File;

import org.apache.tika.Tika;


public class HDFFileHandler {
	
	public void print2DArray(int[][] arr) {
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println("\n");
		}
	}
	
	public void readFile(String filePath) {
		try {
			// open file and retrieve the file structure
			int file_id = -1;
			int dataset_id = -1;
			int faplist_id;
			int status;
			
			// detect file type
//			File inputFile = new File(filePath);
//			String type = new Tika().detect(inputFile);
//			System.out.println(type);
			
			String[] parts = filePath.split("\\.");
			System.out.print(parts[parts.length -1]);
			if (parts[parts.length -1].equals("h5")) {
				System.out.println("Here");
				this.readHDF5(filePath);
			} else if (parts[parts.length -1].equals("hdf")) {
				readHDF4(filePath);
			}
			

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	
	public void readHDF5(String fileName) {

		try {
			// open file and retrieve the file structure
			int file_id = -1;
			int dataset_id = -1;
			int faplist_id;
			int status;
			
			System.out.println("Inside hdf5");

			// Open the HDF5 file
			// faplist_id = H5.H5Pcreate(HDF5Constants.H5P_FILE_ACCESS);
			file_id = H5.H5Fopen(fileName, HDF5Constants.H5F_ACC_RDONLY, HDF5Constants.H5P_DEFAULT);

			System.out.println(file_id);

			/* Open an existing dataset. */
			dataset_id = H5.H5Dopen(file_id, "/DS1", 0);

			/*
			 * read the entire dataset, into 'dset_data': memory type is 'native int' read
			 * the entire dataspace to the entire dataspace, no transfer properties,
			 */
			int[][] dset_data = new int[32][64];
			status = H5.H5Dread(dataset_id, HDF5Constants.H5T_NATIVE_INT, HDF5Constants.H5S_ALL, HDF5Constants.H5S_ALL,
					HDF5Constants.H5P_DEFAULT, dset_data);

			status = H5.H5Dclose(dataset_id);

			// print data; this is to test teh data we read from 
			print2DArray(dset_data);

			// close the file using the file id
			H5.H5Fclose(file_id);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public static void readHDF4(String filePath) {

		try {
			// open file and retrieve the file structure
			// H5File h5file = new H5File("~/Downloads/h5ex_d_checksum.h5");
			// h5file.open();
			// HDFLibrary.Hopen("~/Downloads/h5ex_d_checksum.h5", 1);

			String fname = "~/Downloads/h5ex_d_checksum.h5";
			int file_id = H5.H5Fopen(fname, HDF5Constants.H5F_ACC_RDWR, HDF5Constants.H5P_DEFAULT);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}


}
