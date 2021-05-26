package in.siva.service;

import java.sql.SQLException;
import java.util.List;

import in.siva.dao.VegDetailDao;
import in.siva.exception.DBException;
import in.siva.exception.VegInvalidException;
import in.siva.model.VegDetail;
import in.siva.validator.VegetableValidator;
import in.siva.validator.UtilValidator;

public class VegetableService {

	private VegetableService() {
		// Default constructor
	}

	/**
	 * This method is used to add a product If name, price, quantity and category is
	 * valid then it will add product Otherwise it will raise a RuntimeException of
	 * "Invalid Product Details"
	 * 
	 * @param vegetable
	 * @throws DBException 
	 */
	public static void addVeg(VegDetail vegetable) throws DBException{
		VegDetail validVeg = setVegNameLowercase(vegetable);
		// Business Logic
		if (UtilValidator.isStringValid(validVeg.getName()) && UtilValidator.isNumberValid(validVeg.getPrice())
				&& UtilValidator.isNumberValid(validVeg.getQuantity())) {
			if (VegetableValidator.isVegNotRepeated(validVeg.getName())) {
				VegDetailDao.saveVeg(validVeg);
			} else {
				throw new VegInvalidException("Product Already Exists");
			}

		} else {
			throw new VegInvalidException("Invalid Product Details");
		}
	}

	/**
	 * This method is used to remove product details by product name
	 * 
	 * @param vegName
	 * @throws DBException 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void removeVeg(String vegName) throws DBException {
		// Business logic
		if (VegetableValidator.isVegMatches(vegName)) {
			VegDetailDao.deleteVegByName(vegName);
		} else {
			throw new VegInvalidException("Invalid Product Name");
		}
	}

	/**
	 * This method is used to convert the product name into lower-case It will
	 * convert the product name to lower-case and will add it into object Then it
	 * will return the object
	 * 
	 * @param vegetable
	 * @return
	 */
	public static VegDetail setVegNameLowercase(VegDetail vegetable) {
		String name = vegetable.getName();
		name = name.toLowerCase();
		vegetable.setName(name);
		return vegetable;
	}
	
	public static List<VegDetail> getVegDetails() throws DBException {
		return VegDetailDao.findAll();
	}

}
