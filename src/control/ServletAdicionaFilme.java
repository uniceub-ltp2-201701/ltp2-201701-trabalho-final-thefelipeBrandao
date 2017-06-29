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

import dao.AdicionaFilmeDAO;
import dao.Conexao;
import dao.DetalhaFilmeDAO;
import dao.ListaTodosOsGenerosDeFilmesDAO;
import dao.ListaTodosOsIntegrantesDAO;
import dao.ListaProfissoesDAO;
import dao.PegarUltimoFilmeDAO;
import model.Filme;
import model.Genero;
import model.Integrante;
import model.Profissao;

/**
 * Servlet implementation class ServletAdicionaFilme
 */
@WebServlet("/adicionaFilme")
public class ServletAdicionaFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionaFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeFilme = request.getParameter("nomeFilme");
		String ano = request.getParameter("anoFilme");
		String dataLancamento = request.getParameter("dataLancamentoFilme");
		String duracao = request.getParameter("duracaoFilme");
		String sinopse = request.getParameter("sinopseFilme");
		String avaliacao = request.getParameter("avaliacaoFilme");
		String classificacao = request.getParameter("classificacaoFilme");
		String urlImagemFilme = request.getParameter("urlImagemFilme");
		
		try {
			Connection conexao  = Conexao.getConexao();
			
			AdicionaFilmeDAO afd = new AdicionaFilmeDAO(conexao);
			boolean resultado = afd.adicionarFilme(nomeFilme, ano, dataLancamento, duracao, sinopse, avaliacao, classificacao,urlImagemFilme);
			if (resultado) {
				//pegando o ID do ultimo filme no BD
				PegarUltimoFilmeDAO pufd = new PegarUltimoFilmeDAO(conexao);
				String idFilme = pufd.getIDultimoFilme();
				//Pegando o filme e os seus generos
				DetalhaFilmeDAO dfd = new DetalhaFilmeDAO(conexao);
				Filme f = dfd.getFilme(idFilme);
				ArrayList<Genero> generosDoFilme = dfd.getGenerosDoFilme(idFilme);
				//Pegando todos os generos
				ListaTodosOsGenerosDeFilmesDAO lgf = new ListaTodosOsGenerosDeFilmesDAO(conexao);
				ArrayList<Genero> generos = lgf.getTodosOsGeneros();
				//pegando todos os integrantes
				ListaTodosOsIntegrantesDAO lid = new ListaTodosOsIntegrantesDAO(conexao);
				ArrayList<Integrante> integrantes = lid.getTodosOsIntegrantes();
				//peganda todas as profissoes
				ListaProfissoesDAO lpd = new ListaProfissoesDAO(conexao);
				ArrayList<Profissao> profissoes = lpd.getTodosAsProfissoes();
				
				request.setAttribute("filme", f);
				request.setAttribute("generos", generos);
				request.setAttribute("generosDoFilme", generosDoFilme);
				request.setAttribute("integrantes", integrantes);
				request.setAttribute("profissoes", profissoes);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/admin");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/respostaAdicionaFilmeErro.jsp");
				rd.forward(request, response);
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
