/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */

package testes;

import java.util.HashSet;

import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import usuario.Usuario;
import classes.Estilo;
import exceptions.EntradaInvalidaException;

public class TestUsuario {
	
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	private HashSet<Estilo> estilos1;
	private HashSet<Estilo> estilos2;
	private HashSet<Estilo> estilos3;
	private Usuario usuario1;
	private Usuario usuario2;
	
	@Before
	public void setUp() {
		estilos1 = new HashSet<Estilo>();
		estilos2 = new HashSet<Estilo>();
		estilos3 = new HashSet<Estilo>();
		
		estilos1.add(Estilo.OFFLINE);
		estilos2.add(Estilo.COOPERATIVO);
		estilos3.add(Estilo.MULTIPLAYER);
		
		try {
			this.jogo1 = new RPG("Paper Mario", 75.00, estilos1);
			this.jogo2 = new Luta("Guilty Gears", 80.00, estilos2);
			this.jogo3 = new Plataforma("Super Mario World", 30.00, estilos3);
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.fail();
			
		} catch(Exception e) {
			Assert.fail();
			
		}
		
		try {
			this.usuario1 = new Usuario("Usuario 1", "user.1");
			this.usuario2 = new Usuario("Usuario 2", "user.2");
			usuario2.viraVeterano();
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.fail();
			
		} catch(Exception e) {
			Assert.fail();
			
		}
	}
	
	@Test
	public void TestaUsuario() {
		try {
			Assert.assertEquals("Usuario 1", usuario1.getNome());
			Assert.assertEquals("user.2", usuario2.getLogin());
			Assert.assertTrue(0 == usuario1.getDinheiro());
			Assert.assertTrue(0 == usuario2.getX2p());
			Assert.assertFalse(0 != usuario1.getJogos().size());
			Assert.assertEquals("Veterano", usuario2.getTipo());
			
			usuario1.adicionaDinheiro(120.0);
			usuario2.adicionaDinheiro(200.0);
			double gasto1 = 0.9 * jogo1.getPreco();
			double gasto2 = 0.9 * jogo3.getPreco();
			double gasto3 = 0.8 * jogo1.getPreco();
			double gasto4 = 0.8 * jogo2.getPreco();
			Assert.assertTrue(gasto1 == usuario1.compraJogo(jogo1));
			Assert.assertTrue(120.0 - gasto1 == usuario1.getDinheiro());
			Assert.assertTrue(gasto2 == usuario1.compraJogo(jogo3));
			Assert.assertTrue(120.0 - gasto1 - gasto2 == usuario1.getDinheiro());
			Assert.assertTrue(gasto3 == usuario2.compraJogo(jogo1));
			Assert.assertTrue(200.0 - gasto3 == usuario2.getDinheiro());
			Assert.assertTrue(gasto4 == usuario2.compraJogo(jogo2));
			Assert.assertTrue(200.0 - gasto3 - gasto4 == usuario2.getDinheiro());
			
			Assert.assertTrue(2 == usuario1.getJogos().size());
			Assert.assertTrue(2 == usuario2.getJogos().size());
			Assert.assertTrue(1050 == usuario1.getX2p());
			Assert.assertTrue(1550 == usuario2.getX2p());
			
			usuario1.ganhouPartida("Super Mario World", 10000, true);
			Assert.assertTrue(1080 == usuario1.getX2p());
			usuario1.perdeuPartida("Paper Mario", 12000, true);
			Assert.assertTrue(1090 == usuario1.getX2p());
			
			usuario2.perdeuPartida("Guilty Gears", 80000, true);
			Assert.assertTrue(1610 == usuario2.getX2p());
			usuario2.ganhouPartida("Paper Mario", 9000, false);
			Assert.assertTrue(1630 == usuario2.getX2p()); // 20 pontos aumentam pois nesse caso o jogo
														  // Paper Mario esta em usuario1 e usuario2
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.fail();
			
		} catch(Exception e) {
			Assert.fail();
			
		}
	}
	
	@Test
	public void testaUsuarioInvalido() {
		try {
			Usuario nomeInvalido = new Usuario("", "login");
			Assert.fail();

		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Nome do usuario nao pode ser vazio.", e.getMessage());
			
		} catch(Exception e) {
			Assert.fail();
			
		}
		try {
			Usuario loginInvalido = new Usuario("Nome", "");
			Assert.fail();

		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Login do usuario nao pode ser vazio.", e.getMessage());
			
		} catch(Exception e) {
			Assert.fail();
			
		}
	}

}
