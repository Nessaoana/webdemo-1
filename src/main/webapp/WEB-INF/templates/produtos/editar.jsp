<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="minha" tagdir="/WEB-INF/tags" %>

<!doctype html>
<html lang="en">
<head>
	<c:import url="/WEB-INF/templates/common/_metatags.jsp" />
	<c:import url="/WEB-INF/templates/common/_bootstrap_css.jsp" />	
	<title>Editar produto</title>
</head>
<body class="container">
	<h1>Editar produto</h1>
	
	<form method="post" action="/produtos/edit/${Produto.id}">
		<div class="form-group">
		<minha:validatedinputtext rotulo="Nome" valor="${Produto.nome}"
			erroValidacao="${NomeInvalido}" invalido="${empty NomeInvalido}"
			textoPlaceholder="Seu Nome" 
			idCampo="nome-input" nomeCampo="nome" /> 
		</div>
		<div class="form-group">
			<minha:validatedinputtext rotulo="Preço" valor="${Produto.preco}"
				erroValidacao="${PreçoInvalido}" invalido="${empty PrecoInvalido}"
				textoPlaceholder="Preço"
				idCampo="sobrenome-input" nomeCampo="preco" />	
		</div>
		
		<a href="/produtos" class="btn btn-danger">Cancelar</a>
		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>

	<c:import url="/WEB-INF/templates/common/_bootstrap_js.jsp" />
</body>
</html>