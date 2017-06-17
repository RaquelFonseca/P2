package p2cg;

import java.util.HashSet;

/**
 * 
 * @author Raquel Fonseca
 *
 */

public class Luta extends Jogo {
	
	
	/**
	 * Construtor da subclasse Luta
	 * @param nome: nome do jogo do tipo luta
	 * @param preco: preco do jogo do tipo luta
	 * @param estilos: estilos do jogo do tipo luta
	 */
	public Luta(String nome, double preco, HashSet<EstiloDoJogo> estilos) {
		super(nome, preco, estilos);
		
	}

	
	/**
	 * Retorna Luta como tipo do jogo 
	 */
	@Override
	public String getTipo() {
		return "Luta";
	}
	
	
	/**
	 * Retorna 1 ponto se a pontuacao atingida for 100
	 */
	@Override
	public int joga(int pontuacaoAtingida, boolean zerar) {
		super.joga(pontuacaoAtingida, zerar);
		if (pontuacaoAtingida % 1000 == 0){
			return 1;
		}
		else {
			return 0;
		}	 
	}
}
