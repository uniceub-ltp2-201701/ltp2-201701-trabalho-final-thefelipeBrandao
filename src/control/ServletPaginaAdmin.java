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
import dao.ListaTodosOsIntegrantesDAO;
import dao.ListaProfissoesDAO;
import dao.ListaTodosOsFilmesDAO;
import dao.ListaTodosOsGenerosDeFilmesDAO;
import model.Filme;
import model.Genero;
import model.Integrante;
import model.Profissao;

/**
 * Servlet implementation class ServletPaginaAdmin
 */
@WebServlet("/admin")
public class ServletPaginaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conexao  = Conexao.getConexao();
			
			ListaTodosOsIntegrantesDAO lid = new ListaTodosOsIntegrantesDAO(conexao);
			ArrayList<Integrante> integrantes = lid.getTodosOsIntegrantes();
			
			ListaTodosOsGenerosDeFilmesDAO ltgfd = new ListaTodosOsGenerosDeFilmesDAO(conexao);
			ArrayList<Genero> generos = ltgfd.getTodosOsGeneros();
			
			ListaTodosOsFilmesDAO ltfd = new ListaTodosOsFilmesDAO(conexao);
			ArrayList<Filme> filmes =  ltfd.getTodosOsFilmes();
			
			ListaProfissoesDAO lpd = new ListaProfissoesDAO(conexao);
			ArrayList<Profissao> profissoes = lpd.getTodosAsProfissoes();
			
			request.setAttribute("profissoes", profissoes);
			request.setAttribute("generos", generos);
			request.setAttribute("filmes", filmes);
			request.setAttribute("integrantes", integrantes);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/respostaLoginAdmin.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
