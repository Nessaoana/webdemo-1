package webdemo.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webdemo.entidades.Produto;

public class ProdutosController extends Controller {
	
	public ProdutosController(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void list() throws ServletException, IOException {
		List<Produto> produtos = Produto.Todos();
		getRequest().setAttribute("Produto", produtos);
			
		getRequest().getRequestDispatcher("/WEB-INF/templates/produtos/list.jsp")
			.forward(getRequest(), getResponse());
	}
	
	@Override
	public void show(int id) {
		//TODO: Implementar
	}
	
	@Override
	public void create() throws ServletException, IOException {
		getRequest().getRequestDispatcher("/WEB-INF/templates/produtos/criar.jsp")
			.forward(getRequest(), getResponse());
	}
	
	@Override
	public void create(Map<String, String> formData) throws IOException, ServletException {
		
		if(isValid(formData)) {
			String nome = formData.get("nome");
			
			
			float preco = Float.parseFloat((formData.get("preco")));
			
			Produto produto = new Produto(nome, preco);
			produto.salvar();
			
			getResponse().sendRedirect("/produtos?success=true");
		}else {
			getRequest()
				.getRequestDispatcher("/WEB-INF/templates/produtos/criar.jsp?success=false")
				.forward(getRequest(), getResponse());
		}
	}
	
	@Override
	public void edit(int id) throws ServletException, IOException {
		Produto produto = Produto.GetById(id);
		
		getRequest().setAttribute("Produto", produto);
		
		getRequest().getRequestDispatcher("/WEB-INF/templates/produtos/editar.jsp")
			.forward(getRequest(), getResponse());	
	}
	
	@Override
	public void edit(int id, Map<String, String> formData) throws IOException, ServletException {
		Produto produto = Produto.GetById(id);
		
		String nome = formData.get("nome");
		float preco = Float.parseFloat((formData.get("preco")));
		
		if(isValid(formData)) {
			produto.setNome(nome);
			produto.setPreco(preco);
			produto.salvar();
			
			getResponse().sendRedirect("/produtos?success=true");
		}else {
			Produto usuarioInvalido = new Produto(nome, preco);
			usuarioInvalido.setId(id);
			getRequest().setAttribute("Produto", produto);
			
			getRequest()
				.getRequestDispatcher("/WEB-INF/templates/produtos/editar.jsp?success=false")
				.forward(getRequest(), getResponse());
		}
	}
	
	private boolean isValid(Map<String, String> formData) throws UnsupportedEncodingException {
		boolean isValid = true;
	
		if(!formData.containsKey("nome") || formData.get("nome").isEmpty()) {
			getRequest().setAttribute("NomeInvalido", "O nome � obrigat�rio!");
			isValid = false;
		}
		
		if(!formData.containsKey("preco") || formData.get("preco").isEmpty()) {
			getRequest().setAttribute("PrecoInvalido", "O preco � obrigat�rio!");
			isValid = false;
		}
				
		return isValid;
	}
}
