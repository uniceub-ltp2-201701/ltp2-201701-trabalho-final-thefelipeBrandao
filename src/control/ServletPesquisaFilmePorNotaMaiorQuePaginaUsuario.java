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
import dao.ListaFilmesPorNotaDAO;
import model.Filme;

/**
 * Servlet implementation class ServletPesquisaFilmePorNotaMaiorQuePaginaUsuario
 */
@WebServlet("/pesquisaFilmePorNotaMaiorQuePaginaUsuario")
public class ServletPesquisaFilmePorNotaMaiorQuePaginaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPesquisaFilmePorNotaMaiorQuePaginaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nota = request.getParameter("nota");

		try {

			Connection conexao = Conexao.getConexao();

			ListaFilmesPorNotaDAO lfpnd = new ListaFilmesPorNotaDAO(conexao);
			ArrayList<Filme> filmes = lfpnd.getFilmesPorNotaMaiorQue(nota);

			request.setAttribute("nota", nota);
			request.setAttribute("filmes", filmes);

			RequestDispatcher rd = request.getRequestDispatcher("/respostaPesquisaFilmePorMaiorQueNotaPaginaUsuario.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
