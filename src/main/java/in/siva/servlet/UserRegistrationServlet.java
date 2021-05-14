package in.siva.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.siva.constants.Constants;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
			UserDetail user = new UserDetail(name, age, gender, mobileNumber, email, username, password, role);
			UserService.addUser(user);
			
			//System.out.println(user);   (Used to check whether user details stored are not)
			
			// Redirect to login page after registration
			response.sendRedirect("loginPage.jsp");
		}
		catch(UserInvalidException e) {
			
			// Invalid product message if details entered were wrong
			String errorMessage = e.getMessage();
			response.sendRedirect(Constants.newUserErrorMessage + errorMessage);
		}
		
		catch(UserRepeatedException e) {
			
			// User repeated message if mobile number, user name or email repeated
			String errorMessage = e.getMessage();
			response.sendRedirect(Constants.newUserErrorMessage + errorMessage);
		}
		
		catch(NumberFormatException e) {
			
			// Number format exception for mobile number if mobile number is entered wrong
			String errorMessage = "Invalid mobile number";
			response.sendRedirect(Constants.newUserErrorMessage + errorMessage);
		}
	}

}
