package exception;

public class LoadFileException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoadFileException() {
		this("N�o foi posss�vel carregar o arquivo.");
	}

	public LoadFileException(String msg) {
		super(msg);
	}
}