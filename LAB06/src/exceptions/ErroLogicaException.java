/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
package exceptions;

public class ErroLogicaException extends Exception {

	public ErroLogicaException() {
		super("Erro de Logica.");
		
	}
	
	public ErroLogicaException(String string) {
		super(string);
		
	}
	
	private static final long serialVersionUID = 1L;

	

}
