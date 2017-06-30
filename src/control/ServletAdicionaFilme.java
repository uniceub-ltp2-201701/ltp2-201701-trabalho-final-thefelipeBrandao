package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionaFilmeDAO;
import dao.Conexao;

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
