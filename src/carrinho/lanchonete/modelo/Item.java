package carrinho.lanchonete.modelo;

import carrinho.lanchonete.modelo.Produto;

public class Item {
	
	private Produto produto;	  
	private Integer quantidade;
	private Double valorTotal;
	
	
	public Integer getQuantidade() {
		return quantidade;
	}//end public Integer getQuantidade() 
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}//end public void setQuantidade(Integer quantidade) 
	
	
	public Produto getProduto() {
		return produto;
	}//end public Produto getProduto() 
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}//end public void setProduto(Produto produto) 
	

	public Double getValorTotal() {
		return valorTotal;
	}//end public Double getValorTotal() 

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}//end public void setValorTotal(Double valorTotal) 	

}//end public class Item 