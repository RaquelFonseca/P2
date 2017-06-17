/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */

package exceptions;

public class NomeInvalidoException extends EntradaInvalidaException {

	public NomeInvalidoException() {
		super("Nome Invalido.");
		
	}
	
	public NomeInvalidoException(String string) {
		super(string);
		
	}

	private static final long serialVersionUID = 1L;

	
	
}
