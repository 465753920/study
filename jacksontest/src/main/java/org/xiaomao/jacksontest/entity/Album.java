package org.xiaomao.jacksontest.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album {
	private String title;
	private String[] links;
	private List<String> songs;
	private Artist artist;
	private Map<String, String> musicians = new HashMap<String, String>();

	public Album(String title) {
		this.title = title;
	}

	public void addMusician(String musicianName, String instrument) {
		musicians.put(musicianName, instrument);
	}

	public Artist getArtist() { return artist; }

	public void setArtist(Artist artist) { this.artist = artist; }

	public Map<String, String> getMusicians() { return musicians; }

	public void setMusicians(Map<String, String> musicians) { this.musicians = musicians; }

	public List<String> getSongs() { return songs; }

	public void setSongs(List<String> songs) { this.songs = songs; }

	public String[] getLinks() { return links; }

	public void setLinks(String[] links) { this.links = links; }

	public String getTitle() { return title; }

	public void setTitle(String title) { this.title = title; }
}
