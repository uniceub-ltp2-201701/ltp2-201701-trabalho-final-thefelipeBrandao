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
import dao.DetalhaFilmeDAO;
import model.Filme;
import model.Genero;
import model.Integrante;

/**
 * Servlet implementation class ServletDetalhaFilmePaginaUsuario
 */
@WebServlet("/detalhaFilmePaginaUsuario")
public class ServletDetalhaFilmePaginaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDetalhaFilmePaginaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idFilme = request.getParameter("idFilme");

		try {
			Connection conexao = Conexao.getConexao();

			DetalhaFilmeDAO dfd = new DetalhaFilmeDAO(conexao);
			//Informacoes do filme
			Filme f = dfd.getFilme(idFilme);
			ArrayList<Genero> generosDoFilme = dfd.getGenerosDoFilme(idFilme);
			ArrayList<Integrante>integrantesDoFilme = dfd.getIntegrantesDofilme(idFilme);


			request.setAttribute("filme", f);
			request.setAttribute("generosDoFilme", generosDoFilme);
			request.setAttribute("integrantesDoFilme", integrantesDoFilme);

			RequestDispatcher rd = request.getRequestDispatcher("respostaDetalhaFilmePaginaUsuario.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
