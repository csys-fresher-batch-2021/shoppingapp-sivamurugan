package in.siva.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.siva.exception.DBException;
import in.siva.exception.VegInvalidException;
import in.siva.service.VegetableService;

/**
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet("/RemoveVegetableServlet")
public class RemoveVegetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveVegetableServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			// To get product name from input box
			String productName = request.getParameter("vegName");
			productName= productName.toLowerCase();
			VegetableService.removeVeg(productName);
			
			// Information for user
			String infoMessage = "Vegetable Removed Successfully";
			response.sendRedirect("removeVegetable.jsp?infoMessage=" + infoMessage);
		} catch(VegInvalidException | DBException e) {
			
			// Error message for user
			String errorMessage = e.getMessage();
			try {
				response.sendRedirect("removeVegetable.jsp?errorMessage=" + errorMessage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
