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

public class TestPerfilPlayList {

	@Test
	public void testPerfilPlayList() {

		try {

			Musica musica1 = new Musica("Insight", 3, "Pos-punk");
			Musica musica2 = new Musica("Shadowplay", 3, "Pos-punk");
			Musica musica3 = new Musica("Disorder", 4, "Pos-punk");

			Album album1 = new Album("Joy Division", "Unknown Pleasures", 1979);
			album1.adicionaMusica(musica1);
			album1.adicionaMusica(musica2);
			album1.adicionaMusica(musica3);

			Musica musica4 = new Musica("Smells Like Teen Spirit", 3, "Grunge");
			Musica musica5 = new Musica("Come As You Are", 3, "Grunge");
			Musica musica6 = new Musica("Stay Away", 4, "Grunge");

			Album album2 = new Album("Nirvana", "Nevermind", 1991);
			album2.adicionaMusica(musica4);
			album2.adicionaMusica(musica5);
			album2.adicionaMusica(musica6);

			Musica musica7 = new Musica("Right Next Door to Hell", 3,
					"Hard Rock");
			Musica musica8 = new Musica("Perfect Crime", 2, "Hard Rock");
			Musica musica9 = new Musica("Don't Cry", 4, "Hard Rock");

			Album album3 = new Album("Guns N'Roses", "Use Your Illusion I",
					1991);
			album3.adicionaMusica(musica7);
			album3.adicionaMusica(musica8);
			album3.adicionaMusica(musica9);

			Perfil perfil1 = new Perfil("Para fazer Laboratorios");

			perfil1.adicionaAlbum(album1);
			perfil1.adicionaAlbum(album2);
			perfil1.adicionaAlbum(album3);
			perfil1.adicionaAosFavoritos(album3);

			perfil1.adicionaPlaylist("Rock", "Nevermind", 2);
			Assert.assertEquals(album2, perfil1.containsAlbum("Nevermind"));

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		}

	}

	public void testPerfilPlaylistInvalido() {

		try {
			Perfil perfilInvalido = new Perfil("Para fazer Laboratorios");
			perfilInvalido.adicionaPlaylist("Rock", "Closer", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Album nao pertence ao Perfil especificado",
					e.getMessage());
		}
	}
}