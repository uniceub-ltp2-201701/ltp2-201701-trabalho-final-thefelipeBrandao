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
import dao.ListaFilmesDeUmAnoDAO;
import model.Filme;

/**
 * Servlet implementation class ServletListaFilmesDeUmAnoPaginaUsuario
 */
@WebServlet("/listaFilmesDeUmAnoPaginaUsuario")
public class ServletListaFilmesDeUmAnoPaginaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaFilmesDeUmAnoPaginaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anoFilme = request.getParameter("anoFilme");

		try {

			Connection conexao = Conexao.getConexao();
			
			ListaFilmesDeUmAnoDAO lfduad = new ListaFilmesDeUmAnoDAO(conexao);	
			ArrayList<Filme> filmes = lfduad.getFilmesDeUmAno(anoFilme);
			
			request.setAttribute("filmes", filmes);
			request.setAttribute("anoFilme", anoFilme);
			

			RequestDispatcher rd = request.getRequestDispatcher("/respostaListaFilmesDeUmAnoPaginaUsuario.jsp");
			rd.forward(request, response);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
