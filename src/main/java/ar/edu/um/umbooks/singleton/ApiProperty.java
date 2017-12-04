package ar.edu.um.umbooks.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ApiProperty {
	private Properties propiedades;
	private static ApiProperty INSTANCE;
	
	private ApiProperty() {
		this.propiedades = new Properties();
		try {
			propiedades.load(new FileInputStream(new File("api.properties")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPropiedades(String clave) {
		return propiedades.getProperty(clave).trim();
	}

	public static ApiProperty getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ApiProperty();
		}
		return INSTANCE;
	}

	
	
	
	

}
