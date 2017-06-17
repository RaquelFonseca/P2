/* 114210816
 * RAQUEL AMBROZIO DA FONSECA
 * TURMA 03 
 * LAB 03 */


package projeto;

import java.util.Scanner;

public class MenuEntrada {
	
	private static final int OPCAO_CADASTRAR = 1;
	private static final int OPCAO_VENDER = 2;
	private static final int OPCAO_IMPRIMIR = 3;
	private static final int OPCAO_SAIR = 4;

	public static void main(String[] args) {
		MenuEntrada menuInicial = new MenuEntrada();                                                                   // METODO MAIN PARA INICIAR O PROGRAMA
		menuInicial.inicializaPrograma();
	}
	
//======= METODO PARA IMPRIR O MENU ==========================================================================================================================

	public void menu() {

		System.out.println("= = = = Bem-vindo(a) ao EconomizaP2 = = = =");
		System.out.println("Digita a opcao desejada: ");
		System.out.println("1 - Cadastrar um Produto ");
		System.out.println("2 - Vender um Produto ");
		System.out.println("3 - Imprimir Balanco ");
		System.out.println("4 - Sair ");
		System.out.println();
		System.out.print("Opcao: ");

	} // FIM DO METODO menu

	
	
//======= METODO PARA INICIAR O PROGRAMA =======================================================================================================================	

	public void inicializaPrograma() {
		int opcao = 0;
		Scanner entrada = new Scanner(System.in);
		SupermercadoEconomizaP2 economizaP2 = new SupermercadoEconomizaP2();

		do {
			
			menu();
			
			opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch (opcao) {
			
			case OPCAO_CADASTRAR:
				economizaP2.cadastraProduto(entrada);
				break;

			case OPCAO_VENDER:
				economizaP2.vendeProduto(entrada);
				break;

			case OPCAO_IMPRIMIR:
				economizaP2.imprimeBalanco();
				break;

			case OPCAO_SAIR:
				System.out.println("");
				System.out.println("FIM DO PROGRAMA!");
				break;

			default:
				System.out.println();
				System.out.println("Opcao invalida. Tente novamente.");
				System.out.println();
				break;
				}
			
		} while (opcao != 4);
		
		entrada.close(); // FECHA O Scanner
		
	} // FIM DO METODO inicializaPrograma

	
} // FIM DA CLASSE MenuEntrada
