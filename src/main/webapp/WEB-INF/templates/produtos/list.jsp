<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
	<c:import url="/WEB-INF/templates/common/_metatags.jsp" />
	<c:import url="/WEB-INF/templates/common/_bootstrap_css.jsp" />
	<title>Produtos</title>
</head>
<body class="container">
	<h1>Produtos</h1> 
	
	<c:if test="${param.success}">
		<div class="alert alert-success" role="alert">
		  Produtos criado com sucesso!
		</div>
	</c:if>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nome</th>
				<th scope="col">Preço</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="produto" items="${Produto}">
				<tr>
					<th scope="row">${produto.id}</th>
					<td>${produto.nome}</td>
					<td>${produto.preco}</td>
					<td>
						<a href="/produtos/edit/${produto.id}">Editar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/produtos/create" class="btn btn-primary">Criar</a>
	
	<c:import url="/WEB-INF/templates/common/_bootstrap_js.jsp" />
	
</body>
</html>