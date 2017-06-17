
package p2cg;

import java.util.HashSet;

/**
 * 
 * @author Raquel Fonseca
 *
 */

public abstract class Jogo {

	private String nome;
	private double preco;
	private int maxPontuacao;
	protected int quantidadeJogadas;
	private int zerou;
	protected HashSet<EstiloDoJogo> estilos;

	
	/**
	 * Construtor da superclasse abstrata Jogo
	 * @param nome: nome do jogo
	 * @param preco: preco do jogo
	 * @param estilos: estilos do jogo
	 */
	public Jogo(String nome, double preco, HashSet<EstiloDoJogo> estilos) {
		this.nome = nome;
		this.preco = preco;
		this.maxPontuacao = 0;
		this.quantidadeJogadas = 0;
		this.zerou = 0;
		this.estilos = new HashSet<EstiloDoJogo>();
	}

	
	/**
	 * Retorna o nome do jogo
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	
	/**
	 * Retorna o preco do jogo 
	 * @return preco
	 */
	public double getPreco() {
		return preco;
	}

	
	/**
	 * Retorna a maxima pontuacao atingida no jogo
	 * @return maxPontuacao
	 */
	public int getMaxPontuacao() {
		return maxPontuacao;
	}

	
	/**
	 * Seta a maxima pontuacao atingida no jogo
	 * @param maxPontuacao
	 */
	public void setMaxPontuacao(int maxPontuacao) {
		this.maxPontuacao = maxPontuacao;
	}

	
	/**
	 * Retorna a quantidade de jogadas
	 * @return quantidadeJogadas
	 */
	public int getQuantidadeJogadas() {
		return quantidadeJogadas;
	}

	
	/**
	 * Seta a quantidade de jogadas
	 * @param quantidadeJogadas
	 */
	public void setQuantidadeJogadas(int quantidadeJogadas) {
		this.quantidadeJogadas = quantidadeJogadas;
	}

	
	/**
	 * retorna quantidades de vezes que zerou o jogo
	 * @return zerou
	 */
	public int getZerou() {
		return zerou;
	}
	
	
	/**
	 * Seta quantidades de vezes que zerou o jogo
	 * @param zerou
	 */
	public void setZerou(int zerou) {
		this.zerou = zerou;
	}

	
	/**
	 * Retorna os estilos do jogo
	 * @return estilos
	 */
	public HashSet<EstiloDoJogo> getEstilos() {
		return estilos;
	}
	
	/**
	 * Retorna o tipo de jogo
	 * @return tipo
	 */
	public String getTipo() {
		return "";
	}

	
	/**
	 * Atualiza pontuacao maxima e quantidade de jogadas
	 * @param pontuacaoAtingida
	 * @param zerou
	 * @return
	 */
	public int joga(int pontuacaoAtingida, boolean zerou) {
		this.quantidadeJogadas = this.quantidadeJogadas + 1;
		if (pontuacaoAtingida > maxPontuacao) {
			this.maxPontuacao = pontuacaoAtingida;
		}
		if (zerou) {
			this.zerou = this.zerou + 1;
		}
		return 0;
	}

	
	/**
	 * Retorna o jogo com os seus atributos como string
	 */
	@Override
	public String toString() {
		final String eol = System.getProperty("line.separator");
		String retorno = "+ " + nome + " - " + getTipo() + ":" + eol
				+ "==> Jogou " + quantidadeJogadas + " vez(es)" + eol + "==> Zerou "
				+ zerou + " vez(es)" + eol + "==> Maior score: " + maxPontuacao;
		return retorno;
	}
}
