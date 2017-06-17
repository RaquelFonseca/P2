/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
 
package usuario;

import java.util.List;

import classes.Estilo;
import catalogoJogos.CatalogoJogos;
import jogo.Jogo;
import exceptions.EntradaInvalidaException;
import exceptions.NomeInvalidoException;
 
public class Usuario implements Comparable<Usuario> {
 
    private String nome;
    private String login;
    private CatalogoJogos catalogoJogos;
    private double dinheiro;
    private int x2p;
    private Jogador jogador;
     
    // Construtor
    public Usuario(String nome, String login) throws EntradaInvalidaException {
        if (nome.equals("") || nome.equals(null)) {
            throw new NomeInvalidoException("Nome do usuario nao pode ser vazio.");
        }
        if (login.equals("") || login.equals(null)) {
            throw new NomeInvalidoException("Login do usuario nao pode ser vazio.");
        }
         
        this.nome = nome;
        this.login = login;
        this.catalogoJogos = new CatalogoJogos();
        this.dinheiro = 0.0;
        this.x2p = 0;
        this.jogador = new JogadorNoob();
         
    }
    
    /**
     * Altera a instancia do jogador para Veterano.
     */
    public void viraVeterano() {
    	this.jogador = new JogadorVeterano();
    
    }
    
    /**
     * Altera a instancia do jogador para Noob.
     */
    public void viraNoob() {
    	this.jogador = new JogadorNoob();
    	
    }
     
    /**
     * Reconpensa o jogador por jogar um jogo com base nos estilos do jogo.
     * @param nomeJogo Nome do jogo a ser jogado.
     * @param score Pontuacao atingida.
     * @param concluiu Indicador de se concluiu ou nao o jogo.
     * @throws Exception Lanaca exception para pontuacao negativa ou quando ela e 0 e o jogo
     * foi concluido.
     */
    public void ganhouPartida(String nomeJogo, int score, boolean concluiu) throws Exception {
    	Jogo jogo = catalogoJogos.getJogo(nomeJogo);
        if(!(jogo.equals(null))) {
        	int x2pGanhos = jogador.ganhouPartida(jogo, score, concluiu);
            this.x2p = this.x2p + x2pGanhos;
             
        }
    }
     
    /**
     * Puni o jogador por jogar um jogo com base nos estilos do jogo.
     * @param nomeJogo Nome do jogo a ser jogado.
     * @param score Pontuacao atingida.
     * @param concluiu Indicador de se concluiu ou nao o jogo.
     * @throws Exception Lanaca exception para pontuacao negativa ou quando ela e 0 e o jogo
     * foi concluido.
     */
    public void perdeuPartida(String nomeJogo, int score, boolean concluiu) throws Exception {
        Jogo jogo = catalogoJogos.getJogo(nomeJogo);
        if(!(jogo.equals(null))) {
        	int x2pGanhos = jogador.perdeuPartida(jogo, score, concluiu);
            this.x2p = this.x2p + x2pGanhos;
             
        }
    }
     
    /**
     * Realiza a compra de um jogo pelo usuario, adicionando o jogo se ele tiver dinheiro para
     * comprar e retirando a quantida gasta.
     * @param jogo Jogo a ser comprado.
     * @return retorna o valor de venda do jogo ou 0 se nao foi possivel compra-lo.
     */
    public double compraJogo(Jogo jogo) {
        double gasto = jogador.getDesconto() * jogo.getPreco();
        if (this.dinheiro >= gasto) {
            this.dinheiro = this.dinheiro - gasto;
            this.x2p += 10 * jogo.getPreco();
            this.catalogoJogos.adicionaJogo(jogo);;
            return gasto;
             
        } else {
            return 0.0;
             
        }
    }
     
    /**
     * Adiciona dinheiro a um usuario.
     * @param valor Valor a ser adicionado ao dinheiro do usuario.
     */
    public void adicionaDinheiro(double valor) {
        this.dinheiro = this.dinheiro + valor;
         
    }
 
    // ----- Getters and Setters -----
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
     
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String login) {
        this.login = login;
    }
 
    public List<Jogo> getJogos() {
        return this.catalogoJogos.getJogos();
    }
 
    /**
	 * Metodo para obter um jogo pelo nome.
	 * @param nome Nome do jogo desejado.
	 * @return Retorna o jogo caso o usuario o possua.
	 */
    public Jogo getJogo(String nome) {
    	return catalogoJogos.getJogo(nome);
    	
    }
 
    /**
	 * Metodo para obter o jogo de maior Pontuacao Maxima.
	 * @return Retorna o jogo com a maior Pontuacao Maxima.
	 */
    public Jogo getJogoMaiorScore() {
    	return catalogoJogos.getJogoMaiorScore();
    	
    }
    
    /**
	 * Metodo para obter o jogo Mais Jogado.
	 * @return Retorna o jogo com a maior numero de vezes jogado.
	 */
    public Jogo getJogoMaisJogado() {
    	return catalogoJogos.getJogoMaisJogado();
    	
    }
    
    /**
	 * Metodo para obter o jogo Mais Concluido.
	 * @return Retorna o jogo com a maior numero de vezes concluido.
	 */
    public Jogo getJogoMaisConcluido() {
    	return catalogoJogos.getJogoMaisConcluido();
    	
    }
    
    /**
	 * Metodo para obter todos os jogos de um determinado estilo.
	 * @param estilo Estilo buscado nos jogos.
	 * @return Retorna uma lista com os jogos que possuem o estilo recebido.
	 */
    public List<Jogo> getJogosEstilo(Estilo estilo) {
    	return catalogoJogos.getJogosEstilo(estilo);
    	
    }
    
    public double getDinheiro() {
        return dinheiro;
    }
 
    public int getX2p() {
        return x2p;
    }
    
    public String getTipo() {
    	return jogador.getTipo();
    	
    }
    
    // Modo de comparacao de usuarios
    @Override
	public int compareTo(Usuario outroUsuario) {
		if (x2p > outroUsuario.getX2p()) {
			return -1;
			
		} else if (x2p < outroUsuario.getX2p()) {
			return 1;
			
		} else {
			return 0;
			
		}
		
	}
     
    // Modo de impressao de um usuario
    @Override
    public String toString() {
        final String eol = System.getProperty("line.separator");
        String retorno = getLogin() + eol + getNome() + eol + "Jogador " + getTipo() + ": " +
        getX2p() + "x2p" + eol + "Lista de Jogos:"+ eol;
        double totalPreco = 0.0;
        for (Jogo jogo : getJogos()) {
            retorno = retorno + jogo.toString() + eol + eol;
            totalPreco = totalPreco + jogo.getPreco();
             
        }
         
        retorno = retorno + "Total de preco dos jogos: R$ " + totalPreco;
        return retorno;
         
    }
     
}
