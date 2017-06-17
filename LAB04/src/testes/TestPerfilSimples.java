/*
 * 114210816 
 * RAQUEL AMBROZIO DA FONSECA  
 * TURMA 03
 * LAB 04
 */

package testes;

import org.junit.Assert;
import org.junit.Test;

import sp2fy.Album;
import sp2fy.Musica;
import sp2fy.Perfil;

public class TestPerfilSimples {

	@Test
	public void testPerfilSimples() {

		try {

			Musica musica1 = new Musica("Love Will Tear Us Apart", 3, "Pos-punk");
			Musica musica2 = new Musica("Shadowplay", 3, "Pos-punk");
			Musica musica3 = new Musica("Disorder", 4, "Pos-punk");

			Musica musica4 = new Musica("Atrocity Exhibition", 3, "Pos-punk");
			Musica musica5 = new Musica("Isolation", 3, "Pos-punk");
			Musica musica6 = new Musica("Colony", 4, "Pos-punk");

			Musica musica7 = new Musica("Digital", 3, "Pos-punk");
			Musica musica8 = new Musica("Glass", 3, "Pos-punk");
			Musica musica9 = new Musica("Atmosphere", 4, "Pos-punk");

			Album album1 = new Album("Joy Division", "Unknown Pleasures", 1979);
			Album album2 = new Album("Joy Division", "Closer", 1980);
			Album album3 = new Album("Joy Division", "Substance", 1978);

			album1.adicionaMusica(musica1);
			album1.adicionaMusica(musica2);
			album1.adicionaMusica(musica3);

			album2.adicionaMusica(musica4);
			album2.adicionaMusica(musica5);
			album2.adicionaMusica(musica6);

			album3.adicionaMusica(musica7);
			album3.adicionaMusica(musica8);
			album3.adicionaMusica(musica9);

			Perfil perfil1 = new Perfil("Para fazer Laboratorios");

			perfil1.adicionaAlbum(album1);
			perfil1.adicionaAlbum(album2);
			perfil1.adicionaAlbum(album3);
			perfil1.adicionaAosFavoritos(album3);

			Assert.assertEquals(album3, perfil1.containsAlbum("Substance"));

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		}
	}

	public void testMusicaInvalida() {
		try {
			Perfil nomePerfilInvalido = new Perfil("");
			Assert.fail();

		} catch (Exception e) {
			Assert.assertEquals("Nome do Perfil nao pode ser vazio.",
					e.getMessage());
		}
	}
}
