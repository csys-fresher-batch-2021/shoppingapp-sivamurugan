package in.siva.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.siva.exception.DBException;
import in.siva.model.VegDetail;
import in.siva.service.VegetableService;

/**
 * Servlet implementation class EstimateBillServlet
 */
@WebServlet("/GetVegDetailsServlet")
public class GetVegDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// To convert provided list into JSON Object
		Gson gsonObj = new Gson();
		JsonObject object = new JsonObject();
		try {			
			List<VegDetail> vegDetails = VegetableService.getVegDetails();
			String jsonVegDetails = gsonObj.toJson(vegDetails);			
			PrintWriter out = response.getWriter();
			out.println(jsonVegDetails);
			out.flush();
		} catch (DBException | IOException e) {
			object.addProperty("errorMessage", e.getMessage());
		}
	}

}
