<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Genero" %>
<%@ page import="model.Filme" %>
<%@ page import="model.Integrante" %>
<%@ page import="model.Profissao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administrador</title>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	<body>
			<% ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos"); %>
			<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes"); %>
			<% ArrayList<Profissao> profissoes = (ArrayList<Profissao>) request.getAttribute("profissoes"); %>
			<% ArrayList<Integrante> integrantes = (ArrayList<Integrante>) request.getAttribute("integrantes"); %>
				
			<div id="pesquisaArea">
				<ul>
					<li>
						<form action="/CatalogoDeFilmes/pesquisaFilmePeloNome">
							<strong>Pesquisar Filme: </strong><br><input id="campoLista" type="text" name="nomeFilme" value=" Nome">
							<input id="botao" type="submit" value="Ir">				
						</form>
					</li>
					<li>
						<form action="/CatalogoDeFilmes/pesquisaFilmePeloGenero">
							<strong>Pesquisar Filmes de</strong><br>
							<select id="opcaoDeLista" name="idGenero"> 
						    	<% for(Genero g : generos) { %>
						    	 	<option value="<%= g.getIdGenero()%>"><%=g.getNomeGenero() %></option>	
								<%  }  %> 
							</select>
							<input id="botao" type="submit" value="Ir">				
						</form>
					</li>
					<li>
						<form action="/CatalogoDeFilmes/pesquisaIntegrantePorProfissao">
							<strong>Pesquisar <br></strong>
							<select id="opcaoDeLista" name="idProfissao">
						    	<% for(Profissao p : profissoes) { %>
						    	 	<option value="<%= p.getIdProfissao()%>"><%= p.getNomeProfissao() %></option>	
								<%  }  %> 
							</select>
							<input id="botao" type="submit" value="Ir">				
						</form>
					</li>
					<li>
						<form action="/CatalogoDeFilmes/pesquisaFilmePorNotaMenorQue">
							<strong>Filme(s) com nota</strong>
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
							</select><strong> ou Menor</strong>
							<input id="botao" type="submit" value="Ir">				
						</form>
					</li><br>
					<li>	
						<form action="/CatalogoDeFilmes/pesquisaFilmePorNotaMaiorQue">
							<strong>Filme(s) com nota</strong>
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
							</select><strong> ou Maior</strong>
							<input id="botao" type="submit" value="Ir">				
						</form>
					</li><br><br>
					<li>
						<form action="/CatalogoDeFilmes/paginaInicial">
							<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Logout">				
						</form>
					</li>
				</ul>	
			</div><br>
			
			<div id="interface">
				
				<div id="adicionaFilme">
					<h2>Adicione um novo Filme</h2>
					
					<form action="/CatalogoDeFilmes/adicionaFilme"  method="post">
						<fieldset id="adicionaFilme">
							 <legend><strong>Informe as Informações do Filme</strong></legend>
							 <strong>Nome do filme: </strong><input type="text" name="nomeFilme"><br>
							 <strong>Ano: </strong><input type="text" name="anoFilme"><br>
							 <strong>Data de Lançamento: </strong><input type="date" name="dataLancamentoFilme"><br>
							 <strong>Duração(MIN): </strong><input type="text" name="duracaoFilme"><br>
							 <strong>Sinopse: </strong><input type="text" name="sinopseFilme"><br>
							 <strong>Avaliação(Inicial): </strong> 0<input type="radio" name="avaliacaoFilme" value="0"><br>
							 <strong>Cassificação Etária: </strong><input type="text" name="classificacaoFilme"><br>
							 <strong>Imagem do Filme(URL): </strong><input type="text" name="urlImagemFilme"><br>
							 <input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Adicionar">
						</fieldset>
					</form>
				</div>
				
				
				<h2>Lista de Todos os Filmes</h2>
				<fieldset id="lista">
					<legend><strong>Nomes dos Filmes:</strong></legend>
					<ul>
						<% for(Filme f : filmes) { %>	
							<li><h3> - <a id="link" href="detalhaFilme?idFilme=<%= f.getIdFilme() %>"><%= f.getNomeFilme() %></a></h3></li>
						<%  }  %>
					</ul>	
				</fieldset>
				
				
				<div id="adicionaIntegrante">	
					<h2>Adicione um novo Integrante</h2>
					<form action="/CatalogoDeFilmes/adicionaIntegrante" method="post">
						<fieldset id="campoIntegrante">
						    <legend><strong>Informações do Integrante</strong></legend>
						    <strong>Nome:</strong><input type="text" name="nomeIntegrante"><br>
						    <strong>Genero:</strong>  Masculino<input type="radio" name="generoIntegrante" value="m">  Feminino<input type="radio" name="generoIntegrante" value="f"><br>
						    <strong>Biografia:</strong><input type="text" name="bioIntegrante"><br>
						    <strong>Data de nascimento:</strong><input type="date" name="nascimento"><br>
						    <strong>Imagem do Integrante(URL): </strong><input type="text" name="urlImagemIntegrante"><br>
							<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Adicionar">
					 	 </fieldset>
					</form>
				</div>
				
				
				<h2>Lista de Todos os Integrantes(Atores, Diretores...)</h2>
				<fieldset id="lista">
					<legend><strong>Nomes dos Integrentes:</strong></legend>
					<ul>
						<% for(Integrante i : integrantes) { %>
							<li><h3> - <a id="link" href="detalhaIntegrante?idIntegrante=<%= i.getIdIntegrante()%>"><%= i.getNome() %></a></h3></li>
						<%  }  %>
					</ul>	
				</fieldset>
						
				
				<h2>Deseja Excluir Algum Filme?</h2>
				<fieldset id="excluiFilmeIntegrante">
					<legend><strong>Filme(s)</strong></legend>
					<table border="2">
						<tr>
							<td>
								<strong>Nomes dos Filmes</strong>
							</td>
							<td>
								<strong>Excluir?</strong>
							</td>
						</tr>
						<% for(Filme f : filmes) { %>
							<tr><td>	
							<a id="link" href="detalhaFilme?idFilme=<%= f.getIdFilme() %>"><%= f.getNomeFilme() %></a></td>
							<td><form action="/CatalogoDeFilmes/excluiFilme"  method="post"><input type="hidden" name="idFilme" value="<%= f.getIdFilme() %>">
							<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Excluir"></form></td></tr>
						<%  }  %>
					</table> 
				 </fieldset>
				 
				 <h2>Deseja Excluir algum Integrante?</h2>
				<fieldset id="excluiFilmeIntegrante">
				<legend><strong>Integrante(s)</strong></legend>
					<table border="2">
						<tr>
							<td>
								<strong>Nomes dos Integrantes</strong>
							</td>
							<td>
								<strong>Excluir?</strong>
							</td>
						</tr>
						<% for(Integrante i : integrantes) { %>
							<tr><td>	
							<a id="link" href="detalhaIntegrante?idIntegrante=<%= i.getIdIntegrante()%>"><%= i.getNome() %></a></td>
							<td><form action="/CatalogoDeFilmes/excluiIntegrante" method="post"><input type="hidden" name="idIntegrante" value="<%= i.getIdIntegrante() %>">
							<input id="botaoLoginLogoutAdicionarExcluir" type="submit" value="Excluir"></form></td></tr>
						<%  }  %>
					</table> 
				</fieldset>
		 </div>
	</body>
</html>







