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

import classes.Estilo;
import exceptions.EntradaInvalidaException;
import exceptions.ErroLogicaException;

public class TestJogo {
	
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	private HashSet<Estilo> estilos1;
	private HashSet<Estilo> estilos2;
	private HashSet<Estilo> estilos3;
	
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
			
		} catch(Exception e) {
			Assert.fail();
			
		}
	}
	
	@Test
	public void TestaJogo() {
		try {
			Assert.assertEquals("Paper Mario", jogo1.getNome());
			Assert.assertTrue(80.00 == jogo2.getPreco());
			Assert.assertEquals(0, jogo3.getConclusoes());
			Assert.assertEquals(0, jogo1.getJogadas());
			Assert.assertEquals(0, jogo2.getMaxScore());
			Assert.assertEquals("Plataforma", jogo3.getTipo());
			
			jogo1.joga(10000, true);
			jogo2.joga(7000, false);
			jogo3.joga(8000, true);
			jogo1.joga(12000, false);
			
			Assert.assertEquals(1, jogo1.getConclusoes());
			Assert.assertEquals(2, jogo1.getJogadas());
			Assert.assertEquals(12000, jogo1.getMaxScore());
			
			Assert.assertEquals(1, jogo1.getConclusoes());
			Assert.assertEquals(2, jogo1.getJogadas());
			Assert.assertEquals(12000, jogo1.getMaxScore());
			
			Assert.assertEquals(0, jogo2.getConclusoes());
			Assert.assertEquals(1, jogo2.getJogadas());
			Assert.assertEquals(7000, jogo2.getMaxScore());
			
			Assert.assertEquals(1, jogo3.getConclusoes());
			Assert.assertEquals(1, jogo3.getJogadas());
			Assert.assertEquals(8000, jogo3.getMaxScore());
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.fail();
			
		} catch(Exception e) {
			Assert.fail();
			
		}
	}
	
	@Test
	public void TestJogoInvalido() {
		try {
			Jogo nomeInvalido = new RPG("", 75.00, estilos1);
			Assert.fail();
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Nome do jogo nao pode ser vazio.", e.getMessage());
			
		} catch(Exception e) {
			Assert.fail();
			
		}
		
		try {
			Jogo precoInvalido = new Luta("Mortal Kombat", -75.00, estilos1);
			Assert.fail();
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Preco do jogo nao pode ser negativo.", e.getMessage());
			
		} catch(Exception e) {
			Assert.fail();
			
		}
		
		try {
			jogo3.joga(-100, false);
			Assert.fail();
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Pontuacao atingida nao pode ser negativa.", e.getMessage());
			
		} catch(Exception e) {
			Assert.fail();
			
		}
		
		try {
			jogo2.joga(0, true);
			Assert.fail();
			
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Nao e possivel concluir o jogo com pontuacao igual a 0.", e.getMessage());
			
		} catch(Exception e) {
			Assert.fail();
			
		}
	}
}
