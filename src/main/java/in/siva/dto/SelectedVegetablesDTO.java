//package in.siva.dto;
//
//import in.siva.dao.SelectedVegetablesDao;
//import in.siva.model.SelectedVegetables;
//import in.siva.validator.VegetableValidator;
//
//public class SelectedVegetablesDTO {
//	private SelectedVegetablesDTO() {
//
//	}
//
//	public static SelectedVegetables convertToObject(String vegetableName, String quantity) {
//		SelectedVegetables vegetable = new SelectedVegetables();
//		int enteredQuantity = Integer.parseInt(quantity);
//		if (enteredQuantity != 0) {
//			vegetable.setName(vegetableName);
//			vegetable.setQuantity(enteredQuantity);
//		} else {
//			throw new NullPointerException("You haven't selected any Vegetables..!");
//		}
//		return vegetable;
//	}
//}
