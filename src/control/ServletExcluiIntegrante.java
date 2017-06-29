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
import dao.ExcluiIntegranteDAO;

/**
 * Servlet implementation class ServletExcluiIntegrante
 */
@WebServlet("/excluiIntegrante")
public class ServletExcluiIntegrante extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletExcluiIntegrante() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idIntegrante = request.getParameter("idIntegrante");

		try {

			Connection conexao = Conexao.getConexao();

			ExcluiIntegranteDAO eid = new ExcluiIntegranteDAO(conexao);

			boolean resultadoTabelaRelacionamento = eid.excluirIntegranteTabelaRelacao(idIntegrante);
			boolean resultadoTabelaIntegrante = eid.excluirIntegrante(idIntegrante);
			
			if (resultadoTabelaRelacionamento || resultadoTabelaIntegrante) {
				RequestDispatcher rd = request.getRequestDispatcher("/admin");
				rd.forward(request, response);	
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/respostaErroAoExcluirIntegrante.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
