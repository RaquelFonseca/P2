/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */

package catalogoJogos;

import java.util.ArrayList;
import java.util.List;
import classes.Estilo;
import jogo.Jogo;

public class CatalogoJogos {

	private List<Jogo> jogos;
	private Ordenador ordenador;
	
	public CatalogoJogos() {
		this.jogos = new ArrayList<Jogo>();
		this.ordenador = new OrdenaCrescente();
		
	}
	
	/**
     * Procura um jogo pelo nome dentre os jogos do usuario.
     * @param nome Nome do jogo buscado.
     * @return Indice do jogo na lista de jogos.
     */
    public int buscaJogo(String nome) {
        for (Jogo jogo : jogos) {
            if(jogo.getNome().equalsIgnoreCase(nome)) {
                return this.jogos.indexOf(jogo);
                 
            }
        }
        return -1;
         
    }
	
    /**
     * Adiciona um jogo ao catalogo.
     * @param jogo Jogo a ser adicionado.
     */
	public void adicionaJogo(Jogo jogo) {
		jogos.add(jogo);
		
	}
	
	/**
     * Remove um jogo do catalogo.
     * @param jogo Jogo a ser removido.
     */
	public void removeJogo(Jogo jogo) {
		jogos.remove(jogo);
		
	}
	
	/**
     * Remove um jogo do catalogo pelo nome.
     * @param nome Nome do Jogo a ser removido.
     */
	public void removeJogo(String nome) {
		int index = buscaJogo(nome);
		jogos.remove(index);
		
	}
	
	/**
	 * Metodo para obter um jogo pelo nome.
	 * @param nome Nome do jogo desejado.
	 * @return Retorna o jogo caso ele esteja no catalogo.
	 */
	public Jogo getJogo(String nome) {
		int index = buscaJogo(nome);
		if (index != -1) {
			return jogos.get(index);
			
		} else {
			return null;
			
		}
	}
	
	/**
	 * Metodo para obter o jogo de maior Pontuacao Maxima.
	 * @return Retorna o jogo com a maior Pontuacao Maxima.
	 */
	public Jogo getJogoMaiorScore() {
		Jogo maiorScore = jogos.get(0);
		for (Jogo jogo : jogos) {
			if (maiorScore.getMaxScore() < jogo.getMaxScore()) {
				maiorScore = jogo;
				
			}
		}
		return maiorScore;
		
	}
	
	/**
	 * Metodo para obter o jogo Mais Jogado.
	 * @return Retorna o jogo com a maior numero de vezes jogado.
	 */
	public Jogo getJogoMaisJogado() {
		Jogo maisJogado = jogos.get(0);
		for (Jogo jogo : jogos) {
			if (maisJogado.getJogadas() < jogo.getJogadas()) {
				maisJogado = jogo;
				
			}
		}
		return maisJogado;
		
	}
	
	/**
	 * Metodo para obter o jogo Mais Concluido.
	 * @return Retorna o jogo com a maior numero de vezes concluido.
	 */
	public Jogo getJogoMaisConcluido() {
		Jogo maisConcluido = jogos.get(0);
		for (Jogo jogo : jogos) {
			if (maisConcluido.getConclusoes() < jogo.getConclusoes()) {
				maisConcluido = jogo;
				
			}
		}
		return maisConcluido;
		
	}
	
	/**
	 * Metodo para obter todos os jogos de um determinado estilo.
	 * @param estilo Estilo buscado nos jogos.
	 * @return Retorna uma lista com os jogos que possuem o estilo recebido.
	 */
	public List<Jogo> getJogosEstilo(Estilo estilo) {
		List<Jogo> lista = new ArrayList<Jogo>();
		for(Jogo jogo: jogos) {
			if (jogo.getEstilos().contains(estilo)) {
				lista.add(jogo);
				
			}
		}
		return lista;
		
	}
	
	/**
	 * Altera o tipo de Ordenação para crescente.
	 */
	public void ordenarCrescente() {
		this.ordenador = new OrdenaCrescente();
		
	}
	
	/**
	 * Altera o tipo de Ordenação para decrescente.
	 */
	public void ordenarDecrescente() {
		this.ordenador = new OrdenaDecrescente();
		
	}
	
	/**
	 * Ordena os jogos com base no Nome.
	 */
	public void ordenaDefault() {
		ordenador.ordenaDefault(jogos);
		
	}
	
	/**
	 * Ordena os jogos com base na Quantidade de veses jogadas.
	 */
	public void ordenaVicio() {
		ordenador.ordenaVicio(jogos);
		
	}
	
	/**
	 * Ordena os jogos com base na Maior pontuacao obtida do Jogo.
	 */
	public void ordenaDesempenho() {
		ordenador.ordenaDesempenho(jogos);
		
	}
	
	/**
	 * Ordena os jogos com base na Quantidade de veses de conclusoes do Jogo.
	 */
	public void ordenaExperiencia() {
		ordenador.ordenaExperiencia(jogos);
		
	}
	
	public List<Jogo> getJogos() {
		return this.jogos;
		
	}
	
}
