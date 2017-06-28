package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ExcluiFilmeDAO;

/**
 * Servlet implementation class ServletExcluiFilme
 */
@WebServlet("/excluiFilme")
public class ServletExcluiFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluiFilme() {
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
			
			ExcluiFilmeDAO efd = new ExcluiFilmeDAO(conexao);
			
			boolean resultadoTabelaRelacionamento = efd.excluirFilmeGeneroIntegranteProfissao(idFilme);
			boolean resultadoTabelaFilme = efd.excluirFilme(idFilme);
			
			if (resultadoTabelaRelacionamento || resultadoTabelaFilme) {
					RequestDispatcher rd = request.getRequestDispatcher("/admin");
					rd.forward(request, response);	
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/respostaErroAoExcluirFilme.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
