/* 114210816 - Raquel Ambrozio da Fonseca: LAB 6 - Turma 3 */
package catalogoJogos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jogo.Jogo;

public class OrdenaCrescente extends Ordenador {

	@Override
	public void ordenaDefault(List<Jogo> list) {
		Collections.sort(list);
		
	}

	@Override
	public void ordenaVicio(List<Jogo> list) {
		Collections.sort(list, new Comparator<Jogo>(){
			@Override
			public int compare(Jogo jogo, Jogo outroJogo) {
				if (jogo.getJogadas() < outroJogo.getJogadas()) {
					return -1;
					
				} else if(jogo.getJogadas() > outroJogo.getJogadas()){
					return 1;
					
				} else {
					return 0;
					
				}
			}
		});
		
	}

	@Override
	public void ordenaDesempenho(List<Jogo> list) {
		Collections.sort(list, new Comparator<Jogo>(){
			@Override
			public int compare(Jogo jogo, Jogo outroJogo) {
				if (jogo.getMaxScore() < outroJogo.getMaxScore()) {
					return -1;
					
				} else if(jogo.getMaxScore() > outroJogo.getMaxScore()){
					return 1;
					
				} else {
					return 0;
					
				}
			}
		});
		
	}

	@Override
	public void ordenaExperiencia(List<Jogo> list) {
		Collections.sort(list, new Comparator<Jogo>(){
			@Override
			public int compare(Jogo jogo, Jogo outroJogo) {
				if (jogo.getConclusoes() < outroJogo.getConclusoes()) {
					return -1;
					
				} else if(jogo.getConclusoes() > outroJogo.getConclusoes()){
					return 1;
					
				} else {
					return 0;
					
				}
			}
		});
		
	}
	
	

}
