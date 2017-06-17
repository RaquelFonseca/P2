/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
package classes;

import java.util.HashSet;
import exceptions.EntradaInvalidaException;
import usuario.Usuario;
import jogo.Jogo;

public class Controller {
	
	public static final int PONTUACAO_META = 1000;
	private JogoFactory fabricaDeJogos;
	private Loja loja;
	
	// Construtor
	public Controller() {
		fabricaDeJogos = new JogoFactory();
		loja = new Loja();
		
	}
	
	/**
	 * Adiciona dinheiro a um usuario da lista.
	 * @param login Login do usuario que ira receber o dinheiro.
	 * @param valor Valor a ser adicionado nu usuario.
	 * @return Retorna true ou false dependendo de se foi ou nao possivel adicionar o
	 * dinheiro ao usuario especificado.
	 */
	public boolean adicionaDinheiroUsuario(String login, double valor) {
		Usuario usuario = loja.getUsuarioLogin(login);
		if (!(usuario.equals(null))) {
			usuario.adicionaDinheiro(valor);
			return true;
			
		} else {
			return false;
			
		}
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
	public boolean adicionaJogoUsuario(String login, String nome, double preco, HashSet<Estilo> estilos, String tipo) throws Exception {
		Jogo jogo = fabricaDeJogos.criaJogo(nome, preco, estilos, tipo);
		Usuario usuario = loja.getUsuarioLogin(login);
		if (!(usuario.equals(null))) {
			double ganho = usuario.compraJogo(jogo);
			loja.arrecada(ganho);
			
			if (usuario.getX2p() >= PONTUACAO_META) {
				usuario.viraVeterano();
				
			}
			
			return true;
				
		} else {
			return false;
			
		}
	}
	
	/**
	 * Cria um usuario de um tipo e adiciona a loja.
	 * @param nome Nome do usuario.
	 * @param login Login do usuario.
	 * @throws Exception Lanca exception em caso de ma construcao do usuario.
	 */
	public void criaUsuario(String nome, String login) throws EntradaInvalidaException {
		Usuario usuario = new Usuario(nome, login);
		loja.adicionaUsuario(usuario);
		
	}
	
	/**
	 * Organiza os usuarios e pega os 5 usuarios com mais X2p.
	 * @return Retorna uma String com os primeiros 5 usuarios com mais X2p.
	 */
	public String getTop5() {
		final String eol = System.getProperty("line.separator");
		loja.ordenaUsuarios();
        String retorno = "";
        for (int i = 0; i < 5; i++) {
        	retorno = retorno + (i+1) + "Lugar:" + eol + loja.getUsuarioIndex(i) + eol + eol;
        	
        }
		return retorno;
        
	}
	
	/**
	 * Recompensa o usuario com pontos x2p por jogar um jogo com base no estilo do jogo.
	 * @param login Login do usuario.
	 * @param nomeJogo Nome do jogo.
	 * @param score Pontuacao obtida.
	 * @param concluiu Indicador de se concluiu ou nao o jogo.
	 * @throws Exception Lanca exception se a pontuacao for negativa ou igual 0 e concluiu for true.
	 */
	public void usuarioGanhouPartida(String login, String nomeJogo, int score, boolean concluiu) throws Exception {
		Usuario usuario = loja.getUsuarioLogin(login);
		if (!(usuario.equals(null))) {
			usuario.ganhouPartida(nomeJogo, score, concluiu);
			
		}
		
		if (usuario.getX2p() >= PONTUACAO_META) {
			usuario.viraVeterano();
			
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
	public void usuarioPerdeuPartida(String login, String nomeJogo, int score, boolean concluiu) throws Exception {
		Usuario usuario = loja.getUsuarioLogin(login);
		if (!(usuario.equals(null))) {
			usuario.perdeuPartida(nomeJogo, score, concluiu);
			
		}
		
		if (usuario.getX2p() >= PONTUACAO_META) {
			usuario.viraVeterano();
			
		} else {
			usuario.viraNoob();
			
		}
	}

}
