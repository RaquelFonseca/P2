/*
 * 114210816 
 * RAQUEL AMBROZIO DA FONSECA  
 * TURMA 03
 * LAB 04
 */

package testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import sp2fy.Album;
import sp2fy.Musica;

public class TestAlbum {

	@Test
	public void testAlbum() {

		try {

			Album album1 = new Album("Joy Division", "Unknown Pleasures", 1979);
			Assert.assertEquals("Joy Division", album1.getArtistaAlbum());
			Assert.assertEquals("Unknown Pleasures", album1.getTituloAlbum());
			Assert.assertEquals(1979, album1.getAnoLancamento());
			Album album1Acustico = new Album("Joy Division", "Unknown Pleasures", 1980);
			Assert.assertEquals(album1, album1Acustico);

			Album album2 = new Album("Nirvana", "Nevermind", 1991);
			Assert.assertEquals("Nirvana", album2.getArtistaAlbum());
			Assert.assertEquals("Nevermind", album2.getTituloAlbum());
			Assert.assertEquals(1991, album2.getAnoLancamento());

			Assert.assertFalse(album1.equals(album2));

			Musica musica1 = new Musica("Insight", 3, "Pos-punk");
			Musica musica2 = new Musica("Shadowplay", 3, "Pos-punk");
			Musica musica3 = new Musica("Disorder", 4, "Pos-punk");

			album1.adicionaMusica(musica1);
			album1.adicionaMusica(musica2);
			album1.adicionaMusica(musica3);

			Assert.assertTrue(album1.contains(musica1));
			Assert.assertTrue(album1.contains(musica2));
			Assert.assertTrue(album1.contains(musica3));

			Assert.assertEquals(album1.getMusica(1), musica1);

			album1.removeMusica(musica2);
			Assert.assertFalse(album1.contains(musica2));

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testAlbumInvalida() {
		try {
			Album artistaInvalido = new Album("", "Closer", 1980);
			Assert.fail();

		} catch (Exception e) {
			Assert.assertEquals("Artista do album nao pode ser vazio.",
					e.getMessage());
		}

		try {
			Album tituloInvalida = new Album("Joy Division", "", 1978);
			Assert.fail();

		} catch (Exception e) {
			Assert.assertEquals("Titulo do album nao pode ser vazio.",
					e.getMessage());
		}

		try {
			Album anoInvalido = new Album("Joy Division", "Closer", -1980);
			Assert.fail();

		} catch (Exception e) {
			Assert.assertEquals("Ano de lancamento nao pode ser negativa.",
					e.getMessage());
		}

	}

}
