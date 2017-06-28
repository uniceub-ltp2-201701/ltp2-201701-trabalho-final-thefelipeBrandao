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
import dao.ListaTodosOsGenerosDeFilmesDAO;
import dao.ListaTodosOsIntegrantesDAO;
import dao.ListarGenerosDisponiveisDAO;
import dao.ListarIntegrantesDisponiveisDAO;
import dao.ListaProfissoesDAO;
import model.Filme;
import model.Genero;
import model.Integrante;
import model.Profissao;

/**
 * Servlet implementation class ServletDetalhaFilme
 */
@WebServlet("/detalhaFilme")
public class ServletDetalhaFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalhaFilme() {
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
			
			ListarGenerosDisponiveisDAO lgdd = new ListarGenerosDisponiveisDAO(conexao);
			ArrayList<Genero> todosOsGenerosDisponiveis = lgdd.getTodosOsGenerosDisponiveis(idFilme);
			
			ListaProfissoesDAO lpd = new ListaProfissoesDAO(conexao);
			ArrayList<Profissao> todasAsProfissoes = lpd.getTodosAsProfissoes();
			
			ListarIntegrantesDisponiveisDAO lidd = new ListarIntegrantesDisponiveisDAO(conexao);
			ArrayList<Integrante> todosOsIntegrantesDisponiveis = lidd.getTodosOsIntegrantesDisponiveis(idFilme);
			
			ListaTodosOsIntegrantesDAO ltid = new ListaTodosOsIntegrantesDAO(conexao);
			ArrayList<Integrante> todosOsIntegrantes= ltid.getTodosOsIntegrantes();
			
			ListaTodosOsGenerosDeFilmesDAO ltogdfd = new ListaTodosOsGenerosDeFilmesDAO(conexao);
			ArrayList<Genero> todosOsGeneros = ltogdfd.getTodosOsGeneros();
			
			request.setAttribute("filme", f);
			request.setAttribute("generosDoFilme", generosDoFilme);
			request.setAttribute("todasAsProfissoes", todasAsProfissoes);
			request.setAttribute("todosOsIntegrantesDisponiveis", todosOsIntegrantesDisponiveis);
			request.setAttribute("todosOsGenerosDisponiveis", todosOsGenerosDisponiveis);
			request.setAttribute("integrantesDoFilme", integrantesDoFilme);
			request.setAttribute("todosOsIntegrantes", todosOsIntegrantes);
			request.setAttribute("todosOsGeneros", todosOsGeneros);
			
			RequestDispatcher rd = request.getRequestDispatcher("respostaDetalhaFilme.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
