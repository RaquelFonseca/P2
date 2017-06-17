package loja;

import java.util.ArrayList;
import java.util.HashSet;

import p2cg.EstiloDoJogo;
import p2cg.Jogo;
import cliente.Noob;
import cliente.Usuario;
import cliente.Veterano;
import exception.ErroEntradaException;
import exception.ErroLogicaException;
import exception.StringInvalidaException;
import exception.UsuarioInvalidoException;
import exception.PontuacaoInsuficienteException;
import exception.ValorInvalidoException;

/**
 * 
 * @author Raquel Fonseca
 *
 */

public class FachadaDaLoja {

	private ArrayList<Usuario> listaUsuariosLoja;
	private FabricaDeJogo fabrica;
	private double totalArrecadadoVenda;

	/**
	 * Construtor da Loja
	 */
	public FachadaDaLoja() {
		this.listaUsuariosLoja = new ArrayList<Usuario>();
		this.fabrica = new FabricaDeJogo();
		this.totalArrecadadoVenda = 0;
	}

	/**
	 * Cria um usuario
	 * 
	 * @param tipo
	 *            : tipo do usuario, noob ou veterano
	 * @param nome
	 *            : nome do usuario
	 * @param login
	 *            : login do usuario
	 * @param dinheiro
	 *            : dinheiro do usuario
	 * @throws ErroEntradaException
	 * @return usuario 
	 */
	public Usuario criaUsuario(String tipo, String nome, String login,
			double dinheiro) throws ErroEntradaException {
		if (tipo.equalsIgnoreCase("noob")) {
			Usuario novoUsuario = new Noob(nome, login, dinheiro);
			return novoUsuario;
		} else {
			Usuario novoUsuario = new Veterano(nome, login, dinheiro);
			return novoUsuario;
		}
	}

	/**
	 * Adiciona um usuario na loja
	 * 
	 * @param novoUsuario
	 */
	public void adicionaUsuarioNaLoja(Usuario novoUsuario) {
		listaUsuariosLoja.add(novoUsuario);
	}

	/**
	 * Busca um usuario
	 * 
	 * @param login
	 * @return o indice da posicao do usuario
	 */
	public int buscaUsuario(String login) {
		for (Usuario usuario : listaUsuariosLoja) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				return listaUsuariosLoja.indexOf(usuario);
			}
		}
		return 0;
	}

	/**
	 * Adiciona um jogo no usuario
	 * 
	 * @param login
	 * @param nomeJogo
	 * @param preco
	 * @param estilos
	 * @param tipo
	 */
	public void adicionaJogoNoUsuario(String login, String nomeJogo,
			double preco, HashSet<EstiloDoJogo> estilos, String tipo) {
		int index = buscaUsuario(login);
		if (index != -1) {
			Jogo jogo = fabrica.criaJogo(nomeJogo, preco, tipo, estilos);
			if (!jogo.equals(null)) {
				listaUsuariosLoja.get(index).compraJogo(jogo);
				if (listaUsuariosLoja.get(index) instanceof Noob) {
					this.totalArrecadadoVenda += preco - (preco * 0.10);
				} else {
					this.totalArrecadadoVenda += preco - (preco * 0.20);
				}
			}
		}
	}

	/**
	 * Adiciona dinheiro no usuario
	 * 
	 * @param novoUsuario
	 * @param dinheiro
	 */
	public void adicionaDinheiro(Usuario novoUsuario, double dinheiro) {
		novoUsuario.adicionaDinheiro(dinheiro);
	}

	/**
	 * Passa o usuario para o tipo veterano se ele tenha x2p maior ou igual a 1000
	 * @param login
	 * @throws ErroEntradaException 
	 * @throws PontuacaoInsuficienteException 
	 */
	public void upgrade(String login) throws ErroLogicaException, ErroEntradaException {
		
		int index = buscaUsuario(login);
		if (index != -1) {
			if (listaUsuariosLoja.get(index) instanceof Veterano) 
				throw new UsuarioInvalidoException("Usuario ja eh veterano.");
			if (listaUsuariosLoja.get(index).getX2p() >= 100) {
				Usuario novoUsuario = new Veterano(listaUsuariosLoja.get(index)
						.getNome(), listaUsuariosLoja.get(index).getLogin(),
						listaUsuariosLoja.get(index).getDinheiro());
				novoUsuario.setListaJogos(listaUsuariosLoja.get(index).getListaJogos());
				novoUsuario.setX2p(listaUsuariosLoja.get(index).getX2p());
				listaUsuariosLoja.remove(listaUsuariosLoja.get(index));
				listaUsuariosLoja.add(novoUsuario);	
			}else {
				throw new PontuacaoInsuficienteException("Nao possui pontos suficiente para virar veterano");
			}
		}
	}
	
	/**
	 * Passa o usuario para o tipo noob se ele tenha x2p menor que 1000
	 * @param login
	 * @throws ValorInvalidoException 
	 * @throws StringInvalidaException 
	 */
	public void downgrade(String login) throws ErroLogicaException, ErroEntradaException {
		int index = buscaUsuario(login);
		if (index != -1) {
			if (listaUsuariosLoja.get(index) instanceof Noob) 
				throw new UsuarioInvalidoException("Usuario ja eh noob.");
			if (listaUsuariosLoja.get(index).getX2p() < 100) {
				Usuario novoUsuario = new Noob(listaUsuariosLoja.get(index)
						.getNome(), listaUsuariosLoja.get(index).getLogin(),
						listaUsuariosLoja.get(index).getDinheiro());
				novoUsuario.setListaJogos(listaUsuariosLoja.get(index).getListaJogos());
				novoUsuario.setX2p(listaUsuariosLoja.get(index).getX2p());
				listaUsuariosLoja.remove(listaUsuariosLoja.get(index));
				listaUsuariosLoja.add(novoUsuario);	
			}else {
				throw new PontuacaoInsuficienteException("Nao possui pontos suficiente para virar veterano");
			}
		}
	}
	
	
	/**
	 * Retorna a lista de jogos da loja
	 * @return listaUsuarioLoja
	 */
	public ArrayList<Usuario> getListaUsuariosLoja() {
		return listaUsuariosLoja;
	}

	public double getTotalArrecadadoVenda() {
		return totalArrecadadoVenda;
	}

	public void setTotalArrecadadoVenda(double totalArrecadadoVenda) {
		this.totalArrecadadoVenda = totalArrecadadoVenda;
	}

	/**
	 * ToString da loja
	 */
	@Override
	public String toString() {
		final String eol = System.getProperty("line.separator");
		String retorno = "=== Central P2-CG ===" + eol + eol;
		for (Usuario usuario : listaUsuariosLoja) {
			retorno = retorno + usuario.toString() + eol;
		}
		retorno = retorno + eol
				+ "--------------------------------------------" + eol
				+ "Total arrecadado com vendas de jogos: R$ "
				+ totalArrecadadoVenda;
		return retorno;
	}
}
