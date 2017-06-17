package cliente;

import exception.ErroEntradaException;
import exception.StringInvalidaException;
import exception.ValorInvalidoException;
import p2cg.EstiloDoJogo;
import p2cg.Jogo;

/**
 * 
 * @author Raquel Fonseca
 *
 */

public class Noob extends Usuario{

	/**
	 * Construtor da subclasse Noob
	 * @param nome: nome do usuario do tipo noob
	 * @param login: login do usuario do tipo noob
	 * @param dinheiro: dinheiro do usuario do tipo noob
	 * @throws ErroEntradaException 
	 */
	public Noob(String nome, String nomeLogin, double dinheiro) throws ErroEntradaException  {
		super(nome, nomeLogin, dinheiro);	
	}
	
	/**
	 * Retorna Noob como tipo do usuario 
	 */
	@Override
	public String getTipo() {
		return "Noob";
	}
	
	
	
	/**
	 * Compra um jogo como 10 porcento de desconto
	 */
	@Override
	public void compraJogo(Jogo jogo) {
		super.setX2p(getX2p() + (int) (10 * jogo.getPreco()));
		setDinheiro(getDinheiro() * (jogo.getPreco() * 0.10));
		listaJogosUsuario.add(jogo);	
	}

	
	/**
	 * Calcula quantidade a ser subtraida do x2p como punicao
	 * 
	 */
	@Override
	public void punir(String nomeDoJogo, int score, boolean zerou) {
		super.recompensar(nomeDoJogo, score, zerou);
		//for (Jogo jogo : listaJogosUsuario) {
		if (super.buscaJogo(nomeDoJogo) != null) {
			if (nomeDoJogo.equals(EstiloDoJogo.ONLINE)) {
				super.setX2p(getX2p()- 10); 
			}else if (nomeDoJogo.equals(EstiloDoJogo.COMPETIVO)){
				super.setX2p(getX2p()- 20); 
			} if (nomeDoJogo.equals(EstiloDoJogo.COOPERATIVO)) {
				super.setX2p(getX2p()- 50); 
			}
		}
		
	}
	
	/**
	 * Calcula quantidade a ser somada do x2p como recompensa
	 * 
	 */
	@Override
	public void recompensar(String nomeDoJogo, int score, boolean zerou) {
		super.punir(nomeDoJogo, score, zerou);
		if(super.buscaJogo(nomeDoJogo) != null) {
			if (nomeDoJogo.equals(EstiloDoJogo.OFFLINE)) {
				super.setX2p(getX2p()+ 30); 
			} if (nomeDoJogo.equals(EstiloDoJogo.MULTIPLAYER)) {
				super.setX2p(getX2p()+ 10); 
			} 
		}
	}
}




