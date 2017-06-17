package exception;

public class ValorInvalidoException extends ErroEntradaException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor default que retorna a mensagem: Valor invalido! se essa excecao for lancada
	 */
	public ValorInvalidoException() {
		super("Valor invalido!");
	}
	
	/**
	 * Construtor que recebe uma mensagem e a retorna se essa excecao for lancada
	 * @param mensagem
	 */
	public ValorInvalidoException(String mensagem) {
		super(mensagem);
	}
	

}
