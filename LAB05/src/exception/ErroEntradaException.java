package exception;

public class ErroEntradaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor default que retorna a mensagem: Entrada invalida! se essa excecao for lancada
	 */
	public ErroEntradaException() {
		super("Entrada invalida!");
	}
	
	/**
	 * Construtor que recebe uma mensagem e a retorna se essa excecao for lancada
	 * @param mensagem
	 */
	public ErroEntradaException(String mensagem) {
		super(mensagem);
	}

}
