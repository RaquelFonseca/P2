/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
 
package jogo;

import java.util.Set;

import classes.Estilo;
import exceptions.EntradaInvalidaException;
import exceptions.NomeInvalidoException;
import exceptions.ValorInvalidoException;
 
public abstract class Jogo implements Comparable<Jogo> {
 
    private String nome;
    private double preco;
    private Set<Estilo> estilos;
    private int maxScore;
    private int jogadas;
    private int conclusoes;
     
    // Construtor
    public Jogo(String nome, double preco, Set<Estilo> estilos) throws EntradaInvalidaException {
        if (nome.equals("") || nome.equals(null)) {
            throw new NomeInvalidoException("Nome do jogo nao pode ser vazio.");
        }
        if (preco <= 0.0) {
            throw new ValorInvalidoException("Preco do jogo nao pode ser negativo.");
        }
         
        this.nome = nome;
        this.preco = preco;
        this.estilos = estilos;
        this.maxScore = 0;
        this.jogadas = 0;
        this.conclusoes = 0;
         
    }
     
    // Metodo a ser definido por cara classe filha de Jogo
    public abstract int calculaPontosGanhos(int score);
     
    /**
     * Recebe um inteiro e um boolean referentes a pontuacao atingida e se concluiu ou nao o jogo,
     * atualiza o numero de vezes jogado, concluido e a maior pontuacao do jogo.
     * @param score Pontuaзгo atingida pelo jogador.
     * @param concluiu Indica se o jogador concluiu ou nao o jogo.
     * @return Retorna um valor inteiro referente a pontuacao (x2p) ganha por joga-lo.
     * @throws Exception Caso receba um valor negativo para pontuacao ou receba 0 e true lanзa
     * exception pois sao casos impossiveis.
     */
    public int joga(int score, boolean concluiu) throws ValorInvalidoException {
        if (score < 0) {
            throw new ValorInvalidoException("Pontuacao atingida nao pode ser negativa.");
        }
        if (score == 0 && concluiu) {
            throw new ValorInvalidoException("Nao e possivel concluir o jogo com pontuacao igual a 0.");
        }
         
        this.jogadas += 1;
         
        if(score > this.maxScore) {
            this.maxScore = score;
             
        }
         
        if (concluiu) {
            this.conclusoes += 1;
        }
        return calculaPontosGanhos(score);
         
    }
    
    public int compareTo(Jogo outroJogo) {
    	return this.nome.compareTo(outroJogo.getNome());
    	
    }
 
    // ----- Getter and Setters -----
    public String getNome() {
        return this.nome;
         
    }
 
    public double getPreco() {
        return this.preco;
         
    }
     
    public Set<Estilo> getEstilos() {
        return this.estilos;
         
    }
 
    public int getMaxScore() {
        return this.maxScore;
         
    }
 
    public int getJogadas() {
        return this.jogadas;
         
    }
 
    public int getConclusoes() {
        return this.conclusoes;
         
    }
     
    // Metodo a ser definido pelas classes filhas de Jogo
    public abstract String getTipo();
     
    // Modo de impressao de um Jogo
    @Override
    public String toString() {
        final String eol = System.getProperty("line.separator");
        String retorno = "+ " + getNome() + " - " + getTipo() + ":" + eol + "==> Jogou "
                + getJogadas() + " vez(es)" + eol + "==> Zerou " + getConclusoes() + " vez(es)"
                + eol + "==> Maior Score: " + getMaxScore();
        return retorno;
         
    }
     
}