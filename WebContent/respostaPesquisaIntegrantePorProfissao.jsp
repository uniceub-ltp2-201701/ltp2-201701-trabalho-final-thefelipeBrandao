<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Integrante" %>
<%@ page import="model.Profissao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Integrantes</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
	
		<% Profissao profissao = (Profissao) request.getAttribute("profissao"); %>
		<% ArrayList<Integrante> integrantes = (ArrayList<Integrante>) request.getAttribute("integrantes"); %>
	
		<div id="interface">
			<h2><%= profissao.getNomeProfissao() %></h2>
				<fieldset id="lista">
					<legend><strong>Nome(s) do(s) Integrante(s):</strong></legend>
					<ul>
						<% for(Integrante i : integrantes) { %>
							<li><h3><a id="link" href="detalhaIntegrante?idIntegrante=<%= i.getIdIntegrante()%>"><%= i.getNome() %></a></h3></li>
						<%  }  %>
					</ul>	
				</fieldset>
			<form action="/CatalogoDeFilmes/admin" method="post">
				<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Voltar para a página inicial">
			</form>
		</div>
		
	</body>
</html>