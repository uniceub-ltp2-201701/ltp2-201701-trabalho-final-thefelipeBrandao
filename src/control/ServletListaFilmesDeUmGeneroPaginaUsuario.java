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
import dao.ListaFilmesDeUmGeneroDAO;
import model.Filme;
import model.Genero;

/**
 * Servlet implementation class ServletListaFilmesDeUmGeneroPaginaUsuario
 */
@WebServlet("/listaFilmesDeUmGeneroPaginaUsuario")
public class ServletListaFilmesDeUmGeneroPaginaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaFilmesDeUmGeneroPaginaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idGenero = request.getParameter("idGenero");
		String idFilme = request.getParameter("idFilme");
		
		try {
			
			Connection conexao = Conexao.getConexao();
			
			ListaFilmesDeUmGeneroDAO lfgd = new ListaFilmesDeUmGeneroDAO(conexao);
			Genero genero = lfgd.getGenero(idGenero);
			//pegando filmes de um genero
			ArrayList<Filme> filmes = lfgd.getFilmesDeUmGenero(idGenero);
			//pegando o filme(para ter o nome dele no link)
			DetalhaFilmeDAO dfd = new DetalhaFilmeDAO(conexao);
			Filme filme = dfd.getFilme(idFilme);
			
			
			request.setAttribute("filme", filme);
			request.setAttribute("genero", genero);
			request.setAttribute("filmes", filmes);
			
			RequestDispatcher rd = request.getRequestDispatcher("respostaListaFilmesDeUmGeneroPaginaUsuario.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
