package carrinho.lanchonete.modelo;

import java.util.ArrayList;
import java.util.List;

import carrinho.lanchonete.modelo.Item;


public class Carrinho {
	
	private Integer idCar;
	private List<Item> itens = new ArrayList<Item>();
	private Usuario cliente;
	private String tipPagto;
	private Double total = 0.0;

	
	public Integer getIdCar() {
		
		return idCar;
		
	}//end public Integer getIdCar() 

	public void setIdCar(Integer idCar) {
		
		this.idCar = idCar;
		
	}//end public void setIdCar(Integer idCar) 
	
	
	public List<Item> getItens() {
		
		return itens;
		
	}//end public List<Item> getItens() 

	public void setItens(List<Item> itens) {
		
		this.itens = itens;
		
	}//end public void setItens(List<Item> itens) 

	
	public Double getTotal() {
		
		return total;
		
	}//end public Double getTotal() 
	
	public void setTotal(Double total) {
		
		this.total = total;
		
	}//end public void setTotal(Double total) 	
	

	public String getTipPagto() {
		
		return tipPagto;
		
	}//end public String getTipPagto() 

	public void setTipPagto(String tipPagto) {
		
		this.tipPagto = tipPagto;
		
	}//end public void setTipPagto(String tipPagto) 
	
	
	//chamar dao????
	public void adiciona(Item item) {
		
		itens.add(item);
		//total += item.getProduto().getvalUnit() * item.getQuantidade();
		
		
	}//end public void adiciona(Item item)

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	

	//excluindo item do carrinho
/*	public void remove(Item item) {
		
		//subtrai o valor do item do total
		total = total - item.getProduto().getvalUnit() * item.getQuantidade();
		
		//remove o item do carrinho
		itens.remove(item);
		
		
	}//end public void adiciona(Item item)*/ 



	
}//end public class Carrinho 