package in.siva.validator;

import java.util.List;

import in.siva.exception.InvalidBillException;
import in.siva.model.BillDetail;

public class BillValidator {
	private BillValidator() {
		// TO avoid object creation in other class
	}
	
	public static void isBillValid(List<BillDetail> billDetails) throws Exception {
		if(billDetails.isEmpty()) {
			throw new InvalidBillException();
		}
	}
}
