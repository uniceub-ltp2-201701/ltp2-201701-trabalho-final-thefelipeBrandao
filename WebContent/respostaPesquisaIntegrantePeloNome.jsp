<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Integrante" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Integrantes</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
	
		<% ArrayList<Integrante> integrantes = (ArrayList<Integrante>) request.getAttribute("integrantes"); %>
		<% String nomeIntegrante = (String) request.getParameter("nomeIntegrante"); %>
		
	
		<div id="interface">
			<h2>Integrantes: " <%=nomeIntegrante %> "</h2>
				<fieldset id="lista">
					<legend><strong>Nomes dos Integrantes:</strong></legend>
					<% for(Integrante i : integrantes) { %>
						<fieldset id="listaPaginaInicial">
							<a id="imagens" href="detalhaIntegrante?idIntegrante=<%= i.getIdIntegrante()%>"><img id="imagemDetalhaFilme" src="<%=i.getUrlImagem() %>" alt="<%=i.getNome()%>"></a>
							<%=i.getNome()%>
						</fieldset>
					<%  }  %>
				</fieldset>
			<form action="/CatalogoDeFilmes/admin" method="post">
				<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Voltar para a página inicial">
			</form>	
		</div>
	</body>
</html>