/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */

package usuario;

import jogo.Jogo;
import classes.Estilo;

public class JogadorNoob extends Jogador {
	
	public static final double PRECO_DESCONTO = 0.9;

	// Construtor
	public JogadorNoob() {
		
	}
	
	@Override
	public double getDesconto() {
		return JogadorNoob.PRECO_DESCONTO;
		
	}
	
	@Override
	public String getTipo() {
        return "Noob";
         
    }
	
	@Override
	public int calculaReconpensa(Jogo jogo) {
        int recompenca = 0;
        for (Estilo estilo: jogo.getEstilos()) {
            switch (estilo) {
            case OFFLINE:
                recompenca += 30;
                break;
 
            case MULTIPLAYER:
                recompenca += 10;
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
            case ONLINE:
                punicao += 10;
                break;
 
            case COMPETITIVO:
                punicao += 20;
                break;
             
            case COOPERATIVO:
                punicao += 50;
                break;
                 
            default:
                break;
                 
            }
        }
        return punicao;
         
    }
}
