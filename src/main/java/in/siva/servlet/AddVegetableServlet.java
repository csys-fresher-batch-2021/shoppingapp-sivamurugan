package in.siva.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.siva.exception.DBException;
import in.siva.exception.VegInvalidException;
import in.siva.model.VegDetail;
import in.siva.service.VegetableService;

/**
 * Servlet implementation class AddProductsServlet
 */
@WebServlet("/AddVegetableServlet")
public class AddVegetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddVegetableServlet() {
		super();
	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		// To add products to DB
		try {
			// To get values from input box
			String vegName = request.getParameter("vegName");
			Integer vegPrice = Integer.parseInt(request.getParameter("vegPrice"));
			Integer vegQuantity = Integer.parseInt(request.getParameter("vegQuantity"));

			VegDetail product1 = new VegDetail(vegName, vegPrice, vegQuantity);

			VegetableService.addVeg(product1);

			String infoMessage = "Vegetable Added Successfully";
			response.sendRedirect("addVegetable.jsp?infoMessage=" + infoMessage);

		}

		// Exception message if product details didn't met requirements
		catch (VegInvalidException | DBException | NumberFormatException e) {
			String errorMessage = e.getMessage();
			try {
				response.sendRedirect("addVegetable.jsp?errorMessage=" + errorMessage);
			} catch (IOException e1) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
