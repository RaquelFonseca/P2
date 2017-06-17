package loja;

import java.util.HashSet;

import cliente.Usuario;
import p2cg.EstiloDoJogo;
import p2cg.Jogo;
import p2cg.Luta;
import p2cg.Plataforma;
import p2cg.RPG;

/**
 * 
 * @author Raquel Fonseca
 *
 */

public class FabricaDeJogo {
	
	/**
	 * Cria um jogo do tipo plataforma
	 * @param nome: nome do jogo
	 * @param preco: preco do jogo
	 * @param estilos: estilos do jogo
	 * @return jogo
	 */
	public Jogo criaJogoPlataforma(String nome, double preco, HashSet<EstiloDoJogo> estilos) {
		Jogo novoJogo = new Plataforma(nome, preco, estilos);
		return novoJogo;
	}
	
	
	/**
	 * Cria um jogo do tipo RPG
	 * @param nome: nome do jogo
	 * @param preco: preco do jogo
	 * @param estilos: estilos do jogo
	 * @return jogo
	 */
	public Jogo criaJogoRPG(String nome, double preco, HashSet<EstiloDoJogo> estilos) {
		Jogo novoJogo = new RPG(nome, preco, estilos);
		return novoJogo;	
	}
	
	/**
	 * Cria um jogo do tipo luta
	 * @param nome: nome do jogo
	 * @param preco: preco do jogo
	 * @param estilos: estilos do jogo
	 * @return jogo
	 */
	public Jogo criaJogoLuta(String nome, double preco, HashSet<EstiloDoJogo> estilos) {
		Jogo novoJogo = new Luta(nome, preco, estilos);
		return novoJogo;	
	}
	
	
	/**
	 * Cria um jogo de acordo com o tipo passado no parametro
	 * @param nome: nome do jogo
	 * @param preco: preco do jogo
	 * @param tipo: tipo do jogo
	 * @param estilos: estilos do jogo
	 * @return jogo
	 */
	public Jogo criaJogo(String nome, double preco, String tipo, HashSet<EstiloDoJogo> estilos) {
		if (tipo.equalsIgnoreCase("luta")) {
			Jogo novoJogo = criaJogoLuta(nome, preco, estilos);
			return novoJogo;
		}else if (tipo.equalsIgnoreCase("plataforma")) {
			Jogo novoJogo = criaJogoPlataforma(nome, preco, estilos);
			return novoJogo;
		} else if (tipo.equalsIgnoreCase("RPG")) {
			Jogo novoJogo = criaJogoRPG(nome, preco, estilos);
			return novoJogo;
		}else {
			return null;
		}
	}
}
