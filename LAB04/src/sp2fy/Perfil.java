/*
 * 114210816 
 * RAQUEL AMBROZIO DA FONSECA  
 * TURMA 03
 * LAB 04
 */

package sp2fy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Perfil {

	private String nomePerfil;
	private ArrayList<Album> albuns;
	private HashSet<Album> albunsFavoritos;
	private HashMap<String, ArrayList<Musica>> playlists;

	
	public Perfil(String nomePerfil) throws Exception {

		////// Lanca exception caso o parametro nome nao sejam passados corretamente
		if (nomePerfil.equals("") || nomePerfil == null)
			throw new Exception("Nome do Perfil nao pode ser vazio.");

		this.nomePerfil = nomePerfil;
		this.albuns = new ArrayList<Album>();
		this.albunsFavoritos = new HashSet<Album>();
		this.playlists = new HashMap<String, ArrayList<Musica>>();
	}

	// Metodos para retornar os atributos da classe

	public String getNome() {
		return this.nomePerfil;
	}

	public ArrayList<Album> getAlbuns() {
		return this.albuns;
	}

	public HashSet<Album> getAlbunsFavoritos() {
		return this.albunsFavoritos;
	}

	public HashMap<String, ArrayList<Musica>> getPlaylists() {
		return playlists;
	}

	// Metodo para adicionar um album no ArrayList de albuns

	public void adicionaAlbum(Album album) {
		this.albuns.add(album);
	}

	// Metodo para adicionar um album no HashSet de albuns favoritos

	public void adicionaAosFavoritos(Album album) {
		if (this.albuns.contains(album)
				&& !(this.albunsFavoritos.contains(album)))
			this.albunsFavoritos.add(album);
	}

	// Metodo para verificar se album esta contido no Perfil

	public Album containsAlbum(String nome) throws Exception {
		for (Album album : albuns) {
			if (album.getTituloAlbum().equals(nome)) {
				return album;
			}
		}
		throw new Exception("Album nao pertence ao Perfil especificado");

	}
	
	// Metodo para adicionar albuns na Playlist

	public void adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {
		if (!(playlists.containsKey(nomePlaylist))) {
			playlists.put(nomePlaylist, new ArrayList<Musica>());

		}

		Album album = containsAlbum(nomeAlbum);
		Musica musica = album.getMusica(faixa);
		playlists.get(nomePlaylist).add(musica);
	}
	
	
	// Metodos para ordenar albuns
	// Eles podem ser odenados por:
	// Ano de lancamento,
	// Artista,
	// Quantidade de Musica,
	// e Duracao Total do Album

	public void ordenaPorAno() {
		Collections.sort(albuns);
		
	}
	
	public void ordenaPorArtista() {
		Collections.sort(albuns, new Comparator<Album>(){
			@Override
			public int compare(Album album, Album outroAlbum) {
				return album.getArtistaAlbum().compareTo(outroAlbum.getArtistaAlbum());
			}
		});
		
	}
	
	public void ordenaPorQuantidadeMusica() {
		Collections.sort(albuns, new Comparator<Album>(){
			@Override
			public int compare(Album album, Album outroAlbum) {
				if (album.getMusicas().size() < outroAlbum.getMusicas().size()) {
					return -1;
				}
				if (album.getMusicas().size() > outroAlbum.getMusicas().size()) {
					return 1;
				}
				return 0;
			}
		});
	}
	
	
	public void ordenaPorDuracao() {
		Collections.sort(albuns, new Comparator<Album>() {
			@Override
			public int compare(Album album, Album outroAlbum) {
				if (album.getDuracaoTotalAlbum() < outroAlbum.getDuracaoTotalAlbum()) {
					return -1;
				}else if (album.getDuracaoTotalAlbum() > outroAlbum.getDuracaoTotalAlbum()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
	}

	
}
