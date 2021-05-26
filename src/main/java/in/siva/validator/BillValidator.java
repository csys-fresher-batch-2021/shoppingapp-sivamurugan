package in.siva.validator;

import java.util.List;

import in.siva.exception.EmptyBillException;
import in.siva.model.BillDetail;

public class BillValidator {
	private BillValidator() {
		// TO avoid object creation in other class
	}
	
	/**
	 * If bill details is empty it will throw Invalid Bill exception
	 * @param billDetails
	 * @throws Exception
	 */
	public static void isBillValid(List<BillDetail> billDetails) throws EmptyBillException {
		if(billDetails.isEmpty()) {
			throw new EmptyBillException();
		}
	}
}
