package carrinho.lanchonete.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import carrinho.lanchonete.dao.CarrinhoDao;
import carrinho.lanchonete.dao.ItemDao;
import carrinho.lanchonete.modelo.Carrinho;
import carrinho.lanchonete.modelo.Item;
import carrinho.lanchonete.modelo.Usuario;

@Service
public class CarrinhoService {
	
	@Autowired CarrinhoDao carrinhoDao;
	@Autowired ItemDao itemDao;
	
	//função para gravar o carrinho no banco de dados
	public void gravaCarrinho(Carrinho carrinho){
		
		int id;
		
		id = carrinhoDao.inserirCarrinho(carrinho);
		
		//verifica se o carrinho foi gravado
		if ( id > 0 ) {
			
			//chamando a gravação dos itens no banco
			gravaItem(carrinho);
			
		}//end if ( id > 0 ) 
		
	}//end public integer novoCarrinho()
	
	
	public void gravaItem(Carrinho carrinho) {
		
		int numItem = 0;		
		
		List<Item> itens = carrinho.getItens();
		
		for (int i = 0; i < itens.size(); i++) {
			
			itemDao.inserirItens(itens.get(i), carrinho.getIdCar() , numItem);
			numItem++;
			
		}//end for (int i = 0; i < itens.size(); i++) 
		
	}//end public void novoItem()
	
	
	//função para adicionar ou atualizar a quantidade de um item no carrinho de compras
	public void adicionaItem(Carrinho carrinho, Item item ) {
		
		for ( int i = 0; i < carrinho.getItens().size(); i++ ) {
			 
			Item it = carrinho.getItens().get(i);
			
			if(it.getProduto().getIdProd().equals(item.getProduto().getIdProd())) {

				// se encontrou o item soma a quantidade
				carrinho.getItens().get(i).setQuantidade(carrinho.getItens().get(i).getQuantidade() + 1);
				calculaValCarrinho(carrinho);
		            		            
				// Sai do loop.
				return;
		            
			}//end if(it.getProduto().getIdProd().equals(idProd))
		       				
		}//end for(int i = 0; i < carrinho.getItens().size(); i++)
		 
		//se não existe o item ele inclui normalmente
		carrinho.adiciona(item);
		calculaValCarrinho(carrinho);
		
	}//end public void adicionaItem(Carrinho carrinho, Item item ) 
	
	
	
	//função para remover um item do carrinho de compra
	public void removeItem(Carrinho carrinho, int idProd ) {
		
		for(int i = 0; i < carrinho.getItens().size(); i++) {
			 
			Item it = carrinho.getItens().get(i);

			if(it.getProduto().getIdProd().equals(idProd)) {

				// Remove.
				carrinho.getItens().remove(it);

				//calcula os totais do carrinho
				calculaValCarrinho(carrinho);
		        
				// Sai do loop.
				break;
		            
			}//end if(it.getProduto().getIdProd().equals(idProd)) 		        
				    
		}//end for(int i = 0; i < carrinho.getItens().size(); i++)		
		
	}//end public void removeItem(Carrinho carrinho) 
	
	
	//função para calcular o total de cada item e o total  
	public void calculaValCarrinho(Carrinho carrinho){
		
		double totcar = 0;
		double totitem = 0;
		
		for (Item it : carrinho.getItens()) {
			
			totitem = it.getQuantidade() * it.getProduto().getvalUnit();

			it.setValorTotal(totitem);
			
			totcar += totitem;			
			
		}//end for (Item it : carrinho.getItens()) 
		
		carrinho.setTotal(totcar);
		
		return; 
		
	}//public void calculaValCarrinho(Carrinho carrinho)
	
	
	//função para verificar se o carinho está vazio
	public boolean carrinhoVazio(Carrinho carrinho){
		
		boolean var;
		
		var = ( carrinho.getItens().size() == 0);
		
		return var;
		
	}//end public boolean carrinhoVazio(Carrinho carrinho)
	
	
	public void adicionaCliente(Carrinho carrinho, Usuario usuario) {
		
		carrinho.setCliente(usuario);
		
		return;
		
	}//end public void adicionaCliente(Carrinho carrinho, Usuario usuario)
	
	

}//end public class CarrinhoService 