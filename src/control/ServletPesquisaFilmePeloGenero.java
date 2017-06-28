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
import dao.ListaFilmesDeUmGeneroDAO;
import model.Filme;
import model.Genero;

/**
 * Servlet implementation class ServletPesquisaFilmePeloGenero
 */
@WebServlet("/pesquisaFilmePeloGenero")
public class ServletPesquisaFilmePeloGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPesquisaFilmePeloGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idGenero = request.getParameter("idGenero");
		
		try {
			
			Connection conexao = Conexao.getConexao();
			
			ListaFilmesDeUmGeneroDAO lfg = new ListaFilmesDeUmGeneroDAO(conexao);
			Genero genero = lfg.getGenero(idGenero);
			ArrayList<Filme> filmes = lfg.getFilmesDeUmGenero(idGenero);
			
			
			request.setAttribute("genero", genero);
			request.setAttribute("filmes", filmes);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("respostaPesquisaFilmePeloGenero.jsp");
			rd.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
