package com.pdsu.util;

import java.io.File;
import java.io.FileOutputStream;

public class Clear {
	public static void clear() throws Exception {
		File file = new File("store.txt");

	    FileOutputStream fos = new FileOutputStream(file);
	    fos.write("".getBytes());
	    fos.close();
	} 
}
