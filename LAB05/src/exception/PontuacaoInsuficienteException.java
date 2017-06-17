package exception;

public class PontuacaoInsuficienteException extends ErroLogicaException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor default que retorna a mensagem: Pontuacao insuficiente! se essa excecao for lancada
	 */
	public PontuacaoInsuficienteException() {
		super("Pontuacao insuficiente!");
	}
	
	/**
	 * Construtor que recebe uma mensagem e a retorna se essa excecao for lancada
	 * @param mensagem
	 */
	public PontuacaoInsuficienteException(String mensagem) {
		super(mensagem);
	}
	

}
