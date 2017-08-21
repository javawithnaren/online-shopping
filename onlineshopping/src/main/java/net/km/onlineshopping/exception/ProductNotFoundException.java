package net.km.onlineshopping.exception;

public class ProductNotFoundException extends Exception {

	/**
	 * Default seraialId
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException(){
		this("Product is unavailable");
	}

	public ProductNotFoundException(String message) {
		this.message=System.currentTimeMillis()+": "+message;
	}

	public String getMessage() {
		return message;
	}

}
