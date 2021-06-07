package in.siva.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import in.siva.exception.DBException;
import in.siva.exception.NoDiscountFoundException;
import in.siva.model.DiscountDetail;
import in.siva.service.DiscountService;

/**
 * Servlet implementation class GetCouponServlet
 */
@WebServlet("/GetCouponServlet")
public class GetCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("LOGGED_IN_USER");
		List<DiscountDetail> coupons;
		try {
			coupons = DiscountService.getCoupons(username);
			PrintWriter out = response.getWriter();

			Gson json = new Gson();
			String couponStr = json.toJson(coupons);
			out.println(couponStr);
			out.flush();
		} catch (DBException | NoDiscountFoundException e) {
			coupons = null;
			Gson json = new Gson();
			String couponStr = json.toJson(coupons);
			
			try {
				PrintWriter out = response.getWriter();
				
				out.println(couponStr);
				out.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
