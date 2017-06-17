/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
package exceptions;

public class EntradaInvalidaException extends Exception {

	public EntradaInvalidaException() {
		super("Entrada Invalida.");
		
	}
	
	public EntradaInvalidaException(String string) {
		super(string);
		
	}
	
	private static final long serialVersionUID = 1L;

}
