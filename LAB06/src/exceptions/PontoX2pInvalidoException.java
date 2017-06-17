/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */

package exceptions;

public class PontoX2pInvalidoException extends ErroLogicaException {

	public PontoX2pInvalidoException() {
		super("Pontos de x2p insuficientes.");
		
	}
	
	public PontoX2pInvalidoException(String string) {
		super(string);
		
	}
	private static final long serialVersionUID = 1L;

}
