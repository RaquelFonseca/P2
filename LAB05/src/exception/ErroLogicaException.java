package exception;

public class ErroLogicaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor default que retorna a mensagem: Erro de logica! se essa excecao fo lancada
	 */
	public ErroLogicaException() {
		super("Erro de logica!");
	}
	
	/**
	 * Construtor que recebe uma mensagem e a retorna se essa excecao for lancada
	 * @param mensagem
	 */
	public ErroLogicaException(String mensagem) {
		super(mensagem);
	}
	

}
