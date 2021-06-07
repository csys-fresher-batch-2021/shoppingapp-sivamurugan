package in.siva.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.siva.exception.DBException;
import in.siva.model.OrderDetail;
import in.siva.service.SalesService;

/**
 * Servlet implementation class SalesDetailsServlet
 */
@WebServlet("/SalesDetailsServlet")
public class SalesDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OrderDetail> orderDetails;
		try {
			orderDetails = SalesService.getAllOrderDetails();
			Gson jsonObj = new Gson();
			String orderDetailsStr = jsonObj.toJson(orderDetails);
			PrintWriter out = response.getWriter();
			out.println(orderDetailsStr);
			out.flush(); 
		} catch (DBException | IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
