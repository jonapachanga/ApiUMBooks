package ar.edu.um.umbooks.controller;

import java.util.HashMap;

import spark.Request;
import spark.Response;
import spark.Route;

public class indexController {
	 public static Route index = (Request request, Response response) -> {
	        HashMap<String, Object> model = new HashMap<>();
	        return ViewUtil.render(request, model, Path.Template.INDEX);
	    };
	 

}
