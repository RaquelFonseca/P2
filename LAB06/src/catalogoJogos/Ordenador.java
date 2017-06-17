/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
package catalogoJogos;

import java.util.List;
import jogo.Jogo;

public abstract class Ordenador {

	/**
	 * Ordena a lista recebida com base no Nome do Jogo.
	 * @param list Lista de jogos a ser ordenada.
	 */
	public abstract void ordenaDefault(List<Jogo> list);
	
	/**
	 * Ordena a lista recebida com base na Quantidade de veses jogadas do Jogo.
	 * @param list Lista de jogos a ser ordenada.
	 */
	public abstract void ordenaVicio(List<Jogo> list);
	
	/**
	 * Ordena a lista recebida com base na Maior pontuacao obtida do Jogo.
	 * @param list Lista de jogos a ser ordenada.
	 */
	public abstract void ordenaDesempenho(List<Jogo> list);
	
	/**
	 * Ordena a lista recebida com base na Quantidade de veses de conclusoes do Jogo.
	 * @param list Lista de jogos a ser ordenada.
	 */
	public abstract void ordenaExperiencia(List<Jogo> list);
	
}
