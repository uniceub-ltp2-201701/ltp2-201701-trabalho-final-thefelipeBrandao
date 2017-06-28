<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Filmes de Um Ano</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
		<% String ano = (String) request.getAttribute("anoFilme"); %>
		<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes"); %>
		
		
		
		<div id="interface">
			<h2>Filme(s) de "<%=ano %>"</h2>
			<fieldset id="lista">
				<legend><strong>Nomes dos Filmes:</strong></legend>
					<% for(Filme f : filmes) { %>	
						<fieldset id="listaPaginaInicial">
							<a  id="imagens" href="detalhaFilme?idFilme=<%=f.getIdFilme()%>"><img id="imagemDetalhaFilme" src="<%=f.getURLImagem() %>" alt="<%=f.getNomeFilme()%>"></a>
						</fieldset>
					<%  }  %>
			</fieldset>
			<form action="/CatalogoDeFilmes/admin" method="post">
				<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Voltar para a p�gina inicial">
			</form>
		</div>
	</body>
</html>