package in.siva.validator;


import java.util.List;
import in.siva.dao.VegDetailDAO;
import in.siva.exception.DBException;
import in.siva.model.VegDetail;

public class VegetableValidator {

	private VegetableValidator() {
		// Default constructor
	}
	
	/**
	 * This method is used to check whether the product is matches with db product name or not
	 * @param vegName
	 * @return
	 * @throws DBException 
	 */
	public static boolean isVegMatches(String vegName) throws DBException {
		List<VegDetail> productDetails = VegDetailDAO.findAll();
		boolean exists = false;
		vegName = vegName.toLowerCase();
		for (VegDetail product : productDetails) {
			if(product.getName().equalsIgnoreCase(vegName)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	/**
	 * This method is used to check whether the product is repeated or not
	 * 
	 * @param vegName
	 * @throws DBException 
	 */

	public static boolean isVegNotRepeated(String vegName) throws DBException{
		boolean valid = true;
		List<VegDetail> vegDetails = VegDetailDAO.findAll();
		for (VegDetail product : vegDetails) {
			if (product.getName().equalsIgnoreCase(vegName)) {
				valid = false;
				break;
			}
		}
		return valid;
	}
}
