<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Integrante" %>
<%@ page import="model.Profissao" %>
<%@ page import="java.util.ArrayList" %>
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
			<% Integrante integrante = (Integrante) request.getAttribute("integrante"); %>
			<% Profissao profissao = (Profissao) request.getAttribute("profissao"); %>
			<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes"); %>
				
			<h1><%=integrante.getNome() %> como <%=profissao.getNomeProfissao() %>:</h1>
			<fieldset id="lista">
				<legend><strong>Nome(s) do(s) filme(s)</strong></legend>
					<% for(Filme f : filmes) { %>
						<fieldset id="listaPaginaInicial">
							<a  id="imagens" href="detalhaFilme?idFilme=<%=f.getIdFilme()%>"><img id="imagemDetalhaFilme" src="<%=f.getURLImagem() %>" alt="<%=f.getNomeFilme()%>"></a>
						</fieldset>					    	
					<%  }  %>
			</fieldset><br>
			<h2><a id="link" href="detalhaIntegrante?idIntegrante=<%= integrante.getIdIntegrante()%>">Voltar Para página do(a) <%=integrante.getNome() %></a></h2>
			<form action="/CatalogoDeFilmes/admin" method="post">
				<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Voltar para a página inicial">
			</form>
		</div>	
	</body>
</html>