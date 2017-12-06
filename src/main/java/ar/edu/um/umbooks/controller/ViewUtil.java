package ar.edu.um.umbooks.controller;

import java.util.HashMap;

import org.eclipse.jetty.http.HttpStatus;

import spark.template.pebble.*;
import spark.ModelAndView;


import com.mitchellbosecke.pebble.PebbleEngine;
import com.mysql.fabric.Response;

import org.eclipse.jetty.http.*;

import spark.*;

import java.util.*;


public class ViewUtil {
	
	public static String render(Request request, HashMap<String, Object> model, String templatePath) {
        model.put("WebPath", Path.Web.class);
        return strictPebbleEngine().render(new ModelAndView(model, templatePath));
    }


   /*public static Route notFound = (Request request, Response response) -> {//Base de datos
        response.status(HttpStatus.NOT_FOUND_404);
        return render(request, new HashMap<>(), Path.Template.NOT_FOUND);
    };*///Es de la clase Logger

    private static PebbleTemplateEngine strictPebbleEngine() {
    	PebbleEngine engine = new PebbleEngine.Builder().build();
        return new PebbleTemplateEngine(engine);
    }

}
