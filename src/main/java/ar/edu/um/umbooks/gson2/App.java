package ar.edu.um.umbooks.gson2;

import ar.edu.um.umbooks.clasesapi.Items;
import ar.edu.um.umbooks.clasesapi.JSON;
import ar.edu.um.umbooks.servicios.SearchServices;
import ar.edu.um.umbooks.singleton.ApiProperty;

public class App 
{
    public static void main( String[] args ) throws Exception  {
    	try {
    		
    		SearchServices<JSON> volumen = new SearchServices<JSON>() {};
    		SearchServices<JSON> filtro = new SearchServices<JSON>() {};
    		SearchServices<Items> id = new SearchServices<Items>() {};
    		
    		String key = ApiProperty.getInstance().getPropiedades("key");
    		
    		
    		String idBook = volumen.getVolumenSearch("harry potter").getItems().get(0).getId();
    		String resultFilter = filtro.getFilterSearch("paid-ebooks", "harry potter")
    				.getItems()
    				.get(0)
    				.getVolumeInfo()
    				.getAuthors().get(0);
    		String resultId = id.getIDSearch(idBook)
    				.getVolumeInfo()
    				.getTitle();
    		
    		System.out.println(idBook);
    		System.out.println(resultFilter);
    		System.out.println(resultId);
    		System.out.println(key);
    		 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  	
       
    }
}
