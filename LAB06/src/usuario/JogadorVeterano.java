/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */

package usuario;

import jogo.Jogo;
import classes.Estilo;

public class JogadorVeterano extends Jogador {
	
	public static final double PRECO_DESCONTO = 0.8;
	
	// Construtor
	public JogadorVeterano() {
		
	}
	
	@Override
	public double getDesconto() {
		return JogadorVeterano.PRECO_DESCONTO;
		
	}
	
	@Override
	public String getTipo() {
        return "Veterano";
         
    }
	
	@Override
	public int calculaReconpensa(Jogo jogo) {
		int recompenca = 0;
		for (Estilo estilo: jogo.getEstilos()) {
			switch (estilo) {
			case ONLINE:
				recompenca += 10;
				break;

			case COOPERATIVO:
				recompenca += 20;
				break;
			default:
				break;
				
			}
		}
		return recompenca;
		
	}
	
	@Override
	public int calculaPunicao(Jogo jogo) {
		int punicao = 0;
		for (Estilo estilo: jogo.getEstilos()) {
			switch (estilo) {
			case COMPETITIVO:
				punicao += 20;
				break;
			
			case COOPERATIVO:
				punicao += 20;
				break;
				
			default:
				break;
				
			}
		}
		return punicao;
		
	}

}
