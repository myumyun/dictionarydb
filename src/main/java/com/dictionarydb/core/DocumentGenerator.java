package com.dictionarydb.core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DocumentGenerator {
	
	public void create(String documentName){
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {

			String content = "This is the content to write into file\n";

			fw = new FileWriter(documentName);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();

			}

		}

	}
	
}
