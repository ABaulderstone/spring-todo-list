package nology.io.testereclipse.common.exceptions;

public class ServiceValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	private ValidationError errors;

	public ServiceValidationException(ValidationError errors) {
		super();
		this.errors = errors;
	}

	public ValidationError getErrors() {
		return this.errors;
	}

}
