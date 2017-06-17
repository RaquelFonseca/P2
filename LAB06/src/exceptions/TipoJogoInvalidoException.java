/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
package exceptions;

public class TipoJogoInvalidoException extends ErroLogicaException {
	
	private static final long serialVersionUID = 1L;

	public TipoJogoInvalidoException() {
		super("Tipo de jogo invalido.");
		
	}
	
	public TipoJogoInvalidoException(String string) {
		super(string);
		
	}

}
