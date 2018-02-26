package ar.edu.um.umbooks.gson2;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.edu.um.umbooks.controller.*;
import java.io.ObjectOutput;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ar.edu.um.umbooks.persistencia.jpa.JPAHelper;//
import ar.edu.um.umbooks.persistencia.jpa.impl.DAOImpl;
import ar.edu.um.umbooks.persistencia.jpa.impl.VolumenInfoDAOImpl;
import ar.edu.um.umbooks.persistencia.dao.CRUDInterface;
import ar.edu.um.umbooks.clasesapi.Items;
import ar.edu.um.umbooks.clasesapi.JSON;
import ar.edu.um.umbooks.clasesapi.VolumeInfo;
import ar.edu.um.umbooks.servicios.SearchServices;
import ar.edu.um.umbooks.singleton.ApiProperty;

public class App {
	private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) throws Exception  {
    	try {
    		
    		CRUDInterface<VolumeInfo, Integer> service = new VolumenInfoDAOImpl();
    		
    		SearchServices<JSON> volumen = new SearchServices<JSON>() {};
    		//SearchServices<JSON> filtro = new SearchServices<JSON>() {};
    		SearchServices<Items> id = new SearchServices<Items>() {};
    		
    		String key = ApiProperty.getInstance().getPropiedades("key");
    		
    		
    		String idBook = volumen.getVolumenSearch("harry potter").getItems().get(0).getId();
    		
    		System.out.println(idBook);
    		VolumeInfo volumeInfo = id.getIDSearch(idBook)
    				.getVolumeInfo();
    		
    		System.out.println(volumeInfo.getTitle());
    		
    		service.create(volumeInfo);


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
        get(Path.Web.SEARCH,    searchController.search);
        get(Path.Web.IDSEARCH,  idController.idsearch);
        //get("*",                ViewUtil.notFound);

        //Set up after-filters (called after each get/post)
        //after("*",                   Filters.addGzipHeader);//base de datos y crear clase
       
    }
}
