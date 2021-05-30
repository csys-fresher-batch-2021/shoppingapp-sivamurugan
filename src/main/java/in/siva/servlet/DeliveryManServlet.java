package in.siva.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.siva.exception.DBException;
import in.siva.model.OrderDetail;
import in.siva.service.SalesService;

/**
 * Servlet implementation class OrderDeliveryServlet
 */
@WebServlet("/DeliveryManServlet")
public class DeliveryManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<OrderDetail> orderDetailsForDelivery = SalesService.getCurrentDeliveryOrders();
			request.setAttribute("orderDetailsForDelivery", orderDetailsForDelivery);
			RequestDispatcher dis = request.getRequestDispatcher("DeliveryDetails.jsp");
			dis.forward(request, response);

		} catch (DBException | IOException e) {
			e.printStackTrace();
		}
	}

}
