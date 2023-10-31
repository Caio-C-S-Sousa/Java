<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>AppVenda</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="#">AppVenda</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Vendedores</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Produtos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Aliment�cios</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Eletr�nicos</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	
	<div class="container mt-3">
	
		<span class="badge rounded-pill bg-primary">Vendedor</span>
	  	<span class="badge rounded-pill bg-secondary">Produto</span>
	  	<span class="badge rounded-pill bg-success">Aliment�cio</span>
	  	<span class="badge rounded-pill bg-danger">Eletr�nico</span>
  	
		<h2>AppVenda</h2>
		<p>Gest�o de vendas de produtos:</p>
		<table class="table">
			<thead class="table-dark">
				<tr>
				  <th>t�tulo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listagem}">
					<tr>
						<td>item</td>
						<td>${item}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>