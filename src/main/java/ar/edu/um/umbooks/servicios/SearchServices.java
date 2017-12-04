package ar.edu.um.umbooks.servicios;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;


import ar.edu.um.umbooks.interfazbusqueda.Search;
import java.lang.reflect.ParameterizedType;


public class SearchServices<T> implements Search<T>{
	private queryBook<T> consulta;

	/**
	 * @param String cadena - Recibe parametro para la busqueda
	 * @author John
	 */
	public T getVolumenSearch(String cadena) throws MalformedURLException, IOException{
		cadena = URLEncoder.encode(cadena, "UTF-8");
		String url = api + "?q=" + cadena + "&key=" + apiKey;
		return consulta.getConsulta(url);

	}
	
	/**
	 * @param String filter - Filtro de busqueda
	 * @param String cadena - Recibe cadena de busqueda
	 * @author Natube
	 */
	public T getFilterSearch(String filter, String cadena) throws MalformedURLException, IOException {
		
		cadena = URLEncoder.encode(cadena, "UTF-8");
		String url = api + "?q=" + cadena + "&filter=" + filter + "&key=" + apiKey;
		
		return consulta.getConsulta(url);
	}
	
	/**
	 * @param String id - Recibe del ID de un libro especifico
	 * @author Flor
	 */
	public T getIDSearch(String id) throws MalformedURLException, IOException {
		
		String url = api + "/" + id + "?key=" + apiKey;
		
		return consulta.getConsulta(url);
	}
	
	public SearchServices() {
		super();
		consulta = new queryBook<T>(getGenericTypeClass());
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getGenericTypeClass() {
        try {
            String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
            Class<?> clazz = Class.forName(className);
            return (Class<T>) clazz;
        } catch (Exception e) {
        	throw new IllegalStateException("Clase no parametrizada con el tipo generico!!! Por favor use extends <> ");
        }
    }
}
