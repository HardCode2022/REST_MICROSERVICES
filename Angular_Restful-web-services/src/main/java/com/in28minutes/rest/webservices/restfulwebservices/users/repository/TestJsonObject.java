package com.in28minutes.rest.webservices.restfulwebservices.users.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.junit.Ignore;
@Ignore
public class TestJsonObject {

	public static void main(String[] args) {
		
		
		TestJsonObject app = new TestJsonObject();
		
		String fileName = "test.json";
		
		 System.out.println("getResourceAsStream : " + fileName);
	        InputStream is = app.getFileFromResourceAsStream(fileName);
	        printInputStream(is);

	}

	private static void printInputStream(InputStream is) {
		
		try (InputStreamReader streamReader =
                new InputStreamReader(is, StandardCharsets.UTF_8);
         BufferedReader reader = new BufferedReader(streamReader)) {

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
		
	}

	private InputStream getFileFromResourceAsStream(String fileName) {
		 // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
	}

}
