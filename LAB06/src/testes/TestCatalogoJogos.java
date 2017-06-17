/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
package testes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import usuario.Usuario;
import catalogoJogos.CatalogoJogos;
import classes.*;
import exceptions.EntradaInvalidaException;
import exceptions.ErroLogicaException;

public class TestCatalogoJogos {

	private Set<Estilo> estilos1;
	private Set<Estilo> estilos2;
	private Set<Estilo> estilos3;
	private CatalogoJogos catalogo;
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	
	

	
	@Before
	public void setUp() {
		catalogo = new CatalogoJogos();
		
		estilos1 = new HashSet<Estilo>();
		estilos2 = new HashSet<Estilo>();
		estilos3 = new HashSet<Estilo>(); 
		
		estilos3.add(Estilo.MULTIPLAYER);
		estilos2.add(Estilo.ONLINE);
		estilos1.add(Estilo.COMPETITIVO);
		try{
			this.jogo1 = new RPG("Paper Mario", 75.00, estilos1);
			this.jogo2 = new Luta("Guilty Gears", 80.00, estilos2);
			this.jogo3 = new Plataforma("Super Mario World", 30.00, estilos3);
			jogo1.joga(10000, true);
			jogo1.joga(9500, true);
			jogo1.joga(9000, true);
			jogo2.joga(80000, true);
			jogo3.joga(20000, false);
			jogo3.joga(22700, false);
			jogo3.joga(19300, false);
			jogo3.joga(15600, false);
			
		} catch (Exception e) {
			Assert.fail();
			
		}
		
	}
	
	@Test
	public void testaCatalogoJogos() {
		Assert.assertTrue(0 == catalogo.getJogos().size());
		catalogo.adicionaJogo(jogo1);
		catalogo.adicionaJogo(jogo2);
		catalogo.adicionaJogo(jogo3);
		Assert.assertTrue(3 == catalogo.getJogos().size());
		Jogo jogo = catalogo.getJogo("Paper Mario");
		Assert.assertTrue(jogo1.getPreco() == jogo.getPreco());
		Assert.assertEquals(jogo1.getTipo(), jogo.getTipo());
		Assert.assertTrue(jogo1.getConclusoes() == jogo.getConclusoes());
		Assert.assertTrue(jogo1.getJogadas() == jogo.getJogadas());
		Assert.assertTrue(jogo1.getMaxScore() == jogo.getMaxScore());
		Assert.assertTrue(jogo2.getMaxScore() == catalogo.getJogoMaiorScore().getMaxScore());
		Assert.assertTrue(jogo3.getJogadas() == catalogo.getJogoMaisJogado().getJogadas());
		Assert.assertTrue(jogo1.getConclusoes() == catalogo.getJogoMaisConcluido().getConclusoes());
		List multiplayer = catalogo.getJogosEstilo(Estilo.MULTIPLAYER);
		Assert.assertTrue(1 == multiplayer.size());
		Jogo jogoMultiplayer = (Jogo) multiplayer.get(0);
		Assert.assertTrue(jogo3.getPreco() == jogoMultiplayer.getPreco());
		Assert.assertEquals(jogo3.getNome(), jogoMultiplayer.getNome());
		Assert.assertEquals(jogo3.getTipo(), jogoMultiplayer.getTipo());
		Assert.assertTrue(jogo3.getConclusoes() == jogoMultiplayer.getConclusoes());
		Assert.assertTrue(jogo3.getJogadas() == jogoMultiplayer.getJogadas());
		Assert.assertTrue(jogo3.getMaxScore() == jogoMultiplayer.getMaxScore());
		catalogo.ordenaDefault();
		Assert.assertTrue(0 == catalogo.buscaJogo("Guilty Gears"));
		Assert.assertTrue(1 == catalogo.buscaJogo("Paper Mario"));
		Assert.assertTrue(2 == catalogo.buscaJogo("Super Mario World"));
		catalogo.ordenaDesempenho();
		Assert.assertTrue(2 == catalogo.buscaJogo("Guilty Gears"));
		Assert.assertTrue(1 == catalogo.buscaJogo("Super Mario World"));
		Assert.assertTrue(0 == catalogo.buscaJogo("Paper Mario"));
		catalogo.ordenaExperiencia();
		Assert.assertTrue(2 == catalogo.buscaJogo("Paper Mario"));
		Assert.assertTrue(1 == catalogo.buscaJogo("Guilty Gears"));
		Assert.assertTrue(0 == catalogo.buscaJogo("Super Mario World"));
		catalogo.ordenaVicio();
		Assert.assertTrue(2 == catalogo.buscaJogo("Super Mario World"));
		Assert.assertTrue(1 == catalogo.buscaJogo("Paper Mario"));
		Assert.assertTrue(0 == catalogo.buscaJogo("Guilty Gears"));
		catalogo.ordenarDecrescente();
		catalogo.ordenaDefault();
		Assert.assertTrue(2 == catalogo.buscaJogo("Guilty Gears"));
		Assert.assertTrue(1 == catalogo.buscaJogo("Paper Mario"));
		Assert.assertTrue(0 == catalogo.buscaJogo("Super Mario World"));
		catalogo.ordenaDesempenho();
		Assert.assertTrue(0 == catalogo.buscaJogo("Guilty Gears"));
		Assert.assertTrue(1 == catalogo.buscaJogo("Super Mario World"));
		Assert.assertTrue(2 == catalogo.buscaJogo("Paper Mario"));
		catalogo.ordenaExperiencia();
		Assert.assertTrue(0 == catalogo.buscaJogo("Paper Mario"));
		Assert.assertTrue(1 == catalogo.buscaJogo("Guilty Gears"));
		Assert.assertTrue(2 == catalogo.buscaJogo("Super Mario World"));
		catalogo.ordenaVicio();
		Assert.assertTrue(0 == catalogo.buscaJogo("Super Mario World"));
		Assert.assertTrue(1 == catalogo.buscaJogo("Paper Mario"));
		Assert.assertTrue(2 == catalogo.buscaJogo("Guilty Gears"));
		
		
	}
}
