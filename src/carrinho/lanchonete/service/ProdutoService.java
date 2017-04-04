package carrinho.lanchonete.service;

//imports do java
import java.util.ArrayList;
import java.util.List;


//imports springboot
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//imports prjLanchonete
import carrinho.lanchonete.dao.ProdutoDao;
import carrinho.lanchonete.modelo.Produto;


@Service
public class ProdutoService {
	
	@Autowired ProdutoDao produtoDao;
	
	//função para inserir registros no banco
	public void insert(Produto produto) {
		
		produtoDao.inserir(produto);
		
	}//end public void insert(Produto produto) 
	

	//montando a lista de produtos *buscar do BD
	public List<Produto> listarProdutos(String status) {
		
		List<Produto> cardapio = new ArrayList<Produto>();	
		
		cardapio = produtoDao.listar(status);
				
		return cardapio;
		
	}//End public List<String> listarProdutos()
	
	
	//busca o registro pelo id
	public Produto findById(Integer id) {
	
		return produtoDao.encontrar(id);
		
	}//public Produto findById(Integer id) 
	
	
	//apaga registro do BD
	public int delete(Integer id) {
		
		int qtd = produtoDao.remover(id);
		
		if (qtd == 0) {
			
			throw new RuntimeException("Registro '" + id + "' não encontrado para remoção!");
			
		}//end if (qtd == 0) 
		
		return qtd;
		
	}//end public int delete(Integer id)
	
	
	//atualizar registro no BD
	public int update(Produto produto) {
		
		if (produto.getIdProd() == null) {
			
			throw new RuntimeException("ID deve ser informado para atualizar!");
			
		}//end if (produto.getIdProd() == null) 
		
		
		validarProduto(produto);
		
		int qtd = produtoDao.atualizar(produto);
		
		
		if (qtd == 0) {
		
			throw new RuntimeException("Registro '" + produto.getIdProd() + "' não encontrado! Atualização não executada");
			
		}//end if (qtd == 0)
		
		return qtd;
		
	}//end public int update(Produto produto) 
	
	
	//validar atributos do produto
	private void validarProduto(Produto produto) {
		
		if (produto.getdesProd() == null || produto.getdesProd().isEmpty()) {
			
			throw new RuntimeException("Descrição deve ser informada!");
			
		}//end if (produto.getdesProd() == null || produto.getdesProd().isEmpty()) 
		
		
		/*if (produto.getuM() == null) {
			
			throw new RuntimeException("Horário deve ser informado!");
			
		}//end if (produto.getuM() == null)*/ 
		
		
		if (produto.getvalUnit() == null) {
			
			throw new RuntimeException("Usuário deve ser informado!");
			
		}//end if (produto.getvalUnit() == null) 
		
	}//end private void validarProduto(Produto produto) 
	

}//End public class ProdutoService