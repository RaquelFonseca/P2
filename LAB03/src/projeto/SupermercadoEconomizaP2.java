/* 114210816
 * RAQUEL AMBROZIO DA FONSECA
 * TURMA 03 
 * LAB 03 */


package projeto;

import java.util.Scanner;

public class SupermercadoEconomizaP2 {
	
	private int contador;
	private int tamanho;
	private Produto[] produtos;
	private double totalArrecadado;
	private int produtosRestante;
	private double maxPossibilidadeVenda;

	public SupermercadoEconomizaP2() {
		
		contador = 0;
		tamanho = 5;
		produtos = new Produto[tamanho];
		totalArrecadado = 0;
		produtosRestante = 0;
		maxPossibilidadeVenda = 0;

	}
	
	
	
//======= METODO PARA CADASTRAR O PRODUTO ==============================================================================================================================
	
	public void cadastraProduto(Scanner entrada) {

		System.out.println(" ");
		System.out.println("= = = = Cadastro de Produtos = = = =");
		String escolha = "sim";
		
		do {

			System.out.print("Digite o nome do produto: ");
			String nomeC = entrada.nextLine();
			
			System.out.print("Digite o preco unitario do produto: ");
			double preco = entrada.nextDouble();
			entrada.nextLine();
			
			System.out.print("Digite o tipo do produto: ");
			String tipo = entrada.nextLine();
			
			System.out.print("Digite a quantidade no estoque: ");
			int quantidade = entrada.nextInt();
			entrada.nextLine();
			
			this.maxPossibilidadeVenda = maxPossibilidadeVenda + quantidade * preco;                 // CALCULA A QUANTIDADE MAXIMA QUE PODE SER ARRECADADA EM VENDAS
			this.produtosRestante = quantidade;
			
			Produto produtoCadastrado = new Produto(nomeC, preco, tipo, quantidade);                                                                // CRIA O PRODUTO
			
			produtos[contador] = produtoCadastrado;                                                                  // ARMAZENA AS INFORMACOES DO PRODUTO EM UM ARRAY 
			
			if (contador >= produtos.length) {                                                  // CHAMA O METODO PARA DOBRAR O TAMANHO DO ARRAY CASO ELE ESTEJA CHEIO
				dobraArray(tamanho);
			}
			
			contador++;
			
			System.out.println();
			System.out.println(produtoCadastrado.getQuantidade() + " " + produtoCadastrado.getNome() + "(s) cadastrado(a) com sucesso.");
			
			System.out.println();
			System.out.print("Deseja cadastrar outro produto? Digite sim, ou nao para voltar ao menu. ");
			escolha = entrada.nextLine();
			System.out.println();
			
		} while (escolha.equals("sim"));

	} // FIM DO METODO cadastraProduto
	

// METODO PARA DOBRAR O TAMANHO DO ARRAY //
	
	private void dobraArray(int tamanho) {
		
		Produto[] maisProdutos = new Produto[produtos.length * 2];
		System.arraycopy(produtos, 0, maisProdutos, 0, produtos.length);
		produtos = maisProdutos;

	} // FIM DO METODO dobraArray
	
	

//======= METODO PARA VENDER O PRODUTO ================================================================================================================================	
	
	public void vendeProduto(Scanner entrada) {
		
		System.out.println("");
		System.out.println("= = = = Venda de Produtos = = =");
		String escolha = "sim";
		
		do {
			System.out.print("Digite o nome do produto: ");
			String nomeV = entrada.nextLine();

			for (int i = 0; i <= produtos.length; i++) {

				if (produtos[i] == null) {                                                                                            // VERIFICA SE O PRODUTO EXISTE
					System.out.println();
					System.out.println("==> " + nomeV+ " nao cadastrados(as) no sistema.");  
					break;
				}
				
				if (produtos[i].getNome().equals(nomeV)) {
					
					System.out.println(produtos[i].toString());
					System.out.println("");
					System.out.print("Digite a quantidade que deseja vender: ");
					int quantidade = entrada.nextInt();
					entrada.nextLine();
					
					if (quantidade <= produtos[i].getQuantidade()) {
						
						produtosRestante = produtos[i].getQuantidade() - quantidade;                                   // CALCULA A QUANTIDADE DE PRODUTOS RESTANTES
						produtos[i].setQuantidadeRestante(produtosRestante);                                  // CHAMA METODO DO PRODUTO PARA ATUALIZAR A QUANTIDADE
						double arrecadacao = arrecadacaoProduto(produtos[i].getPreco(), quantidade);
						totalArrecadado = totalArrecadado + arrecadacao;

						System.out.printf("==> Total arrecadado: %.2f \n",(arrecadacaoProduto(produtos[i].getPreco(), quantidade)));
						break;
					}

					else {
						
						System.out.println();
						System.out
								.println("Nao eh possível vender pois nao ha " + produtos[i].getNome() + " suficiente.");
						break;
					}

				}

			}
			
			System.out.println();
			System.out.print("Deseja vender outro produto? Digite sim, ou nao para voltar ano menu. ");
			escolha = entrada.nextLine();
			System.out.println();
			
		} while (escolha.equals("sim"));

	} // FIM DO METODO vendeProduto
	

// METODO PARA DOBRAR O CALCULAR ARRECADACAO POR PRODUTO //
	
	private double arrecadacaoProduto(double preco, int quantidade) {
		double total = preco * quantidade;
		return total;
	
	} // FIM DO METODO arrecadacaoProduto
	
	

//======= METODO PARA IMPRIMIR O BALANCO =============================================================================================================================
		
	public void imprimeBalanco() {
		System.out.println();
		System.out.println("= = = = Impressao de Balanco = = = = ");

		if (produtos[0] == null) {
			System.out.println();
			System.out.println("Nao eh possivel imprimir pois nao ha produtos cadastrados no sistema. ");
			System.out.println();
		} 
		
		else {

			System.out.println("Produtos cadastrados");
			
			for (int i = 0; i < contador; i++) {

				System.out.println("    " + (i + 1) + ") " + produtos[i].getNome() + " (" + produtos[i].getTipo()           // LACO PARA IMPRIR O PRODUTOS CADASTRADOS
						+ ")  R$ " + produtos[i].getPreco() + " Restante: " + produtos[i].getQuantidade());

			}
			
			System.out.println();
			System.out.printf(" Total arrecadado em vendas: R$ %.2f \n ", (totalArrecadado));
			System.out.printf("Total que pode ser arrecadado: R$ %.2f\n", (maxPossibilidadeVenda - totalArrecadado));
			System.out.println();
		}

	} // FIM DO METODO imprimeBalanco


} // FIM DA CLASSE SupermercadoEconomizaP2
