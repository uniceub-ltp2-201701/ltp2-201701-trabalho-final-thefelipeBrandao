<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Genero" %>
<%@ page import="model.Filme" %>
<%@ page import="model.Integrante" %>
<%@ page import="model.Profissao" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Detalhes do Filme</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
		<div id="interface">
			<% Filme filme = (Filme) request.getAttribute("filme"); %>
			<% ArrayList<Genero> generosDoFilme = (ArrayList<Genero>) request.getAttribute("generosDoFilme"); %>
			<% ArrayList<Integrante> integrantesDoFilme = (ArrayList<Integrante>) request.getAttribute("integrantesDoFilme"); %>
			<% ArrayList<Genero> todosOsGenerosDisponiveis = (ArrayList<Genero>) request.getAttribute("todosOsGenerosDisponiveis"); %>
			<% ArrayList<Profissao> todasAsProfissoes = (ArrayList<Profissao>) request.getAttribute("todasAsProfissoes"); %>
			<% ArrayList<Integrante> todosOsIntegrantesDisponiveis = (ArrayList<Integrante>) request.getAttribute("todosOsIntegrantesDisponiveis"); %>
			<% ArrayList<Integrante> todosOsIntegrantes = (ArrayList<Integrante>) request.getAttribute("todosOsIntegrantes"); %>
			<% ArrayList<Genero> todosOsGeneros = (ArrayList<Genero>) request.getAttribute("todosOsGeneros"); %>
			
			<h1><%=filme.getNomeFilme() %></h1>	
			<img id="imagemDetalhaFilme" src="<%=filme.getURLImagem() %>" alt="<%=filme.getNomeFilme()%>">
			
			<fieldset id="informacoesDoFilme">
				<legend><strong>Estado Atual Do Filme</strong></legend>
				<strong>Nome: </strong><%= filme.getNomeFilme() %><br>
				<strong>Ano: </strong><a id="link" href="listaFilmesDeUmAno?anoFilme=<%= filme.getAno()%>"><%= filme.getAno()%></a><br>
				<strong>Data de lançamento: </strong><%= filme.getDataLancamento() %><br>
				<strong>Duração: </strong><%= filme.getDuracao() %><br>
				<strong>Sinopse: </strong><%= filme.getSinopse() %><br>
				<strong>Avaliação: </strong><%= filme.getAvaliacao() %><br>
				<strong>Classificação Etária: </strong><%= filme.getClassificacao() %><br>
				<strong>Gêneros do Filme: </strong>
				<% for(Genero g : generosDoFilme) { %>
						/<a id="link" href="listaFilmesDeUmGenero?idGenero=<%= g.getIdGenero()%>&idFilme=<%=filme.getIdFilme()%>"><%= g.getNomeGenero() %></a>			    	
				<%  }  %><br>
				<strong>Integrantes do Filme: </strong>
				<% for(Integrante i : integrantesDoFilme) { %>
						/<a id="link" href="detalhaIntegrante?idIntegrante=<%= i.getIdIntegrante()%>"><%= i.getNome() %></a>			    	
				<%  }  %>
			</fieldset>
			
			<div id="adicionaGenero">
				<form action="/CatalogoDeFilmes/adicionaFilmeGenero">
					<fieldset id="adicionaGeneroIntegrante">
						<legend><strong>Adicionar Gênero(s) ao Filme?</strong></legend>
						<strong>Gênero do filme:</strong>
					    <select name="idGenero">
					    	<% for(Genero g : todosOsGenerosDisponiveis) { %>
					    	 	<option value="<%= g.getIdGenero()%>"><%=g.getNomeGenero() %></option>	
							<%  }  %> 
						</select><br>
						<input type='hidden' name="idFilme" value="<%=filme.getIdFilme()%>">
						<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Adicionar">
					</fieldset>
				</form><br>
			</div>	
			
			<div id="excluiGeneroDoFilme">
				<form action="/CatalogoDeFilmes/excluiGeneroDoFilme">
					<fieldset id="excluiGeneroIntegrante">
						<legend><strong>Excluir Gênero(s) do Filme?</strong></legend>
						<strong>Gênero do filme:</strong>
					    <select name="idGenero">
					    	<% for(Genero g : generosDoFilme) { %>
					    	 	<option value="<%= g.getIdGenero()%>"><%=g.getNomeGenero() %></option>	
							<%  }  %> 
						</select><br>
						<input type='hidden' name="idFilme" value="<%=filme.getIdFilme()%>">
						<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Excluir">
					</fieldset>
				</form><br>
			</div>	
			
			<div id="adicionaElenco">		
				<form action="/CatalogoDeFilmes/adicionaFilmeIntegranteProfissao">
					<fieldset id="adicionaGeneroIntegrante">
						<legend><strong>Adicionar Elenco ao Filme?</strong></legend>
						<strong>Integrante:</strong>
					    <select name="idIntegrante">
					    	<% for(Integrante i : todosOsIntegrantes) { %>
					    	 	<option value="<%= i.getIdIntegrante()%>" ><%= i.getNome() %></option>	
							<%  }  %> 
						</select>
						<strong>foi</strong>
					    <select name="idProfissao">
					    	<% for(Profissao p : todasAsProfissoes) { %>
					    	 	<option value="<%= p.getIdProfissao()%>"><%= p.getNomeProfissao() %></option>	
							<%  }  %> 
						</select><strong> nesse filme.</strong><br>
						<input type='hidden' name="idFilme" value="<%=filme.getIdFilme()%>">
						<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Adicionar">
				 	 </fieldset>
				</form><br>
			</div>
			
			<div id="excluiElenco">		
				<form action="/CatalogoDeFilmes/excluiIntegranteDoFilme">
					<fieldset id="excluiGeneroIntegrante">
						<legend><strong>Excluir Elenco do Filme?</strong></legend>
						<strong>Integrante:</strong>
					    <select name="idIntegrante">
					    	<% for(Integrante i : integrantesDoFilme) { %>
					    	 	<option value="<%= i.getIdIntegrante()%>" ><%= i.getNome() %></option>	
							<%  }  %> 
						</select>
						<strong>foi</strong>
					    <select name="idProfissao">
					    	<% for(Profissao p : todasAsProfissoes) { %>
					    	 	<option value="<%= p.getIdProfissao()%>"><%= p.getNomeProfissao() %></option>	
							<%  }  %> 
						</select><strong> nesse filme.</strong><br>
						<input type='hidden' name="idFilme" value="<%=filme.getIdFilme()%>">
						<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Excluir">
				 	 </fieldset>
				</form><br>
			</div>
			
			<form action="/CatalogoDeFilmes/admin" method="post">
				<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Voltar para a página inicial">
			</form>
			
		</div>
	</body>
</html>