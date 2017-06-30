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
import dao.ListaIntegrantesPorNomeDAO;
import model.Integrante;

/**
 * Servlet implementation class ServletPesquisaIntegrantePeloNome
 */
@WebServlet("/pesquisaIntegrantePeloNome")
public class ServletPesquisaIntegrantePeloNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPesquisaIntegrantePeloNome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeIntegrante = request.getParameter("nomeIntegrante");

		try {

			Connection conexao = Conexao.getConexao();

			ListaIntegrantesPorNomeDAO lipnd = new ListaIntegrantesPorNomeDAO(conexao);
			ArrayList<Integrante> integrantes = lipnd.getIntegrantes(nomeIntegrante);

			request.setAttribute("nomeIntegrante", nomeIntegrante);
			request.setAttribute("integrantes", integrantes);

			RequestDispatcher rd = request.getRequestDispatcher("/respostaPesquisaIntegrantePeloNome.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
