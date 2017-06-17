/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */

package exceptions;

public class TipoUsuarioInvalidoException extends ErroLogicaException {

	public TipoUsuarioInvalidoException() {
		super("Tipo de usuario invalido.");
		
	}
	
	public TipoUsuarioInvalidoException(String string) {
		super(string);
		
	}

	private static final long serialVersionUID = 1L;
	
}
