package nology.io.testereclipse.common.exceptions;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidationError {

	private HashMap<String, ArrayList<String>> errors;

	public ValidationError() {
		this.errors = new HashMap<>();
	}

	public ValidationError(String field, String reason) {
		this();
		this.addError(field, reason);
	}

	public void addError(String field, String reason) {
		if (this.errors.containsKey(field)) {
			errors.get(field).add(reason);
		} else {
			ArrayList<String> newList = new ArrayList<>();
			newList.add(reason);
			errors.put(field, newList);
		}
	}

	public boolean isEmpty() {
		return this.errors.isEmpty();
	}

	public HashMap<String, ArrayList<String>> getErrors() {
		return errors;
	}

}
