package testes;

import java.util.HashSet;

import loja.FachadaDaLoja;

import org.junit.Assert;
import org.junit.Test;

import cliente.Usuario;
import cliente.Veterano;
import p2cg.EstiloDoJogo;
import p2cg.Jogo;
import p2cg.Plataforma;

public class TesteLoja {
	@Test
	public void TestLoja() {
			
			FachadaDaLoja loja = new FachadaDaLoja();
			Usuario novoUsuario = null;
			
			try {
				novoUsuario = loja.criaUsuario("Veterano", "Francisco Oliveira Neto", "francisco.neto", 100);
			} catch (Exception e) {
				Assert.assertEquals(e.getMessage(), "Entrada invalida!");
			}
			
			Assert.assertTrue(novoUsuario instanceof Veterano);
			Assert.assertEquals("Francisco Oliveira Neto", novoUsuario.getNome());
			Assert.assertEquals("francisco.neto", novoUsuario.getLogin());
			Assert.assertTrue(100 == novoUsuario.getDinheiro());
			
			loja.adicionaUsuarioNaLoja(novoUsuario);
			Assert.assertTrue(loja.getListaUsuariosLoja().contains(novoUsuario));
			
			HashSet<EstiloDoJogo> estilos = new HashSet<EstiloDoJogo>();
			estilos.add(EstiloDoJogo.ONLINE);
			estilos.add(EstiloDoJogo.COMPETIVO);
			estilos.add(EstiloDoJogo.MULTIPLAYER);
			loja.adicionaJogoNoUsuario("francisco.neto", "Magicka", 25, estilos, "RPG");
			Assert.assertTrue(novoUsuario.buscaJogo("Magicka") != null);
			Assert.assertTrue(estilos.contains(EstiloDoJogo.ONLINE));
			
			try{
				loja.downgrade("francisco.neto");
			} catch (Exception e) {
				Assert.assertEquals(e.getMessage(), "Nao possui pontos suficiente para virar veterano");
			}
			
			System.out.println(loja);
			
			
			
	}

}
