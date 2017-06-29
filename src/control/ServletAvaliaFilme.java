package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AvaliaFilmeDAO;
import dao.Conexao;
import dao.DetalhaFilmeDAO;
import model.Filme;

/**
 * Servlet implementation class ServletAvaliaFilme
 */
@WebServlet("/avaliaFilme")
public class ServletAvaliaFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAvaliaFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nota = request.getParameter("nota");
		String idFilme = request.getParameter("idFilme");
	
		try {
			
			Connection conexao = Conexao.getConexao();
				
			AvaliaFilmeDAO afd = new AvaliaFilmeDAO(conexao);
			
			boolean resultado = afd.avaliarFilme(idFilme, nota);
			Filme filme = new DetalhaFilmeDAO(conexao).getFilme(idFilme);
			if (resultado) {
				
				request.setAttribute("idFilme", idFilme);
				RequestDispatcher rd = request.getRequestDispatcher("/detalhaFilmePaginaUsuario");
				rd.forward(request, response);
			} else {
				request.setAttribute("filme", filme);
				RequestDispatcher rd = request.getRequestDispatcher("/respostaAvaliaFilmeErro.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
