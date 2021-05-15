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
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// To get information from user
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			String infoMessage = UserService.loginValidation(username, password, role);
			
			// To store user details in session
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", username);
			session.setAttribute("ROLE", role);
			response.sendRedirect("ListProducts.jsp?infoMessage=" + infoMessage);
			
			
		} catch(InvalidLoginException e) {
			
			// To give error message to user
			String errorMessage = e.getMessage();
			response.sendRedirect("loginPage.jsp?errorMessage=" + errorMessage);
		}
	}

}
