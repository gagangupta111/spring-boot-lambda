package com.keyholesoftware.lambda.logging;


import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class UtilsManager {

	public File loadFileAndReturn(String prefix, String suffix){

		File file = null;
		try {
			InputStream input = getClass().getClassLoader().getResourceAsStream(prefix + suffix);
			file = File.createTempFile(prefix, suffix);
			OutputStream out = new FileOutputStream(file);
			int read;
			byte[] bytes = new byte[1024];

			while ((read = input.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.close();
			file.deleteOnExit();
		} catch (IOException ex) {

		}

		if (file != null && !file.exists()) {
			throw new RuntimeException("Error: File " + file + " not found!");
		}

		return file;

	}

}