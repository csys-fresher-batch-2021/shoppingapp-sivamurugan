package in.siva.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.siva.exception.DBException;
import in.siva.exception.UserInvalidException;
import in.siva.service.UserService;

/**
 * Servlet implementation class RemoveAccountServlet
 */
@WebServlet("/RemoveAccountServlet")
public class RemoveAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveAccountServlet() {
        super();
        
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			// To get input from user and to remove account
			String username = request.getParameter("username");
			UserService.removeAccount(username);
			
			// Information for user
			String infoMessage = "User Removed Successfully";
			response.sendRedirect("removeAccount.jsp?infoMessage=" + infoMessage);
		} catch(UserInvalidException | DBException e) {
			// Error message for user
			String errorMessage = e.getMessage();
			try {
				response.sendRedirect("removeAccount.jsp?errorMessage=" + errorMessage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
