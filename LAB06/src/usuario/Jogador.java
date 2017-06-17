/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */

package usuario;

import jogo.Jogo;

public class Jogador {
	
	public static final double PRECO_DESCONTO = 1.0;
	
	// Construtor
	public Jogador() {
		
	}
	
	/**
	 * Metodo para obter a porcentagem do preco a ser pago.
	 * @return Retorna o multiplicador do preco ja com desconto.
	 */
	public double getDesconto() {
		return Jogador.PRECO_DESCONTO;
		
	}
	
	/**
	 * Metodo para obter o tipo do jogador.
	 * @return Retorna o tipo do jogador.
	 */
	public String getTipo() {
        return "";
         
    }
	
	/**
	 * Calcula o ganho de x2p do jogador.
	 * @param jogo Jogo a ser jogado.
	 * @return Retorna a quantidade de x2p a ser ganha.
	 */
	public int calculaReconpensa(Jogo jogo) {
        int recompenca = 0;
        return recompenca;
         
    }
	
	/**
	 * Calcula a perda de x2p do jogador.
	 * @param jogo Jogo a ser jogado.
	 * @return Retorna a quantidade de x2p a ser perdida.
	 */
	public int calculaPunicao(Jogo jogo) {
        int punicao = 0;
        return punicao;
         
    }
	
	/**
     * Reconpensa o jogador por jogar um jogo com base nos estilos do jogo.
     * @param nomeJogo Nome do jogo a ser jogado.
     * @param score Pontuacao atingida.
     * @param concluiu Indicador de se concluiu ou nao o jogo.
     * @throws Exception Lanaca exception para pontuacao negativa ou quando ela e 0 e o jogo
     * foi concluido.
     */
    public int ganhouPartida(Jogo jogo, int score, boolean concluiu) throws Exception {
    	int recompenca = calculaReconpensa(jogo);
    	int x2pJogar = jogo.joga(score, concluiu);
    	return x2pJogar + recompenca;
             
    }
     
    /**
     * Puni o jogador por jogar um jogo com base nos estilos do jogo.
     * @param nomeJogo Nome do jogo a ser jogado.
     * @param score Pontuacao atingida.
     * @param concluiu Indicador de se concluiu ou nao o jogo.
     * @throws Exception Lanaca exception para pontuacao negativa ou quando ela e 0 e o jogo
     * foi concluido.
     */
    public int perdeuPartida(Jogo jogo, int score, boolean concluiu) throws Exception {
    	int punicao = calculaPunicao(jogo);
    	int x2pJogar = jogo.joga(score, concluiu);
    	return x2pJogar - punicao;

    }
	
	

}
