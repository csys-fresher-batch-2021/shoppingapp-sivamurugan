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
import in.siva.exception.InvalidSelectionException;
import in.siva.model.BillDetail;
import in.siva.service.SalesService;

/**
 * Servlet implementation class SelectProductsServlet
 */
@WebServlet("/SelectVegetablesServlet")
public class SelectVegetablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
    	// To get values from jsp page
		String[] quantityValues = request.getParameterValues("quantity");
		String[] selectedVegetables = request.getParameterValues("select");
		try {
			// To get billDetails and total bill from service
			List<BillDetail> billDetails = SalesService.getBill(selectedVegetables, quantityValues);
			Double totalBill = SalesService.getTotalBill(billDetails);
			
			HttpSession session = request.getSession();
			// To store billDetails & total bill
			session.setAttribute("billDetails", billDetails);
			request.setAttribute("billDetails", billDetails);
			request.setAttribute("totalBill", totalBill);
			
	        RequestDispatcher dis = request.getRequestDispatcher("BillPage.jsp");
 	        dis.forward(request, response);
			
		} catch (DBException | InvalidSelectionException | ServletException | IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			String errorMessage = "Sorry You haven't selected any vegetables..! Select atleast one product to continue";
			try {
				response.sendRedirect("SelectVegetables.jsp?errorMessage=" + errorMessage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
