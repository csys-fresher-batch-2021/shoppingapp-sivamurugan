package in.siva.servlet;

import java.io.IOException;
import in.siva.exception.DBException;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			// To get information from user
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String role = UserService.loginValidation(username, password);
			String infoMessage = "Login Successful";
			
			// To store user details in session
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", username);
			session.setAttribute("ROLE", role);
			response.sendRedirect("index.jsp?infoMessage=" + infoMessage);
			
			
		} catch(InvalidLoginException | DBException e) {
			
			// To give error message to user
			String errorMessage = e.getMessage();
			try {
				response.sendRedirect("loginPage.jsp?errorMessage=" + errorMessage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
