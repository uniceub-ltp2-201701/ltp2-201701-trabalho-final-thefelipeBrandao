package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionaFilmeGeneroDAO;
import dao.Conexao;

/**
 * Servlet implementation class ServletAdicionaFilmeGenero
 */
@WebServlet("/adicionaFilmeGenero")
public class ServletAdicionaFilmeGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdicionaFilmeGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idFilme = request.getParameter("idFilme");
		String idGenero = request.getParameter("idGenero");
		
		try {
			
			Connection conexao = Conexao.getConexao();
			
			AdicionaFilmeGeneroDAO afgd = new AdicionaFilmeGeneroDAO(conexao);
			boolean resultado = afgd.adicionarFilmeGenero(idFilme, idGenero);
			
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
