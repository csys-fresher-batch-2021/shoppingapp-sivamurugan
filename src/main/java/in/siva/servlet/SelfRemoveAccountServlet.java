package in.siva.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.siva.exception.DBException;
import in.siva.service.UserService;

/**
 * Servlet implementation class SelfRemoveAccountServlet
 */
@WebServlet("/SelfRemoveAccountServlet")
public class SelfRemoveAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfRemoveAccountServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    	// To get logged in username
    	HttpSession session = request.getSession();
		String username = (String)session.getAttribute("LOGGED_IN_USER");		
		try {
			UserService.removeAccount(username);
			session.invalidate();
			response.sendRedirect("loginPage.jsp");
		} catch (DBException e) {
			try {
				response.sendRedirect("editProfile.jsp?errorMessage=" + e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
