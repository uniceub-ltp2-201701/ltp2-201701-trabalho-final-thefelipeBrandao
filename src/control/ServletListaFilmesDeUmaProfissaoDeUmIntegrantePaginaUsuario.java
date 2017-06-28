package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.DetalhaIntegranteDAO;
import dao.DetalhaProfissaoDAO;
import dao.ListaFilmesDeUmaProfissaoDeUmIntegranteDAO;
import model.Filme;
import model.Integrante;
import model.Profissao;

/**
 * Servlet implementation class ServletListaFilmesDeUmaProfissaoDeUmIntegrantePaginaUsuario
 */
@WebServlet("/listaFilmesDeUmaProfissaoDeUmIntegrantePaginaUsuario")
public class ServletListaFilmesDeUmaProfissaoDeUmIntegrantePaginaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaFilmesDeUmaProfissaoDeUmIntegrantePaginaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProfissao = request.getParameter("idProfissao");
		String idIntegrante = request.getParameter("idIntegrante");
		
		try {
			
			Connection conexao = Conexao.getConexao();
			
			ListaFilmesDeUmaProfissaoDeUmIntegranteDAO lfpid = new ListaFilmesDeUmaProfissaoDeUmIntegranteDAO(conexao);
			
			ArrayList<Filme> filmes = lfpid.getListaDeFilmes(idIntegrante, idProfissao);
			
			//pegar o nome da profissao
			DetalhaProfissaoDAO dpd = new DetalhaProfissaoDAO(conexao);
			Profissao p = dpd.getProfissao(idProfissao);
			//pegando o integrante
			DetalhaIntegranteDAO did = new DetalhaIntegranteDAO(conexao);
			Integrante i = did.getIntegrante(idIntegrante);
			
			request.setAttribute("filmes", filmes);
			request.setAttribute("profissao", p);
			request.setAttribute("integrante", i);
			
			RequestDispatcher rd = request.getRequestDispatcher("/respostaListaFilmesDeUmaProfissaoDeUmIntegrantePaginaUsuario.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
