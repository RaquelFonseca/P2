/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
package classes;
 
import java.util.HashSet;
import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;
import exceptions.TipoJogoInvalidoException;
 
public class JogoFactory {
 
    public JogoFactory() {
         
    }
     
    /**
     * Cria uma instancia RPG de jogo.
     * @param nome Nome do Jogo RPG.
     * @param preco Preco do Jogo RPG.
     * @param estilos Conjunto de estilos do Jogo RPG.
     * @return retorna a instancia do RPG.
     * @throws Exception Lanca exception quando o RPG e mal contruido (nome vazio ou preco negativo).
     */
    public Jogo criaJogoRPG(String nome, double preco, HashSet<Estilo> estilos) throws Exception {
        return new RPG(nome, preco, estilos);
         
    }
     
    /**
     * Cria uma instancia Luta de jogo.
     * @param nome Nome do Jogo Luta.
     * @param preco Preco do Jogo Luta.
     * @param estilos Conjunto de estilos do Jogo Luta.
     * @return retorna a instancia do Luta.
     * @throws Exception Lanca exception quando a Luta e mal contruido (nome vazio ou preco negativo).
     */
    public Jogo criaJogoLuta(String nome, double preco, HashSet<Estilo> estilos) throws Exception {
        return new Luta(nome, preco, estilos);
         
    }
     
    /**
     * Cria uma instancia Plataforma de jogo.
     * @param nome Nome do Jogo Plataforma.
     * @param preco Preco do Jogo Plataforma.
     * @param estilos Conjunto de estilos do Jogo Plataforma.
     * @return retorna a instancia do Plataforma.
     * @throws Exception Lanca exception quando a Plataforma e mal contruido (nome vazio ou preco negativo).
     */
    public Jogo criaJogoPlataforma(String nome, double preco, HashSet<Estilo> estilos) throws Exception {
        return new Plataforma(nome, preco, estilos);
         
    }
     
    /**
     * Verifica o tipo do jogo que deve ser criado para criar o jogo na instancia desejada.
     * @param nome Nome do jogo a ser criado.
     * @param preco Preco do jogo a ser criado.
     * @param estilos Conjunto de estilos do jogo a ser criado.
     * @param tipo Tipo do jogo a ser criado.
     * @return Retorna uma das funcoes que criam instancias de jogo.
     * @throws Exception Lanca exception quando o jogo e mal contruido (nome vazio ou preco negativo).
     */
    public Jogo criaJogo(String nome, double preco, HashSet<Estilo> estilos, String tipo) throws Exception {
        if(tipo.equalsIgnoreCase("rpg")) {
            return criaJogoRPG(nome, preco, estilos);
             
        } else if(tipo.equalsIgnoreCase("luta")) {
            return criaJogoLuta(nome, preco, estilos);
             
        } else if(tipo.equalsIgnoreCase("plataforma")) {
            return criaJogoPlataforma(nome, preco, estilos);
             
        } else {
            throw new TipoJogoInvalidoException();
             
        }
         
    }
     
}
