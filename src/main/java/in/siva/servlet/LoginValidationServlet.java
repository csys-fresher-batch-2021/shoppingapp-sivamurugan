package in.siva.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.siva.exception.InvalidLoginException;
import in.siva.service.UserService;

/**
 * Servlet implementation class LoginValidationServlet
 */
@WebServlet("/LoginValidationServlet")
public class LoginValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
<<<<<<< HEAD
=======
    @Override
>>>>>>> 5e0491d445a6d22ad4315f3db51cb6d6486afab1
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			String infoMessage = UserService.loginValidation(username, password, role);
			
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", username);
			session.setAttribute("ROLE", role);
			response.sendRedirect("ListProducts.jsp?infoMessage=" + infoMessage);
			
			
		} catch(InvalidLoginException e) {
			String errorMessage = e.getMessage();
			response.sendRedirect("loginPage.jsp?errorMessage=" + errorMessage);
		}
	}

}
