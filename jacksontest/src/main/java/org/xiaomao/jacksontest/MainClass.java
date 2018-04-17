package org.xiaomao.jacksontest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.xiaomao.jacksontest.entity.Album;
import org.xiaomao.jacksontest.entity.Artist;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

	private JsonNode album;

	public static void main(String[] args) {
		MainClass mainClass = new MainClass();

		mainClass.objectMapperTest();
//		mainClass.treeModelTest();
	}

	public void objectMapperTest() {
		ObjectMapper mapper = new ObjectMapper();
		Album album = new Album("Kind Of Blue");
		album.setLinks(new String[]{"link1", "link2"});
		List<String> songs = new ArrayList<String>();
		songs.add("So What");
		songs.add("Flamenco Sketches");
		songs.add("Freddie Freeloader");
		album.setSongs(songs);
		Artist artist = new Artist();
		artist.setName("Miles Davis");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			artist.setBirthDate(format.parse("1926-05-26"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		album.setArtist(artist);
		album.addMusician("Miles Davis", "Trumpet, Band leader");
		album.addMusician("Julian Adderley", "Alto Saxophone");
		album.addMusician("Paul Chambers", "double bass");
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy MM dd");
		mapper.setDateFormat(outputFormat);
		mapper.setPropertyNamingStrategy(new PropertyNamingStrategy() {
			@Override
			public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
				if (field.getFullName().equals("org.xiaomao.jacksontest.entity.Artist#name"))
					return "Artist-Name";
				return super.nameForField(config, field, defaultName);
			}

			@Override
			public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
				if (method.getAnnotated().getDeclaringClass().equals(Album.class) && defaultName.equals("title"))
					return "Album-Title";
				return super.nameForGetterMethod(config, method, defaultName);
			}
		});
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		try {
			mapper.writeValue(System.out, album);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void treeModelTest() {

		JsonFactory jsonFactory = new JsonFactory();
		JsonGenerator generator = null;
		try {
			generator = jsonFactory.createGenerator(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();

		ObjectNode album = JsonNodeFactory.instance.objectNode();
		album.put("Album-Title","Kind Of Blue");

		try {
			mapper.writeTree(generator, album);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

