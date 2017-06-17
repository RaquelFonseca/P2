package cliente;

import java.util.ArrayList;

import exception.ErroEntradaException;
import exception.ValorInvalidoException;
import exception.StringInvalidaException;
import p2cg.Jogo;

/**
 * 
 * @author Raquel Fonseca
 *
 */

public abstract class Usuario {

	private String nome;
	private String login;
	protected ArrayList<Jogo> listaJogosUsuario;
	private double dinheiro;
	private String tipo;
	private int x2p;
	
	
	
	/**
	 * Construtor da superclasse abstrata Usuario
	 * @param nome: nome do usuario
	 * @param login: login do usuario
	 * @param dinheiro: dinheiro do usuario
	 * @throws ErroEntradaException: lanca uma excecao se o nome for vazio ou login for vazio e/ou dinheiro for negativo
	 */
	public Usuario(String nome, String login, double dinheiro) throws ErroEntradaException{
		if (nome.equals("") || nome == null)
			throw new StringInvalidaException("Nome do usuario nao pode ser vazio.");
		if (login.equals("") || login == null)
			throw new StringInvalidaException("Login do usuario nao pode ser vazio.");
		if (dinheiro <= 0)
			throw new ValorInvalidoException("Dinheiro do usuario nao pode ser negativo.");
		
		
		this.nome = nome;
		this.login = login;
		this.listaJogosUsuario = new ArrayList<Jogo>();
		this.dinheiro = dinheiro;
		this.tipo = "";
		this.x2p = 0;
	}
	
	
	/**
	 * Retorna o nome do usuario
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	
	/**
	 * Retorna o login do usuario
	 * @return login
	 */
	public String getLogin() {
		return login;
	}
	
	
	/**
	 * Retorna a lista de jogos do usuario
	 * @return listaJogosUsuario
	 */
	public ArrayList<Jogo> getListaJogos() {
		return listaJogosUsuario;
	}

	
	/**
	 * Seta a lista de jogos do usuario
	 * @param listaJogos
	 */
	public void setListaJogos(ArrayList<Jogo> listaJogosUsuario) {
		this.listaJogosUsuario = listaJogosUsuario;
	}

	
	/**
	 * Retorna a quantidade de dinheiro do usuario
	 * @return dinheiro
	 */
	public double getDinheiro() {
		return dinheiro;
	}

	
	/**
	 * Seta a quantidade de dinheiro do usuario
	 * @param dinheiro
	 */
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	
	/**
	 * Retorna a experiencia do usuario (x2p)
	 * @return x2p
	 */
	public int getX2p() {
		return x2p;
	}

	
	/**
	 * Seta a experiencia do usuario (s2p)
	 * @param x2p
	 */
	public void setX2p(int x2p) {
		this.x2p = x2p;
	}
	
	
	/**
	 * Retorna o tipo do usuario
	 * @return tipo
	 */
	public String getTipo() {
		return "";
	}
	
	
	/**
	 * Compra um jogo se o usuario tiver dinheiro suficiente e adiciona na lista do usuario
	 * @param jogo
	 */
	public void compraJogo(Jogo jogo) {
		if (getDinheiro() > jogo.getPreco() && (!listaJogosUsuario.contains(jogo))) {
			setDinheiro(getDinheiro() - jogo.getPreco());
			listaJogosUsuario.add(jogo);
		}else{
			System.out.println("Saldo insuficiente.");
		}
	}
	
	
	/**
	 * Busca um jogo a partir do nome e o retorna
	 * @param nome
	 * @return jogo
	 */
	public Jogo buscaJogo(String nome) {
		for (Jogo jogo : listaJogosUsuario) {
			if (jogo.getNome().equalsIgnoreCase(nome)) {
				return jogo;
			}
		}
		return null;
	}
	
	
	/**
	 * Recompensa o usuario aumentando seu x2p
	 * @param nomeDoJogo
	 * @param score
	 * @param zerou
	 * @return x2p
	 */
	public void recompensar(String nomeDoJogo, int score, boolean zerou) {
		Jogo jogo = buscaJogo(nomeDoJogo);
		if (jogo != null) {
		this.x2p += jogo.joga(score, zerou);	
		}
	}
	
	
	/**
	 * Puni o usuario diminuindo seu x2p
	 * @param nomeDoJogo
	 * @param score
	 * @param zerou
	 * @return x2p
	 */
	public void punir(String nomeDoJogo, int score, boolean zerou) {
		Jogo jogo = buscaJogo(nomeDoJogo);
		if (jogo != null) {
		this.x2p += jogo.joga(score, zerou);	
		}
		
	}
	
	
	/**
	 * Adiciona dinheiro ao usuario
	 * @param dinheiro
	 */
	public void adicionaDinheiro(double dinheiro) {
		setDinheiro(getDinheiro() + dinheiro);
	}
	
	
	/**
	 * Retorna o usuario com os seus atributos como string
	 */
	@Override
	public String toString() {
		final String eol = System.getProperty("line.separator");
		String retorno = login + eol +
				nome + eol +
				"Jogador " + getTipo() + ": " + x2p + " x2p" + eol +
				"Lista de Jogos:" + eol;
		double total = 0.0;
		for (Jogo jogo : listaJogosUsuario) {
			retorno = retorno + jogo.toString() + eol;
			total = total + jogo.getPreco();
		}
		retorno = retorno + eol + "Total de preco dos jogos: R$ " + total;
		return retorno;
	}
}
