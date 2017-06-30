<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Genero" %>
<%@ page import="model.Filme" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Filmes</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
		<div id="interface">	
			
			<% Filme filme = (Filme) request.getAttribute("filme"); %>
			<% Genero genero = (Genero) request.getAttribute("genero"); %>
			<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes"); %>
				
			<h1>Filmes de <%=genero.getNomeGenero() %></h1>
			<fieldset id="lista">
				<legend><strong>Lista de Todos os Filmes</strong></legend>
					<% for(Filme f : filmes) { %>	
						<fieldset id="listaPaginaInicial">
							<a  id="imagens" href="detalhaFilme?idFilme=<%=f.getIdFilme()%>"><img id="imagemDetalhaFilme" src="<%=f.getURLImagem() %>" alt="<%=f.getNomeFilme()%>"></a>	
						</fieldset>
					<%  }  %>
			</fieldset>
			<h2><a id="link" href="detalhaFilme?idFilme=<%= filme.getIdFilme() %>">Voltar para a página do(a) <%=filme.getNomeFilme() %></a></h2>
			<form action="/CatalogoDeFilmes/admin" method="post">
				<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Voltar para a página inicial">
			</form>
		</div>	
	</body>
</html>