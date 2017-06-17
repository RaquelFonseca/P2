package cliente;

import exception.ErroEntradaException;
import p2cg.EstiloDoJogo;
import p2cg.Jogo;

/**
 * 
 * @author Raquel Fonseca
 *
 */

public class Veterano extends Usuario {

	/**
	 * Construtor da subclasse Veterano
	 * 
	 * @param nome
	 *            : nome do usuario do tipo veterano
	 * @param login
	 *            : login do usuario do tipo veterano
	 * @param dinheiro
	 *            : dinheiro do usuario do tipo veterano
	 * @throws ErroEntradaException
	 */
	public Veterano(String nome, String nomeLogin, double dinheiro)
			throws ErroEntradaException {
		super(nome, nomeLogin, dinheiro);
	}

	/**
	 * Retorna Veterano como tipo do usuario
	 */
	@Override
	public String getTipo() {
		return "Veterano";
	}

	/**
	 * Compra um jogo como 20 porcento de desconto
	 */
	@Override
	public void compraJogo(Jogo jogo) {
		super.setX2p(getX2p() + (int) (10 * jogo.getPreco()));
		if (getDinheiro() > jogo.getPreco()
				&& (!listaJogosUsuario.contains(jogo))) {
			setDinheiro(getDinheiro() * (jogo.getPreco() * 0.20));
			listaJogosUsuario.add(jogo);
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	/**
	 * Calcula quantidade a ser subtraida do x2p como punicao
	 * 
	 */
	@Override
	public void punir(String nomeDoJogo, int score, boolean zerou) {
		super.punir(nomeDoJogo, score, zerou);
		if (super.buscaJogo(nomeDoJogo) != null) {
			if (nomeDoJogo.equals(EstiloDoJogo.COMPETIVO)) {
				super.setX2p(getX2p() - 20);
			} if (nomeDoJogo.equals(EstiloDoJogo.COOPERATIVO)) {
				super.setX2p(getX2p() - 20);
			}
		}
	}

	/**
	 * Calcula quantidade a ser somada do x2p como recompensa
	 * 
	 */
	@Override
	public void recompensar(String nomeDoJogo, int score, boolean zerou) {
		super.recompensar(nomeDoJogo, score, zerou);
		if (super.buscaJogo(nomeDoJogo) != null) {
			if (nomeDoJogo.equals(EstiloDoJogo.ONLINE)) {
				super.setX2p(getX2p() + 10);
			} if (nomeDoJogo.equals(EstiloDoJogo.COOPERATIVO)) {
				super.setX2p(getX2p() + 20);
			}
		}
	}
}
