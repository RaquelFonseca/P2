package p2cg;

import java.util.HashSet;

/**
 * 
 * @author Raquel Fonseca
 *
 */

public class RPG extends Jogo {
	
	
	/**
	 * Construtor da subclasse RPG
	 * @param nome: nome do jogo do tipo RPG
	 * @param preco: preco do jogo do tipo RPG
	 * @param estilos: estilos do jogo do tipo RPG
	 */
	public RPG(String nome, double preco, HashSet<EstiloDoJogo> estilos) {
		super(nome, preco, estilos);
		}
	
	
	/**
	 * Retorna RPG como o tipo do jogo
	 */
	@Override
	public String getTipo() {
		return "RPG";
	}
	
	
	/**
	 * retotna 10 a cada quantidade de jogadas
	 */
	@Override
	public int joga(int pontuacaoAtingida, boolean zerar) {
		super.joga(pontuacaoAtingida, zerar);
		if (super.getQuantidadeJogadas() % 1 == 0){
			return 10;
		}
		else {
			return 0;
		}
	}
}
