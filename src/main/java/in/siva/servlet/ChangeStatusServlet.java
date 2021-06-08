package in.siva.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import in.siva.constants.Constants;
import in.siva.service.SalesService;

/**
 * Servlet implementation class ReOrderServlet
 */
@WebServlet("/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isUpdated = false;
		try {
			PrintWriter out = response.getWriter();
			JsonObject object = new JsonObject();
			HttpSession session = request.getSession();
			String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
			if (loggedInUsername != null) {
				Long orderId = Long.parseLong(request.getParameter("orderId"));
				String status = request.getParameter("status");
				isUpdated = SalesService.setStatus(orderId, status);
				object.addProperty(Constants.RESULT, isUpdated);
			}
			out.println(object);
			out.flush();
		} 
		catch (Exception e) {
			e.printStackTrace();
			try {
				PrintWriter out = response.getWriter();
				JsonObject object = new JsonObject();
				object.addProperty(Constants.RESULT, isUpdated);
				out.println(object);
				out.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
