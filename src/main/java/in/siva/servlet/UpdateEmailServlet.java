package in.siva.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.siva.exception.DBException;
import in.siva.exception.UserInvalidException;
import in.siva.exception.UserRepeatedException;
import in.siva.service.UserService;

/**
 * Servlet implementation class UpdateEmailServlet
 */
@WebServlet("/UpdateEmailServlet")
public class UpdateEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateEmailServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// To get mobile number from user
		String newEmail = request.getParameter("newEmail");
		newEmail = newEmail.toLowerCase();

		// To get logged in username
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("LOGGED_IN_USER");

		try {

			UserService.updateEmail(newEmail, username);
			String infoMessage = "Email Address Updated Successfully";
			response.sendRedirect("editProfile.jsp?infoMessage=" + infoMessage);

		} catch (DBException | UserRepeatedException | UserInvalidException e) {
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
