# Paytm API Assignment

## Project Overview
Project contains below 2 files-<br> 
*UpcomingMovieData.java*<br>
It is object representation of API response for UpcomingMovieData

*PaytmApiTest.java*<br>
It contains a single test with below 5 assertions
1. Status code
2. Movie release date: should not be before today’s date
3. Movie Poster URL: should only have .jpg format
4. Paytm movie code: is unique
5. No movie code should have more than 1 language format

If any of the above assertion fails then test will fail otherwise it will pass.<br>

Once above steps are done, it will write movies names which has content available = 0 in excel file `movie-names.xlsx`

## Dependencies
- Java 8
- Eclipse
- Rest Assured
- TestNG
- Jackson
- Apache POI

*NOTE* - You can pick the dependencies from the `external-dependencies-for-reference` folder.

## Instructions
- Set up the above dependencies in Eclipse
- Run the `PaytmApiTest.java` as TestNG Test