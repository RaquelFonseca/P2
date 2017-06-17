/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
package classes;

import java.util.HashSet;
import exceptions.EntradaInvalidaException;
import exceptions.ErroLogicaException;

public class Facade {

	private Controller controller;
	
	// Contrutor
	public Facade() {
		controller = new Controller();
		
	}
	
	/**
	 * Adiciona dinheiro a um usuario da lista.
	 * @param login Login do usuario que ira receber o dinheiro.
	 * @param valor Valor a ser adicionado nu usuario.
	 * @return Retorna true ou false dependendo de se foi ou nao possivel adicionar o
	 * dinheiro ao usuario especificado.
	 */
	public boolean adicionaDinheiroUsuario(String login, double valor) {
		return controller.adicionaDinheiroUsuario(login, valor);
		
	}
	
	/**
	 * Cria o jogo e adiciona ao usuario caso ele tenha dinheiro para isso, se tem,
	 * a arrecadacao da loja e atualizada.
	 * @param login Login do usuario que recebera o jogo.
	 * @param nome Nome do jogo.
	 * @param preco Preco do jogo.
	 * @param estilos Conjunto de estilos do jogo.
	 * @param tipo Tipo do jogo.
	 * @return retorna true ou false indicando se foi possivel ou nao adicionar o jogo.
	 * @throws Exception Lanca exception em caso de ma construcao do jogo.
	 */
	public boolean adicionaJogoUsuario(String login, String nome, double preco, HashSet<Estilo> estilos, String tipo) {
		try {
			return controller.adicionaJogoUsuario(login, nome, preco, estilos, tipo);
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			
		} catch (ErroLogicaException e) {
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return false;
		
	}
	
	/**
	 * Cria um usuario de um tipo e adiciona a loja.
	 * @param nome Nome do usuario.
	 * @param login Login do usuario.
	 * @throws Exception Lanca exception em caso de ma construcao do usuario.
	 */
	public void criaUsuario(String nome, String login) {
		try {
			controller.criaUsuario(nome, login);
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getLocalizedMessage());
			
		}
	}
	
	/**
	 * Organiza os usuarios e pega os 5 usuarios com mais X2p.
	 * @return Retorna uma String com os primeiros 5 usuarios com mais X2p.
	 */
	public String getTop5() {
		return controller.getTop5();
		
	}
	
	/**
	 * Recompensa o usuario com pontos x2p por jogar um jogo com base no estilo do jogo.
	 * @param login Login do usuario.
	 * @param nomeJogo Nome do jogo.
	 * @param score Pontuacao obtida.
	 * @param concluiu Indicador de se concluiu ou nao o jogo.
	 * @throws Exception Lanca exception se a pontuacao for negativa ou igual 0 e concluiu for true.
	 */
	public void usuarioGanhouPartida(String login, String nomeJogo, int score, boolean concluiu) {
		try {
			controller.usuarioGanhouPartida(login, nomeJogo, score, concluiu);
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			
		} catch (ErroLogicaException e) {
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	/**
	 * Puni o usuario com pontos x2p por jogar um jogo com base no estilo do jogo.
	 * @param login Login do usuario.
	 * @param nomeJogo Nome do jogo.
	 * @param score Pontuacao obtida.
	 * @param concluiu Indicador de se concluiu ou nao o jogo.
	 * @throws Exception Lanca exception se a pontuacao for negativa ou igual 0 e concluiu for true.
	 */
	public void usuarioPerdeuPartida(String login, String nomeJogo, int score, boolean concluiu) {
		try {
			controller.usuarioPerdeuPartida(login, nomeJogo, score, concluiu);
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			
		} catch (ErroLogicaException e) {
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	
}
