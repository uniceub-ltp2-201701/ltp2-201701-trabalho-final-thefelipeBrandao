<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Integrante" %>
<%@ page import="model.Genero" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Detalhes do Filme</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
		
		<script type="text/javascript">
			function funcaoAvaliar(nota) {
				document.getElementById("avaliar").value="Avaliar("+ nota +")"; 
			}
		</script>
	
		<div id="interface">
			<% Filme filme = (Filme) request.getAttribute("filme"); %>
			<% ArrayList<Genero> generosDoFilme = (ArrayList<Genero>) request.getAttribute("generosDoFilme"); %>
			<% ArrayList<Integrante> integrantesDoFilme = (ArrayList<Integrante>) request.getAttribute("integrantesDoFilme"); %>
			<% String nota = filme.getAvaliacao() == 0 ? "0/" + "("+filme.getVotos()+")" : String.format("%.2f", filme.getAvaliacao()/filme.getVotos()) + "/" + "("+filme.getVotos() + ")"; %>
			
			<h1><%=filme.getNomeFilme() %></h1>	
			<img id="imagemDetalhaFilme" src="<%=filme.getURLImagem() %>" alt="<%=filme.getNomeFilme()%>">
			
			<fieldset id="informacoesDoFilme">
				<legend><strong>Estado Atual Do Filme</strong></legend>
				<strong>Nome: </strong><%= filme.getNomeFilme() %><br>
				<strong>Ano: </strong><a id="link" href="listaFilmesDeUmAnoPaginaUsuario?anoFilme=<%= filme.getAno()%>"><%= filme.getAno()%></a><br>
				<strong>Data de lançamento: </strong><%= filme.getDataLancamento() %><br>
				<strong>Duração: </strong><%= filme.getDuracao() %><br>
				<strong>Sinopse: </strong><%= filme.getSinopse() %><br>
				<strong>Avaliação: </strong><%=nota %><br>
				<strong>Classificação Etária: </strong><%= filme.getClassificacao() %><br>
				<strong>Gêneros do Filme: </strong>
				<% for(Genero g : generosDoFilme) { %>	
						/<a id="link" href="listaFilmesDeUmGeneroPaginaUsuario?idGenero=<%= g.getIdGenero()%>&idFilme=<%=filme.getIdFilme()%>"><%= g.getNomeGenero() %></a>			    	
				<%  }  %><br>
				<strong>Integrantes do Filme: </strong>
				<% for(Integrante i : integrantesDoFilme) { %>
						/<a id="link" href="detalhaIntegrantePaginaUsuario?idIntegrante=<%= i.getIdIntegrante()%>"><%= i.getNome() %></a>			    	
				<%  }  %>
			</fieldset>
			
			<form action="/CatalogoDeFilmes/avaliaFilme">
				<fieldset id="avaliacaoDoFilme">
					<legend><strong>Avalie esse filme</strong></legend>
					<strong>Nota(0-10):</strong>
					<input type="range"  name="nota" min="0" max="10" value="nota" onchange="funcaoAvaliar(this.value);">
					<input type="hidden" name="idFilme" value="<%= filme.getIdFilme() %>">
					<input id="avaliar" type="submit" value="Avaliar(5)">
				</fieldset>
			</form>
			<h2><a id="link" href="/CatalogoDeFilmes/paginaInicial"> Voltar para a página inicial</a></h2>
		</div>
	
	</body>
</html>