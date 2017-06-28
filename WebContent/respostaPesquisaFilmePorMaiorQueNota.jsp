<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Filmes</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
		
		<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes"); %>
		<% String nota = (String) request.getParameter("nota"); %>
		
	
		<div id="interface">
			<h2>Filmes com nota <%=nota %> ou Maior</h2>
				<fieldset id="lista">
					<legend><strong>Nomes dos Filmes:</strong></legend>
						<% for(Filme f : filmes) { %>	
							<fieldset id="listaPaginaInicial">
								<a  id="imagens" href="detalhaFilmePaginaUsuario?idFilme=<%=f.getIdFilme()%>"><img id="imagemDetalhaFilme" src="<%=f.getURLImagem() %>" alt="<%=f.getNomeFilme()%>"></a>
							</fieldset>
						<%  }  %>
				</fieldset>
			<form action="/CatalogoDeFilmes/admin" method="post">
				<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Voltar para a página inicial">
			</form>	
		</div>
	
	</body>
</html>