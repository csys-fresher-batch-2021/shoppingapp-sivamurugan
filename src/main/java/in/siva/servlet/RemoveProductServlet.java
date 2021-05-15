package in.siva.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.siva.exception.ProductInvalidException;
import in.siva.service.ProductService;

/**
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet("/RemoveProductServlet")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// To get product name from input box
			String productName = request.getParameter("productName");
			ProductService.removeProduct(productName);
			
			// Information for user
			String infoMessage = "Product Removed Successfully";
			response.sendRedirect("removeProduct.jsp?infoMessage=" + infoMessage);
		} catch(ProductInvalidException e) {
			
			// Error message for user
			String errorMessage = e.getMessage();
			response.sendRedirect("removeProduct.jsp?errorMessage=" + errorMessage);
		}
	}

}
