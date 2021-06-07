package in.siva.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.siva.exception.DBException;
import in.siva.exception.UserInvalidException;
import in.siva.exception.UserRepeatedException;
import in.siva.model.UserDetail;
import in.siva.service.UserService;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistrationServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {

			// To get Values from user input
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			long mobileNumber = Long.parseLong(request.getParameter("mobileNumber"));
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String role = request.getParameter("role");

			// To add user details in ArrayList
			UserDetail user = new UserDetail();
			user.setAge(age);
			user.setEmail(email);
			user.setGender(gender);
			user.setMobileNumber(mobileNumber);
			user.setName(name);
			user.setPassword(password);
			user.setRole(role);
			user.setUsername(username);
			UserService.addUser(user);
			// System.out.println(user); (Used to check whether user details stored are not)

			// Redirect to login page after registration
			String infoMessage = "Account Created Successfully";
			response.sendRedirect("loginPage.jsp?infoMessage=" + infoMessage);
		} catch (UserInvalidException | UserRepeatedException | DBException | NumberFormatException e) {

			// Invalid product message if details entered were wrong
			String errorMessage = e.getMessage();
			try {
				response.sendRedirect("newUserRegistration.jsp?errorMessage=" + errorMessage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
