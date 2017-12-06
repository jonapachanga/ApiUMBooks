package ar.edu.um.umbooks.gson2;

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

public class App 
{
	
    @SuppressWarnings("null")
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
       
    }
}
