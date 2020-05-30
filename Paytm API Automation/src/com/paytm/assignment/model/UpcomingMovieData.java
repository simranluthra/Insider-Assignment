package com.paytm.assignment.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpcomingMovieData {
	private String moviePosterUrl;
	
	private Date releaseDate;
	
	private String paytmMovieCode;
	
	private String language;
	
	@JsonProperty("provider_moviename")
	private String moviename;
	
	private int isContentAvailable;
	
	public int getIsContentAvailable() {
		return isContentAvailable;
	}

	public void setIsContentAvailable(int isContentAvailable) {
		this.isContentAvailable = isContentAvailable;
	}

	public UpcomingMovieData() {
	}

	public String getMoviePosterUrl() {
		return moviePosterUrl;
	}

	public void setMoviePosterUrl(String moviePosterUrl) {
		this.moviePosterUrl = moviePosterUrl;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPaytmMovieCode() {
		return paytmMovieCode;
	}

	public void setPaytmMovieCode(String paytmMovieCode) {
		this.paytmMovieCode = paytmMovieCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
}
