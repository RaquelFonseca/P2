/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
package testes;

import java.util.HashSet;
import java.util.Set;

import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import usuario.Usuario;
import classes.*;
import exceptions.EntradaInvalidaException;
import exceptions.ErroLogicaException;

public class TestLoja {

	private Set<Estilo> estilos1;
	private Set<Estilo> estilos2;
	private Set<Estilo> estilos3;
	private Loja loja;
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	
	

	
	@Before
	public void setUp() {
		loja = new Loja();
		
		estilos1 = new HashSet<Estilo>();
		estilos2 = new HashSet<Estilo>();
		estilos3 = new HashSet<Estilo>(); 
		
		estilos3.add(Estilo.MULTIPLAYER);
		estilos2.add(Estilo.ONLINE);
		estilos1.add(Estilo.COMPETITIVO);
		try{
			this.jogo1 = new RPG("", 75.00, estilos1);
			this.jogo2 = new Luta("Guilty Gears", 80.00, estilos2);
			this.jogo3 = new Plataforma("Super Mario World", 30.00, estilos3);
			
		} catch (Exception e) {
			//Assert.fail();
			
		}
		
	}
	
	@Test
	public void testaLoja() {
		try {
			Assert.assertTrue(0.0 == loja.getArecadacao());
			loja.arrecada(500.0);
			Assert.assertTrue(500.0 == loja.getArecadacao());
			Usuario usuario1 = new Usuario("Usuario", "user.login");
			Usuario usuario2 = new Usuario("Usuaria", "auser.login");
			loja.adicionaUsuario(usuario1);
			loja.adicionaUsuario(usuario2);
			Assert.assertTrue(1 == loja.getUsuarios().indexOf(usuario2));
			Assert.assertTrue(loja.getUsuarios().contains(usuario1));
			usuario1.adicionaDinheiro(500.0);
			usuario2.adicionaDinheiro(500.0);
			usuario1.compraJogo(jogo1);
			usuario1.compraJogo(jogo3);
			usuario2.compraJogo(jogo1);
			usuario2.compraJogo(jogo2);
			loja.ordenaUsuarios();
			Assert.assertTrue(0 == loja.getUsuarios().indexOf(usuario2));
			Assert.assertTrue(1 == loja.getUsuarios().indexOf(usuario1));
			Usuario user = loja.getUsuarioLogin("user.login");
			Assert.assertEquals(usuario1.getNome(), user.getNome());
			Assert.assertEquals(usuario1.getLogin(), user.getLogin());
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.fail();
			
		} catch(Exception e) {
			//Assert.fail();
			
		}
	}
}
