package exception;

public class StringInvalidaException extends ErroEntradaException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor default que retorna a mensagem: String invalida! 
	 */
	public StringInvalidaException() {
		super("String invalida!");
	}
	
	/**
	 * Construtor que recebe uma mensagem e a retorna se for lancada essa excecao
	 * @param mensagem 
	 */
	public StringInvalidaException(String mensagem) {
		super(mensagem);
	}
	
	
	
	
	
	
}
