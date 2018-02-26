package ar.edu.um.umbooks.interfazbusqueda;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import ar.edu.um.umbooks.singleton.ApiProperty;

public interface Search<T> {
	
	static final String api = ApiProperty.getInstance().getPropiedades("url");
	static final String apiKey = ApiProperty.getInstance().getPropiedades("key");

	public T getVolumenSearch(String cadena)throws UnsupportedEncodingException, IOException;
	public T getFilterSearch(String filter, String cadena)throws MalformedURLException, IOException;
	public T getIDSearch(String id)throws MalformedURLException, IOException ;
}
