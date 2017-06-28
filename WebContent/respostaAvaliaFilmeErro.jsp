<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Erro ao Avaliar Filme</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
		
		<% Filme filme = (Filme) request.getAttribute("filme"); %>
		<div id="interface">
			<form action="/CatalogoDeFilmes/detalhaFilmePaginaUsuario">
				<h1>Erro ao Avaliar Filme</h1>
				<input type='hidden' name="idFilme" value="<%=filme.getIdFilme()%>">
				<input id="botao" type="submit" value="OK">
			</form>
		</div>	
	</body>
</html>