package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionaIntegranteDAO;
import dao.Conexao;

/**
 * Servlet implementation class ServletAdicionaIntegrante
 */
@WebServlet("/adicionaIntegrante")
public class ServletAdicionaIntegrante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionaIntegrante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeIntegrante = request.getParameter("nomeIntegrante");
		String generoIntegrante = request.getParameter("generoIntegrante");
		String bioIntegrante = request.getParameter("bioIntegrante");
		String nascimentoIntegrante = request.getParameter("nascimento");
		String urlImagemIntegrante = request.getParameter("urlImagemIntegrante");
		
		try {
			
			Connection conexao = Conexao.getConexao();
			
			AdicionaIntegranteDAO aid = new AdicionaIntegranteDAO(conexao);
			
			boolean resultado = aid.adicionarIntegrante(nomeIntegrante, generoIntegrante, bioIntegrante, nascimentoIntegrante,urlImagemIntegrante);
			
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
