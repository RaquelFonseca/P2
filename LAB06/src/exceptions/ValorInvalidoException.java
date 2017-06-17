/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */

package exceptions;

public class ValorInvalidoException extends EntradaInvalidaException {

	public ValorInvalidoException() {
		super("Valor invalido.");
		
	}
	
	public ValorInvalidoException(String string) {
		super(string);
		
	}

	private static final long serialVersionUID = 1L;

}
