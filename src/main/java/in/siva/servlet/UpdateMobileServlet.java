package in.siva.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.siva.exception.DBException;
import in.siva.exception.UserRepeatedException;
import in.siva.service.UserService;

/**
 * Servlet implementation class UpdateMobileServlet
 */
@WebServlet("/UpdateMobileServlet")
public class UpdateMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMobileServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			// To get mobile number from user
			long mobileNumber = Long.parseLong(request.getParameter("newMobileNumber"));
			
			// To get logged in username
			HttpSession session = request.getSession();
			String username = (String)session.getAttribute("LOGGED_IN_USER");
			
			UserService.updateMobileNumber(mobileNumber, username);
			String infoMessage = "Mobile Number Updated Successfully";
			response.sendRedirect("editProfile.jsp?infoMessage=" + infoMessage);
			
		} catch(DBException | UserRepeatedException e){
			try {
				response.sendRedirect("editProfile.jsp?errorMessage=" + e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
