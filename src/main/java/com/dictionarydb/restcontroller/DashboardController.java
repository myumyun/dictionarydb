package com.dictionarydb.restcontroller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dictionarydb.entity.Book;
import com.dictionarydb.service.BookService;
import com.dictionarydb.service.DashboardService;
import com.dictionarydb.service.DictionaryService;

import ch.qos.logback.core.util.ContentTypeUtil;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController {
	private static final String DIRECTORY = "";

	@Autowired
	private BookService bookService;
	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping("/initializeSystem")
	public ResponseEntity<String> getInitializeSystem() {
		dashboardService.initializeSystem();
		return new ResponseEntity<String>("initialized.", HttpStatus.OK);
	}

	@GetMapping
	public String getBookList() {
		return bookService.get().toString();
	}

	@GetMapping("/generateBook")
	public void generateBook() {
		bookService.generate();
	}

	@GetMapping(path = "/download")
	public ResponseEntity<InputStreamResource> download(String param)
			throws IOException {
		Book book = bookService.get(1);
		BufferedWriter writer = null;
		String filename = "";
		File file = null;
		try {
			// create a temporary file
			filename = new SimpleDateFormat("yyyyMMdd_HHmmss")
					.format(Calendar.getInstance().getTime());
			filename = filename + ".txt";
			file = new File(filename);

			// This will output the full path where the file will be written
			// to...
			System.out.println(file.getCanonicalPath());

			writer = new BufferedWriter(new FileWriter(file));
			writer.write(book.getDocument());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
			}
		}

		InputStreamResource resource = new InputStreamResource(
				new FileInputStream(file));

		return ResponseEntity.ok()
				.header("Baeldung-Example-Header", "Value-Handler")
				.contentLength(file.length()).body(resource);
	}

	@GetMapping("/downloadByUrl")
	public ResponseEntity<InputStreamResource> downloadByUrl()
			throws IOException {
		String rootPath = System.getProperty("user.dir");
		File file = new File(rootPath + "/20180929_204645.txt");

		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.setContentLength(12345678);
		respHeaders.setContentDispositionFormData("attachment",
				"fileNameIwant.pdf");

		InputStreamResource isr = new InputStreamResource(
				new FileInputStream(file));
		return new ResponseEntity<InputStreamResource>(isr, respHeaders,
				HttpStatus.OK);
	}



}
