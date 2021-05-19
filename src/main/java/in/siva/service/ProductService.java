package in.siva.service;

import java.sql.SQLException;
import java.util.List;
import in.siva.dao.ProductDetailDao;
import in.siva.exception.DBException;
import in.siva.exception.ProductInvalidException;
import in.siva.model.ProductDetail;
import in.siva.validator.ProductValidator;
import in.siva.validator.UtilValidator;

public class ProductService {

	private ProductService() {
		// Default constructor
	}

	/**
	 * This method is used to check whether the product is repeated or not
	 * 
	 * @param productName
	 * @throws DBException 
	 */

	public static boolean isProductNotRepeated(String productName) throws DBException{
		boolean valid = true;
		List<ProductDetail> productDetails = ProductDetailDao.getProductDetails();
		for (ProductDetail product : productDetails) {
			if (product.getName().equalsIgnoreCase(productName)) {
				valid = false;
				break;
			}
		}
		return valid;
	}

	/**
	 * This method is used to add a product If name, price, quantity and category is
	 * valid then it will add product Otherwise it will raise a RuntimeException of
	 * "Invalid Product Details"
	 * 
	 * @param product
	 * @throws DBException 
	 */
	public static void addProduct(ProductDetail product) throws DBException{
		ProductDetail validProduct = setProductNameLowercase(product);
		// Business Logic
		if (UtilValidator.isStringValid(validProduct.getName()) && UtilValidator.isNumberValid(validProduct.getPrice())
				&& UtilValidator.isNumberValid(validProduct.getQuantity())
				&& UtilValidator.isStringValid(validProduct.getCategory())) {
			if (isProductNotRepeated(validProduct.getName())) {
				ProductDetailDao.addProduct(validProduct);
			} else {
				throw new ProductInvalidException("Product Already Exists");
			}

		} else {
			throw new ProductInvalidException("Invalid Product Details");
		}
	}

	/**
	 * This method is used to remove product details by product name
	 * 
	 * @param productName
	 * @throws DBException 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void removeProduct(String productName) throws DBException {
		// Business logic
		if (ProductValidator.isProductMatches(productName)) {
			ProductDetailDao.removeProduct(productName);
		} else {
			throw new ProductInvalidException("Invalid Product Name");
		}
	}

	/**
	 * This method is used to convert the product name into lower-case It will
	 * convert the product name to lower-case and will add it into object Then it
	 * will return the object
	 * 
	 * @param product
	 * @return
	 */
	public static ProductDetail setProductNameLowercase(ProductDetail product) {
		String name = product.getName();
		name = name.toLowerCase();
		product.setName(name);
		return product;
	}

}
