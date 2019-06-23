<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<link rel="stylesheet" type="text/css" href="/agenda/resources/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/agenda/resources/css/application.css" />
		
		<title>Agenda</title>
	</head>
	
	<body>
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="clearfix">
					<h1 class="panel-title titulo-panel">Contatos</h1>
					<a class="btn btn-link link-panel">
						Novo Contato
					</a>
				</div>
			</div>
				
			<div class="panel-body">
				<div class="cb-table">
					<table class="table">
						<tr>
							<th>#ID</th>
							<th>Nome</th>
							<th>Data Nascimento</th>
							<th>Email</th>
							<th>Endereço</th>
						</tr>
						
						<c:forEach var="contato" items="${contatos}">
							<tr>
								<td>${contato.id}</td>						
								<td>${contato.nome}</td>						
								<td>${contato.dataNascimento}</td>						
								<td>${contato.email}</td>						
								<td>${contato.endereco}</td>						
							</tr>						
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>
