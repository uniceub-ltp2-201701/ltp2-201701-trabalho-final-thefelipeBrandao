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
import dao.ListaIntegrantesDeUmGeneroDAO;
import model.Integrante;

/**
 * Servlet implementation class ServletListaIntegrantesDeUmGeneroPaginaUsuario
 */
@WebServlet("/listaIntegrantesDeUmGeneroPaginaUsuario")
public class ServletListaIntegrantesDeUmGeneroPaginaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaIntegrantesDeUmGeneroPaginaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String genero = request.getParameter("genero");
		String generoNome = request.getParameter("generoNome");
		
		
		try {
			
			Connection conexao = Conexao.getConexao();
			
			
			ListaIntegrantesDeUmGeneroDAO lidugd = new ListaIntegrantesDeUmGeneroDAO(conexao);
			
			ArrayList<Integrante> integrantes = lidugd.getIntegrantesDeUmGenero(genero);
			
	
			request.setAttribute("integrantes", integrantes);
			request.setAttribute("genero", genero);
			request.setAttribute("generoNome", generoNome);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("respostaListaIntegrantesDeUmGeneroPaginaUsuario.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
