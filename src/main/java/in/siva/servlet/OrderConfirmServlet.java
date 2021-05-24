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

import in.siva.dao.BillDetailsDAO;
import in.siva.exception.DBException;
import in.siva.model.BillDetail;
import in.siva.service.SalesService;

/**
 * Servlet implementation class FinalDecisionServlet
 */
@WebServlet("/OrderConfirmServlet")
public class OrderConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderConfirmServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("LOGGED_IN_USER");
		List<BillDetail> billDetails = (List<BillDetail>)session.getAttribute("billDetails");
		try {
			SalesService.storeSalesDetails(username, billDetails);
			response.sendRedirect("OrderConfirmedPage.jsp");
		} catch (DBException e) {
			response.sendRedirect("SelectProducts.jsp?errorMessage=" + e.getMessage());
		}
		
		
	}

}
