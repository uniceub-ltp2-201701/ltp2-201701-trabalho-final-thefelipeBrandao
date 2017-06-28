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
import dao.DetalhaIntegranteDAO;
import model.Filme;
import model.Integrante;
import model.Profissao;

/**
 * Servlet implementation class ServletDetalhaIntegrantePaginaUsuario
 */
@WebServlet("/detalhaIntegrantePaginaUsuario")
public class ServletDetalhaIntegrantePaginaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalhaIntegrantePaginaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String idIntegrante = request.getParameter("idIntegrante");
		
		try {
			
			Connection conexao = Conexao.getConexao();
			
			DetalhaIntegranteDAO did = new DetalhaIntegranteDAO(conexao);
			Integrante integrante = did.getIntegrante(idIntegrante);
			ArrayList<Profissao> profissoes = did.getProfissoesDoIntegrante(idIntegrante);
			ArrayList<Filme> filmes = did.getFilmesDoIntegrante(idIntegrante);
			
			request.setAttribute("filmes", filmes);
			request.setAttribute("integrante", integrante);
			request.setAttribute("profissoes", profissoes);
			
			RequestDispatcher rd = request.getRequestDispatcher("respostaDetalhaIntegrantePaginaUsuario.jsp");
			rd.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
