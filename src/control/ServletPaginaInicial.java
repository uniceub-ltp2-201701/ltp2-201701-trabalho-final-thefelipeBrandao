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
import dao.ListaProfissoesDAO;
import dao.ListaTodosOsFilmesDAO;
import dao.ListaTodosOsGenerosDeFilmesDAO;
import model.Filme;
import model.Genero;
import model.Profissao;

/**
 * Servlet implementation class ServletPaginaInicial
 */
@WebServlet("/paginaInicial")
public class ServletPaginaInicial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaInicial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conexao = Conexao.getConexao();
					
			ListaTodosOsFilmesDAO ltofd = new ListaTodosOsFilmesDAO(conexao);		
			ArrayList<Filme> filmes = ltofd.getTodosOsFilmes();
			
			ListaTodosOsGenerosDeFilmesDAO ltgfd = new ListaTodosOsGenerosDeFilmesDAO(conexao);
			ArrayList<Genero> generos = ltgfd.getTodosOsGeneros();
			
			ListaProfissoesDAO lpd = new ListaProfissoesDAO(conexao);
			ArrayList<Profissao> profissoes = lpd.getTodosAsProfissoes();
			
			request.setAttribute("filmes", filmes);
			request.setAttribute("generos", generos);
			request.setAttribute("profissoes", profissoes);
			
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaInicial.jsp");
			rd.forward(request, response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
