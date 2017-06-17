package exception;

public class UsuarioInvalidoException extends ErroLogicaException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor default que retorna a mensagem: Usuario invalido! se essa excecao for lancada
	 */
	public UsuarioInvalidoException() {
		super("Usuario invalido");
	}
	
	/**
	 * Construtor que recebe uma mensagem e a retorna se essa excecao for lancada
	 * @param mensagem
	 */
	public UsuarioInvalidoException(String mensagem) {
		super(mensagem); 
	}
	

}
