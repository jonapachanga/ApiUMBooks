package ar.edu.um.umbooks.controller;

import java.util.HashMap;

import ar.edu.um.umbooks.db.BooksDB;
import spark.Request;
import spark.Response;
import spark.Route;

public class idController {
	public static Route detalleslibro = (Request request, Response response) -> {
    	BooksDB serviceBook = new BooksDB();
    	
        HashMap<String, Object> model = new HashMap<>();
       // model.put("idBook", serviceBook.idByName(request.queryParams("query")));
        return ViewUtil.render(request, model, Path.Template.SEARCH);
    };

}
