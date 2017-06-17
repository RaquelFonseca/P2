/*
 * 114210816 
 * RAQUEL AMBROZIO DA FONSECA  
 * TURMA 03
 * LAB 04
 */

package testes;

import org.junit.Test;
import org.junit.Assert;

import sp2fy.Musica;

public class TestMusica {

	@Test
	public void testMusica() {

		try {
			Musica musica1 = new Musica("Love Will Tear Us Apart", 3, "Pos-punk");
			Musica musica2 = new Musica("Shadowplay", 3, "Pos-punk");

			Assert.assertEquals("Love Will Tear Us Apart", musica1.getTitulo());
			Assert.assertEquals(3, musica1.getDuracao());
			Assert.assertEquals("Pos-punk", musica1.getGenero());

			Assert.assertEquals("Shadowplay", musica2.getTitulo());
			Assert.assertEquals(3, musica2.getDuracao());
			Assert.assertEquals("Pos-punk", musica2.getGenero());

			Musica musica1Acustica = new Musica("Love Will Tear Us Apart", 3, "Pos-punk (Acustico)");
			Assert.assertEquals(musica1, musica1Acustica);
			Assert.assertFalse(musica1.equals(musica2));

		} catch (Exception e) {
			Assert.fail(); 
		}
	}

	@Test
	public void testMusicaInvalida() {
		try {
			Musica tituloInvalido = new Musica("", 3, "Pos-punk");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Titulo da musica nao pode ser vazio.",
					e.getMessage());
		}

		try {
			Musica duracaoInvalida = new Musica("Atmosphere", -3, "Pos-punk");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Duracao da musica nao pode ser negativa.",
					e.getMessage());
		}

		try {
			Musica tipoInvalido = new Musica("Atmosphere", 3, "");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Genero da musica nao pode ser vazio.",
					e.getMessage());
		}

	}
}