package webdemo;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import webdemo.controllers.ProdutosController;

//@WebServlet("/produtos")
public class ProdutosServlet extends HttpServlet {

	@Override	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws IOException, ServletException {
		
		new ProdutosController(request, response)
			.list();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HashMap<String, String> formData = new HashMap<String, String>();
		
		Enumeration<String> param = request.getParameterNames();
		
		while(param.hasMoreElements()) {
			String element = param.nextElement();
			formData.put(element, request.getParameter(element));
		}
		
		new ProdutosController(request, response)
			.create(formData);
	}				
	
	private static final long serialVersionUID = 3931640733487616093L;
}
