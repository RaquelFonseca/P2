package p2cg;

import java.util.HashSet;

/**
 * 
 * @author Raquel Fonseca
 *
 */

public class Plataforma extends Jogo {
	
	
	/**
	 * Construtor da subclasse Plataforma
	 * @param nome: nome do jogo do tipo plataforma
	 * @param preco: preco do jogo do tipo plataforma
	 * @param estilos: estilos do jogo do tipo plataforma
	 */
	public Plataforma(String nome, double preco, HashSet<EstiloDoJogo> estilos) {
		super(nome, preco, estilos);
		
	}
	
	
	/**
	 * Retorna Plataforma como tipo do jogo 
	 */
	@Override
	public String getTipo() {
		return "Plataforma";
	}
	
	
	/**
	 * Retorna 20 pontos se zerou
	 */
	@Override
	public int joga(int pontuacaoAtingida, boolean zerar) {
		super.joga(pontuacaoAtingida, zerar);
		if (zerar){
			return 20;
		}
		else {
			return 0;
		}
	}
}
