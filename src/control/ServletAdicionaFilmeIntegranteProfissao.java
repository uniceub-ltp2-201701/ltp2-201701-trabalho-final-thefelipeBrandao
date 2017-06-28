package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionaFilmeGeneroIntegranteProfissaoDAO;
import dao.Conexao;

/**
 * Servlet implementation class ServletAdicionaFilmeIntegranteProfissao
 */
@WebServlet("/adicionaFilmeIntegranteProfissao")
public class ServletAdicionaFilmeIntegranteProfissao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionaFilmeIntegranteProfissao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idIntegrante = request.getParameter("idIntegrante");
		String idProfissao = request.getParameter("idProfissao");
		String idFilme = request.getParameter("idFilme");
		
		try {
			Connection conexao = Conexao.getConexao();
			
			AdicionaFilmeGeneroIntegranteProfissaoDAO afgip = new AdicionaFilmeGeneroIntegranteProfissaoDAO(conexao);
			
			boolean resultado = afgip.adicionaFilmeIntegranteProfissao(idFilme,idIntegrante, idProfissao);
			if (resultado) {
				request.setAttribute("idFilme", idFilme);
				RequestDispatcher rd = request.getRequestDispatcher("/detalhaFilme");
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
