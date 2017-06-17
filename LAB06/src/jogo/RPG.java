/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
 
package jogo;
 
import java.util.Set;

import classes.Estilo;
 
public class RPG extends Jogo {
     
    private final int PONTOS = 10;
 
    public RPG(String nome, double preco, Set<Estilo> estilos) throws Exception {
        super(nome, preco, estilos);
         
    }
     
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RPG) {
            RPG novoJogo = (RPG) obj;
            return this.getNome().equalsIgnoreCase(novoJogo.getNome());
             
        } else {
            return false;
             
        }
    }
     
    @Override
    public int calculaPontosGanhos(int score) {
        return getJogadas() * PONTOS;
         
    }
 
    @Override
    public String getTipo() {
        return "RPG";
     
    }
}
