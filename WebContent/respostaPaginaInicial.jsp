<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Filme" %>
<%@ page import="model.Genero" %>
<%@ page import="model.Profissao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Catalogo De Filmes</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
		<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes"); %>
		<% ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos"); %>
		<% ArrayList<Profissao> profissoes = (ArrayList<Profissao>) request.getAttribute("profissoes"); %>
		
		<form action="/CatalogoDeFilmes/login" method="post">
			<div id="loginArea">
				<strong>Nome: </strong><input type="text" name="nome">
				<strong>Senha: </strong><input type="password" name="senha">
				<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Login">	
			</div>
		</form>
		
		<div id="areaPesquisaFilmePaginaInicial">
			<form action="/CatalogoDeFilmes/pesquisaFilmePeloNomePaginaUsuario">
				<strong>Pesquisar Filme: </strong><br><input id="campoLista" type="text" name="nomeFilme" value="Nome">
				<input id="botao" type="submit" value="Ir">				
			</form>
		
			<form action="/CatalogoDeFilmes/pesquisaIntegrantePeloNomePaginaUsuario">
				<strong>Pesquisar Pessoa: </strong><br><input id="campoLista" type="text" name="nomeIntegrante" value="Nome">
				<input id="botao" type="submit" value="Ir">				
			</form>
			
			<form action="/CatalogoDeFilmes/pesquisaFilmePeloGeneroPaginaUsuario">
				<strong>Pesquisar Filmes de:</strong><br>
				<select id="opcaoDeLista" name="idGenero"> 
					<% for(Genero g : generos) { %>
						<option value="<%= g.getIdGenero()%>"><%=g.getNomeGenero() %></option>	
					<%  }  %> 
				</select>
				<input id="botao" type="submit" value="Ir">				
			</form>
		
			<form action="/CatalogoDeFilmes/pesquisaIntegrantePorProfissaoPaginaUsuario">
				<strong>Pesquisar:</strong><br>
				<select id="opcaoDeLista" name="idProfissao">
					<% for(Profissao p : profissoes) { %>
						<option value="<%= p.getIdProfissao()%>"><%= p.getNomeProfissao() %></option>	
					<%  }  %> 
				</select>
				<input id="botao" type="submit" value="Ir">				
			</form>
			
			<form action="/CatalogoDeFilmes/pesquisaFilmePorNotaMenorQuePaginaUsuario">
				<strong>Filme(s) com nota</strong><br>
				<select id="opcaoDeLista" name="nota">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select><strong> ou Menor:</strong>
				<input id="botao" type="submit" value="Ir">				
			</form>
			
			<form action="/CatalogoDeFilmes/pesquisaFilmePorNotaMaiorQuePaginaUsuario">
				<strong>Filme(s) com nota</strong><br>
				<select id="opcaoDeLista" name="nota">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select><strong> ou Maior:</strong>
				<input id="botao" type="submit" value="Ir">				
			</form>
			
		</div>
		
		<div id="adicionaFilmePaginaInicial">
			<% for(Filme f : filmes) { %>
				<fieldset id="listaPaginaInicial">
					<a  id="imagens" href="detalhaFilmePaginaUsuario?idFilme=<%=f.getIdFilme()%>"><img id="imagemDetalhaFilme" src="<%=f.getURLImagem() %>" alt="<%=f.getNomeFilme()%>"></a>
				</fieldset>
			<%  }  %>
		</div>
	</body>
</html>