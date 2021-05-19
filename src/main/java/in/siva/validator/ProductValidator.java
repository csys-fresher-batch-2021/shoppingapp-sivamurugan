package in.siva.validator;


import java.util.List;
import in.siva.dao.ProductDetailDao;
import in.siva.exception.DBException;
import in.siva.model.ProductDetail;

public class ProductValidator {

	private ProductValidator() {
		// Default constructor
	}
	
	/**
	 * This method is used to check whether the product is matches with db product name or not
	 * @param productName
	 * @return
	 * @throws DBException 
	 */
	public static boolean isProductMatches(String productName) throws DBException {
		List<ProductDetail> productDetails = ProductDetailDao.getProductDetails();
		boolean exists = false;
		productName = productName.toLowerCase();
		for (ProductDetail product : productDetails) {
			if(product.getName().equalsIgnoreCase(productName)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
}
