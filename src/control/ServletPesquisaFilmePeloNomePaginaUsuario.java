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
import dao.ListaFilmesPorNomeDAO;
import model.Filme;

/**
 * Servlet implementation class ServletPesquisaFilmePeloNomePaginaUsuario
 */
@WebServlet("/pesquisaFilmePeloNomePaginaUsuario")
public class ServletPesquisaFilmePeloNomePaginaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPesquisaFilmePeloNomePaginaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String nomeFilme = request.getParameter("nomeFilme");
		
		try {
			
			Connection conexao = Conexao.getConexao();
			
			ListaFilmesPorNomeDAO pfd = new ListaFilmesPorNomeDAO(conexao);
			ArrayList<Filme> filmes = pfd.getFilmes(nomeFilme);
			
			request.setAttribute("nomeFilme", nomeFilme);
			request.setAttribute("filmes", filmes);
			
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPesquisaFilmePeloNomePaginaUsuario.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
