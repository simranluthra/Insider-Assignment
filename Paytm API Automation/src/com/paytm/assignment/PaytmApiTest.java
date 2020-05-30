package com.paytm.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.paytm.assignment.model.UpcomingMovieData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PaytmApiTest {
	
	@Test
	public void testMovieData() {
	RestAssured.baseURI = "https://apiproxy.paytm.com/v2/movies/upcoming";
	
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.request(Method.GET);
	 Assert.assertEquals(response.getStatusCode(), 200, "Correct status code returned");

	 
	 JsonPath as = response.then().extract().body().jsonPath();
	 List<UpcomingMovieData> movieData = as.getList("upcomingMovieData", UpcomingMovieData.class);
	 
	 for(UpcomingMovieData movie:movieData) {
		 if(null!=movie.getReleaseDate()) {
			 Assert.assertEquals(movie.getReleaseDate().after(new Date()), true, 
						movie.getMoviename());
		 }
		 
		 if(null!=movie.getMoviePosterUrl()) {
			 Assert.assertEquals(movie.getMoviePosterUrl().contains(".jpg"), true, 
						movie.getMoviename());
		 }
		  
		 if(null!=movie.getLanguage()) {
			 String[] movieLanguages = movie.getLanguage().split(",");
			 Assert.assertEquals(movieLanguages.length < 2, true, 
						movie.getMoviename());
		 }
		 
	 }
	 
	 Set<String> movieCodes = new HashSet();
	 for(UpcomingMovieData movie:movieData) {
		 movieCodes.add(movie.getPaytmMovieCode());
	 }
	 Assert.assertEquals(movieCodes.size() == movieData.size(), true);
	 
	 writeMoviesToExcel(movieData);
	 
	}
	
	public void writeMoviesToExcel(List<UpcomingMovieData> movies) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("MovieNames");
		
		Row headerRow = sheet.createRow(0);
		Cell cell = headerRow.createCell(0);
		cell.setCellValue("MovieName");
		
		int rowNum = 1;
		for(UpcomingMovieData movie: movies) {
			if(movie.getIsContentAvailable() == 0) {
				Row row = sheet.createRow(rowNum);

	            row.createCell(0)
	                    .setCellValue(movie.getMoviename());
	            rowNum = rowNum+1;
			}
		}
		sheet.autoSizeColumn(0);
		try {
			FileOutputStream fileOut;
			File file = new File("movie-names.xlsx");
			file.createNewFile(); 
			fileOut = new FileOutputStream(file);
			workbook.write(fileOut);
			fileOut.close();

	        // Closing the workbook
	        workbook.close();
	        
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
