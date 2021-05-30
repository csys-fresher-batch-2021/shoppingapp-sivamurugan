package in.siva.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import in.siva.service.SalesService;

/**
 * Servlet implementation class DeliveredServlet
 */
@WebServlet("/DeliveredServlet")
public class DeliveredServlet extends HttpServlet {
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
			//  Get Form Values
			Long orderId = Long.parseLong(request.getParameter("orderId"));
			isUpdated = SalesService.setStatusAsDelivered(orderId);
			PrintWriter out = response.getWriter();
			JsonObject object = new JsonObject();
			object.addProperty("result", isUpdated);
			out.println(object);
			out.flush();
			// success

		} catch (Exception e) {
			e.printStackTrace();
			try {
				PrintWriter out = response.getWriter();
				JsonObject object = new JsonObject();
				object.addProperty("result", isUpdated);
				out.println(object);
				out.flush();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}

		
	}
}
