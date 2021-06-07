package in.siva.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.siva.exception.DBException;
import in.siva.exception.NoDiscountFoundException;
import in.siva.model.BillDetail;
import in.siva.model.DiscountDetail;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// To get logged in username & billDetails
		try {
			String username = (String) session.getAttribute("LOGGED_IN_USER");
			String deliveryDate = request.getParameter("date");
			String address = request.getParameter("address");
			String paymentMethod = request.getParameter("paymentMethod");
			String parameter = request.getParameter("finalBill");
			float totalBillDouble = Float.parseFloat(parameter);
			int totalBill = Math.round(totalBillDouble);

			// To store purchase details
			List<BillDetail> billDetails = (List<BillDetail>) session.getAttribute("billDetails");
			SalesService.storeOrderDetails(username, billDetails, totalBill, paymentMethod, deliveryDate, address);
			
			// To set status as used in discount details after discount is used by customer
			List<DiscountDetail> coupons =SalesService.getCoupons(username);
			int index = Integer.parseInt(request.getParameter("index"));
			DiscountDetail discountDetail = coupons.get(index);
			long discountId = discountDetail.getDiscountId();
			SalesService.changeStatus(discountId, "USED");
			
			response.sendRedirect("OrderConfirmedPage.jsp");
		} catch (DBException e) {
			try {
				response.sendRedirect("SelectVegetables.jsp?errorMessage=" + e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException | NoDiscountFoundException | NumberFormatException e) {
			try {
				response.sendRedirect("OrderConfirmedPage.jsp");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
