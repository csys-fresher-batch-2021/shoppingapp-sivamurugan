package in.siva.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.siva.exception.DBException;
import in.siva.exception.UserInvalidException;
import in.siva.model.OrderDetail;
import in.siva.service.SalesService;

/**
 * Servlet implementation class MyOrdersServlet
 */
@WebServlet("/MyOrdersServlet")
public class MyOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("LOGGED_IN_USER");
		try {
			List<OrderDetail> myOrders = SalesService.getMyOrders(username);
			request.setAttribute("myOrders", myOrders);
			RequestDispatcher dis = request.getRequestDispatcher("MyOrders.jsp");
			dis.forward(request, response);
		} catch (DBException | UserInvalidException |IOException e) {
			try {
				response.sendRedirect("index.jsp?errorMessage=" + e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
