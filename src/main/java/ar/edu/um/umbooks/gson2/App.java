package ar.edu.um.umbooks.gson2;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.edu.um.umbooks.controller.*;
import ar.edu.um.umbooks.clasesapi.Items;
import ar.edu.um.umbooks.clasesapi.JSON;
import ar.edu.um.umbooks.servicios.SearchServices;
import ar.edu.um.umbooks.singleton.ApiProperty;

public class App {
	private static Logger logger = LoggerFactory.getLogger(App.class);
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
    				.getTitle();
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
    	
    	
    	// Configure Spark
        port(4567);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen();
        
        // Set up routes
        get(Path.Web.INDEX,     indexController.index);
        get(Path.Web.SEARCH,    searchController.resultadobusqueda);
        get(Path.Web.IDSEARCH,  idController.detalleslibro);
       // get("*",                ViewUtil.notFound);

        //Set up after-filters (called after each get/post)
        //after("*",                   Filters.addGzipHeader);//base de datos y crear clase
       
    }
}
