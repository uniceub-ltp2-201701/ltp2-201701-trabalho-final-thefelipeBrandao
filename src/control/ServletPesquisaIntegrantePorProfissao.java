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
import dao.DetalhaProfissaoDAO;
import dao.ListaIntegrantesDeUmaProfissaoDAO;
import model.Integrante;
import model.Profissao;

/**
 * Servlet implementation class ServletPesquisaIntegrantePorProfissao
 */
@WebServlet("/pesquisaIntegrantePorProfissao")
public class ServletPesquisaIntegrantePorProfissao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPesquisaIntegrantePorProfissao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProfissao = request.getParameter("idProfissao");
		
		try {
			
			Connection conexao = Conexao.getConexao();
			
			ListaIntegrantesDeUmaProfissaoDAO lip = new ListaIntegrantesDeUmaProfissaoDAO(conexao);
			ArrayList<Integrante> integrantes = lip.getIntegrantes(idProfissao);
			
			DetalhaProfissaoDAO dpd = new DetalhaProfissaoDAO(conexao);
			Profissao profissao = dpd.getProfissao(idProfissao);
			
			request.setAttribute("profissao", profissao);
			request.setAttribute("integrantes", integrantes);
			
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPesquisaIntegrantePorProfissao.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
