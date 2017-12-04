package ar.edu.um.umbooks.servicios;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class queryBook<T> {
	
	private final Class<T> clasz;
	
	public queryBook(Class<T> clasz) {
		super();
		this.clasz = clasz;
	}

	public T getConsulta(String url) throws MalformedURLException, IOException {
		
		String json = IOUtils.toString(new URL(url), Charset.forName("UTF-8"));
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		T resultado =gson.fromJson(json, clasz);
		return resultado;
	}
	
    
}

