package in.siva.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.siva.exception.DBException;
import in.siva.exception.ProductInvalidException;
import in.siva.model.ProductDetail;
import in.siva.service.ProductService;

/**
 * Servlet implementation class AddProductsServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductServlet() {
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
			String productName = request.getParameter("productName");
			Integer productPrice = Integer.parseInt(request.getParameter("productPrice"));
			Integer productQuantity = Integer.parseInt(request.getParameter("productQuantity"));

			ProductDetail product1 = new ProductDetail(productName, productPrice, productQuantity);

			ProductService.addProduct(product1);

			String infoMessage = "Product Added Successfully";
			response.sendRedirect("addproducts.jsp?infoMessage=" + infoMessage);

		}

		// Exception message if product details didn't met requirements
		catch (ProductInvalidException | DBException | NumberFormatException e) {
			String errorMessage = e.getMessage();
			try {
				response.sendRedirect("addproducts.jsp?errorMessage=" + errorMessage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
