package in.siva.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.siva.exception.ProductInvalidException;
import in.siva.model.ProductDetail;
import in.siva.service.ProductServiceManagement;

/**
 * Servlet implementation class AddProductsServlet
 */
@WebServlet("/AddProductsServlet")
public class AddProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductsServlet() {
        super();
        // TODO 
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// To get values from input box
		String productName = request.getParameter("productName");
		Integer productPrice = Integer.parseInt(request.getParameter("productPrice"));
		Integer productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
		String productCategory = request.getParameter("category");

		ProductDetail product1 = new ProductDetail(productName, productPrice, productQuantity, productCategory);
			
		// To add products to ArrayList
			try {
				ProductServiceManagement.addProduct(product1);
				System.out.println(product1.getProductcategory());
				String infoMessage = "Product Added Successfully";
				response.sendRedirect("addproducts.jsp?infoMessage=" + infoMessage);
				//out.println(infoMessage);
				
				
			}

		// Exception message if product details didn't met requirements
			catch(ProductInvalidException e) {
				String errorMessage = e.getMessage();
				response.sendRedirect("addproducts.jsp?errorMessage=" + errorMessage);
				//out.println(errorMessage);
				
			}
			
	}

}
