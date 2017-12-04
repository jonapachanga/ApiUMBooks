package ar.edu.um.umbooks.controller;

import java.util.HashMap;

import ar.edu.um.umbooks.db.BooksDB;
import spark.Request;
import spark.Response;
import spark.Route;

public class searchController {
	
	public static Route resultadobusqueda = (Request request, Response response) -> {
    	BooksDB serviceBook = new BooksDB();
    	
        HashMap<String, Object> model = new HashMap<>();
       // model.put("books", serviceBook.filterByName(request.queryParams("query")));
        return ViewUtil.render(request, model, Path.Template.SEARCH);
    };

}
