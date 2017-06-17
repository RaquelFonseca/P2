/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
 
package jogo;
 
import java.util.Set;

import classes.Estilo;
 
public class Luta extends Jogo {
     
    private final int RAZAO = 1000;
 
    public Luta(String nome, double preco, Set<Estilo> estilos) throws Exception {
        super(nome, preco, estilos);
 
    }
     
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Luta) {
            Luta novoJogo = (Luta) obj;
            return this.getNome().equalsIgnoreCase(novoJogo.getNome());
             
        } else {
            return false;
             
        }
    }
 
    @Override
    public int calculaPontosGanhos(int score) {
        return score / RAZAO;
         
    }
 
    @Override
    public String getTipo() {
        return "Luta";
         
    }
}