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
import dao.ExcluiGeneroDeUmFilmeDAO;
import model.Filme;

/**
 * Servlet implementation class ServletExcluiGeneroDoFilme
 */
@WebServlet("/excluiGeneroDoFilme")
public class ServletExcluiGeneroDoFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletExcluiGeneroDoFilme() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idGenero = request.getParameter("idGenero");
		String idFilme = request.getParameter("idFilme");


		try {
			Connection conexao = Conexao.getConexao();
			
			ExcluiGeneroDeUmFilmeDAO egdufd = new ExcluiGeneroDeUmFilmeDAO(conexao);
			
			boolean resultado = egdufd.excluirGeneroDeUmFilme(idFilme, idGenero);
			
			DetalhaFilmeDAO dfd = new DetalhaFilmeDAO(conexao);
			Filme filme = dfd.getFilme(idFilme);
			if (resultado) {
				request.setAttribute("idFilme", idFilme);
				RequestDispatcher rd = request.getRequestDispatcher("/detalhaFilme");
				rd.forward(request, response);
			} else {
				request.setAttribute("idFilme", idFilme);
				request.setAttribute("filme", filme);
				
				RequestDispatcher rd = request.getRequestDispatcher("/respostaExcluiGeneroDoFilmeErro.jsp");
				rd.forward(request, response);
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
