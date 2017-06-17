/*
 * 114210816 
 * RAQUEL AMBROZIO DA FONSECA  
 * TURMA 03
 * LAB 04
 */

package sp2fy;

import java.util.ArrayList;

public class Album implements Comparable<Album> {
	private String artistaAlbum;
	private String tituloAlbum;
	private int anoLancamento;
	private int duracaoTotalAlbum;
	private ArrayList<Musica> musicas;

	public Album(String artistaAlbum, String tituloAlbum, int anoLancamento)
			throws Exception {

		// //// Lanca exception caso os parametros nao sejam passados
		// corretamente
		if (artistaAlbum.equals("") || artistaAlbum == null)
			throw new Exception("Artista do album nao pode ser vazio.");

		if (tituloAlbum.equals("") || tituloAlbum == null)
			throw new Exception("Titulo do album nao pode ser vazio.");

		if (anoLancamento <= 0)
			throw new Exception("Ano de lancamento nao pode ser negativa.");

		this.artistaAlbum = artistaAlbum;
		this.tituloAlbum = tituloAlbum;
		this.anoLancamento = anoLancamento;
		this.musicas = new ArrayList<Musica>();
	}

	// Metodos para retornar os atributos da classe

	public String getArtistaAlbum() {
		return this.artistaAlbum;
	}

	public String getTituloAlbum() {
		return this.tituloAlbum;
	}

	public int getAnoLancamento() {
		return this.anoLancamento;
	}

	public int getDuracaoTotalAlbum() {
		return this.duracaoTotalAlbum;
	}

	public ArrayList<Musica> getMusicas() {
		return this.musicas;
	}

	// Metodo para retornar uma musica do ArrayList de musicas em um determindo
	// indice

	public Musica getMusica(int faixa) {
		return this.musicas.get(faixa - 1);

	}

	// Metodo para adicionar uma musica no ArrayList de musicas

	public void adicionaMusica(Musica musica) {
		this.duracaoTotalAlbum += musica.getDuracao();
		this.musicas.add(musica);
	}

	// Metodo para remover uma musica no ArrayList de musicas

	public void removeMusica(Musica musica) {
		if (this.musicas.contains(musica)) {
			this.duracaoTotalAlbum -= musica.getDuracao();
			this.musicas.remove(musica);
		}
	}

	// Metodo para verificar se uma musica esta contida no ArrayList de musicas

	public boolean contains(Musica musica) {
		return this.getMusicas().contains(musica);
	}

	// Metodo para comparar os albuns por ano de lancamento

	@Override
	public int compareTo(Album outroAlbum) {
		if (this.anoLancamento < outroAlbum.getAnoLancamento()) {
			return -1;
		} else if (this.anoLancamento > outroAlbum.getAnoLancamento()) {
			return 1;
		} else {
			return 0;
		}
	}

	// HashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((artistaAlbum == null) ? 0 : artistaAlbum.hashCode());
		result = prime * result
				+ ((tituloAlbum == null) ? 0 : tituloAlbum.hashCode());
		return result;
	}

	// Metodo Equals para retornar se uma Objeto, nesse caso, do tipo Album e
	// igual a outro
	// Elas seram iguais se possuirem o mesmo titulo e a mesmo artista

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Album) {
			Album novoAlbum = (Album) obj;
			return this.getTituloAlbum().equalsIgnoreCase(novoAlbum.getTituloAlbum())
					&& this.getArtistaAlbum().equalsIgnoreCase(novoAlbum.getArtistaAlbum());

		} else {
			return false;
		}
	}

	// Metodo toString para retornar os atributos da classe em forma de String

	@Override
	public String toString() {
		return "Album [artistaAlbum=" + artistaAlbum + ", tituloAlbum="
				+ tituloAlbum + ", anoLancamento=" + anoLancamento
				+ ", duracaoTotalAlbum=" + duracaoTotalAlbum + ", album="
				+ musicas + "]";
	}

}
