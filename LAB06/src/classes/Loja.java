/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */

package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import usuario.Usuario;

public class Loja {

	private List<Usuario> usuarios;
	private double arecadacao;
	
	// Construtor
	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.arecadacao = 0.0;
		
	}
	
	/**
	 * Prcura um usuario pelo login.
	 * @param login Login do usuario buscado.
	 * @return Retorna o indice do usuario na lista (-1 se nao for encontrado).
	 */
	private int buscaUsuario(String login) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				return this.usuarios.indexOf(usuario);
				
			}
		}
		return -1;
		
	}
	
	/**
	 * Adiciona um valor a arrecadacao da loja.
	 * @param valor Valor a ser adicionado.
	 */
	public void arrecada(double valor) {
		this.arecadacao = this.arecadacao + valor;
		
	}
	
	/**
	 * Adiciona um usuario a lista de usuarios.
	 * @param usuario Usuario a ser adicionado.
	 */
	public void adicionaUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		
	}
	
	/**
	 * Ordena os usuarios com base na comparação padrão de usuarios.
	 */
	public void ordenaUsuarios() {
		Collections.sort(usuarios);
		
	}
	
	// ----- Getters -----
	public double getArecadacao() {
		return this.arecadacao;
		
	}
	
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	/**
	 * Metodo para obter um usuario com base na posicao da lista.
	 * @param index Posicao do usuariona lista.
	 * @return Retorna o usuario da posicão "index".
	 */
	public Usuario getUsuarioIndex(int index) {
		if (index < usuarios.size()) {
			return this.usuarios.get(index);
			
		} else {
			return null;
			
		}
		
	}
	
	/**
	 * Metodo para obter um usuario com base no Login.
	 * @param index Login do usuario desejado.
	 * @return Retorna o usuario com o login "login".
	 */
	public Usuario getUsuarioLogin(String login) {
		int index = buscaUsuario(login);
		if (index != -1) {
			return usuarios.get(index);
			
		} else {
			return null;
			
		}
	}
	
	// Modo de exibicao da loja
	@Override
	public String toString() {
		final String eol = System.getProperty("line.separator");
		String retorno = "=== Central P2-CG ===" + eol;
		for (Usuario usuario : usuarios) {
			retorno = retorno + usuario.toString() + eol;
		}
		
		retorno = retorno + "--------------------------------------------" + eol
				+ "Total arrecadado com vendas de jogos: R$ " + this.arecadacao;
		return retorno;
		
	}
	
}
