/*
 * 114210816 
 * RAQUEL AMBROZIO DA FONSECA  
 * TURMA 03
 * LAB 04
 */

package sp2fy;

public class Musica {
	private String titulo;
	private int duracao;
	private String genero;

	
	public Musica(String titulo, int duracao, String genero) throws Exception {

		////// Lanca exception caso os parametros nao sejam passados corretamente
		if (titulo.equals("") || titulo == null)
			throw new Exception("Titulo da musica nao pode ser vazio.");

		if (duracao <= 0)
			throw new Exception("Duracao da musica nao pode ser negativa.");

		if (genero.equals("") || genero == null)
			throw new Exception("Genero da musica nao pode ser vazio.");

		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;
	}

	// Metodos para retornar os atributos da classe

	public String getTitulo() {
		return this.titulo;
	}

	public int getDuracao() {
		return this.duracao;
	}

	public String getGenero() {
		return this.genero;
	}

	// HashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	// Metodo Equals para retornar se uma Objeto, nesse caso, do tipo Musica eh igual a outro
	// Eles seram iguais se possuirem o mesmo titulo e a mesma duracao

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Musica))
			return false;

		Musica musica = (Musica) obj;
		return titulo.equals(musica.getTitulo())
				&& duracao == (musica.getDuracao());
	}

	// Metodo toString para retornar os atributos da classe em forma de String
	@Override
	public String toString() {
		return "Musica [titulo=" + titulo + ", duracao=" + duracao
				+ ", genero=" + genero + "]";
	}

}
