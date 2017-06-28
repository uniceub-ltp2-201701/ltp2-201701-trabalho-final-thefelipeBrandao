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
import dao.LoginDAO;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeUsuario = request.getParameter("nome");
		String senhaUsuario = request.getParameter("senha");
		
		try {
			
			Connection conexao = Conexao.getConexao();
			
			LoginDAO ld = new LoginDAO(conexao);
			
			boolean login = ld.testeLogin(nomeUsuario, senhaUsuario);
			
			if (login) {
				RequestDispatcher rd = request.getRequestDispatcher("/admin");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/respostaLoginIncorreto.jsp");
				rd.forward(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
