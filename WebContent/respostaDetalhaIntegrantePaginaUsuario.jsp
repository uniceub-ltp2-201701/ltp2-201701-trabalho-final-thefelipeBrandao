<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Integrante" %>
<%@ page import="model.Profissao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Filme" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Detalhes do Integrante</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
		
	</head>
	<body>
		<div id="interface">	
			<% Integrante integrante = (Integrante) request.getAttribute("integrante"); %>
			<% ArrayList<Profissao> profissoes = (ArrayList<Profissao>) request.getAttribute("profissoes"); %>
			<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes"); %>
			
			<h1><%=integrante.getNome() %></h1>
			<img id="imagemDetalhaFilme" src="<%=integrante.getUrlImagem() %>" alt="<%=integrante.getNome()%>">
			
			
			<fieldset id="informacoesDoIntegrante">
				<legend><strong>Informações do(a) Integrante</strong></legend>
				<strong>Nome: </strong><%= integrante.getNome() %><br>
				<strong>Gênero: </strong><a id="link" href="listaIntegrantesDeUmGeneroPaginaUsuario?genero=<%= integrante.getGenero()%>&generoNome=<%= integrante.getGeneroNome()%>"><%= integrante.getGeneroNome()%></a><br>
				<strong>Biografia: </strong><%= integrante.getBiografia() %><br>
				<strong>Data de nascimento: </strong><%= integrante.getNascimento() %><br>
				<strong>Papél(is) Empenhado(s): </strong>
				<% for(Profissao p : profissoes) { %>
						/<a id="link" href="listaFilmesDeUmaProfissaoDeUmIntegrantePaginaUsuario?idProfissao=<%=p.getIdProfissao()%>&idIntegrante=<%=integrante.getIdIntegrante()%>"><%=p.getNomeProfissao()%></a>			    	
				<%  }  %><br>
				<strong>Filme(s) feito(s): </strong>
				<% for(Filme f : filmes) { %>
						/<a id="link" href="detalhaFilmePaginaUsuario?idFilme=<%= f.getIdFilme() %>"><%= f.getNomeFilme() %></a>			    	
				<%  }  %>
			</fieldset><br>
			<h2><a id="link" href="/CatalogoDeFilmes/paginaInicial"> Voltar para a página inicial</a></h2>
		</div>	
	</body>
</html>