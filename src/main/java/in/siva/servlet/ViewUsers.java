package in.siva.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.siva.exception.DBException;
import in.siva.model.UserDetail;
import in.siva.service.UserService;

/**
 * Servlet implementation class ViewUsers
 */
@WebServlet("/ViewUsers")
public class ViewUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		Gson users = new Gson();
		JsonObject object = new JsonObject();
		try {
			PrintWriter out = response.getWriter();
			List<UserDetail> userList = UserService.getAllUsers();
			String jsonUsers = users.toJson(userList);
			
			out.println(jsonUsers);
			
		
		} catch (DBException | IOException e) {
			object.addProperty("errorMessage", e.getMessage());
		}
		
	}

}
