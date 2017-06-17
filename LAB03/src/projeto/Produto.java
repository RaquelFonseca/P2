 /* 114210816
  * RAQUEL AMBROZIO DA FONSECA
  * TURMA 03 
  * LAB 03 */


package projeto;

public class Produto {
	
	  private String nome;     
      private double preco;                   // ATRIBUTOS DO PRODUTO
      private String tipo;
      private int quantidade;
      
      public Produto(String nome, double preco, String tipo, int quantidade ) {
    	  this.nome = nome;
    	  this.preco = preco;                   
    	  this.tipo = tipo;                     // CONSTRUTOR DO PRODUTO
    	  this.quantidade = quantidade;
    	  }
 
      
//======= METODOS PARA PARA RETORNAR OS ATRIBUTOS DO PRODUTO ============================================================================================================
      
      public String getNome() {
    	  return this.nome;
      }
      
      public double getPreco() {
    	  return this.preco;
      }
      
      public String getTipo() {
    	  return this.tipo;
      }
      
      public int getQuantidade() {
    	  return this.quantidade;
      }
      
      public void setQuantidade(int quantidade) {
    	  this.quantidade = quantidade;
      }
      
      public void estoque(int valor){
    	  quantidade -= valor;
      }
      
//======= METODO PARA PARA ATUALIZAR A QUANTIDADE DE PRODUTO ============================================================================================================
      
      public void setQuantidadeRestante(int produtosRestante){
  		this.quantidade = produtosRestante;
      }
      
//======= METODO PARA PARA RETORNAR OS ATRIBUTOS EM FORMA DE STRING ======================================================================================================   
     
      @Override
      public String toString() {
    	  return "==> "+ nome + " (" + tipo + "). R$ " + preco;
      }

      
      
}
