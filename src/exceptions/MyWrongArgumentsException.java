package exceptions;

public class MyWrongArgumentsException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public MyWrongArgumentsException(String msg) {
		super(msg);
	}
}
