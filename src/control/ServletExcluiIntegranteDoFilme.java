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
import dao.DetalhaFilmeDAO;
import dao.ExcluiIntegranteDeUmFilmeDAO;
import model.Filme;

/**
 * Servlet implementation class ServletExcluiIntegranteDoFilme
 */
@WebServlet("/excluiIntegranteDoFilme")
public class ServletExcluiIntegranteDoFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletExcluiIntegranteDoFilme() {
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

			ExcluiIntegranteDeUmFilmeDAO eidfd = new ExcluiIntegranteDeUmFilmeDAO(conexao);
			DetalhaFilmeDAO dfd = new DetalhaFilmeDAO(conexao);
			Filme filme = dfd.getFilme(idFilme);

			boolean resultado = eidfd.excluirIntegranteDeUmFilme(idFilme, idIntegrante, idProfissao);

			if (resultado) {
				request.setAttribute("idFilme", idFilme);
				RequestDispatcher rd = request.getRequestDispatcher("/detalhaFilme");
				rd.forward(request, response);
			} else {
				request.setAttribute("filme", filme);
				RequestDispatcher rd = request.getRequestDispatcher("/respostaExcluiIntegranteDoFilmeErro.jsp");
				rd.forward(request, response);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
