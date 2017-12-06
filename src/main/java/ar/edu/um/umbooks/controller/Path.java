package ar.edu.um.umbooks.controller;

import lombok.*;

public class Path {
	public static class Web {
        @Getter public static final String INDEX = "/";
        @Getter public static final String SEARCH = "/search/";
        @Getter public static final String IDSEARCH = "/idsearch/";
        
	}
	
	 public static class Template {
		 public final static String INDEX 	= "spark/template/pebble/index/index.php.twig";
		 public final static String SEARCH	= "spark/template/pebble/search/search.php.twig";
		 public final static String IDSEARCH = "spark/template/pebble/idsearch/idsearch.twig";
		 public static final String NOT_FOUND = "spark/template/pebble/errors/404.php.twig";
	    }
	
	 
}

