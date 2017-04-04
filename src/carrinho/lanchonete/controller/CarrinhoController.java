package carrinho.lanchonete.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import carrinho.lanchonete.dao.ProdutoDao;
import carrinho.lanchonete.modelo.Carrinho;
import carrinho.lanchonete.modelo.Item;
import carrinho.lanchonete.modelo.Produto;
import carrinho.lanchonete.modelo.Usuario;
import carrinho.lanchonete.service.CarrinhoService;


@Controller
public class CarrinhoController {

	@Autowired CarrinhoService carrinhoService;
	@Autowired ProdutoDao produtoDao;
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/carrinho")
	ModelAndView exibeCarrinho (HttpSession session) {
		
		
		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
		
		if (carrinho == null) {
			
			//caso a sessão não possua carrinho cria
			carrinho = new Carrinho();
			session.putValue("carrinho", carrinho);
			
			return new ModelAndView("redirect:/cardapio");
			
		}//end if (carrinho == null)			


		//return new ModelAndView("redirect:/carrinho");
		return new ModelAndView("carrinho").addObject("carrinho", carrinho);
		
	}//end ModelAndView exibeCarrinho (HttpSession session)
	
	

	@SuppressWarnings("deprecation")
	@RequestMapping(value="/carrinho/add/{idProd}")
	public ModelAndView adicionarItem(HttpSession session, @PathVariable("idProd") Integer idProd){

		
		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
		
		if (carrinho == null) {
			
			//caso a sessão não possua carrinho cria
			carrinho = new Carrinho();
			session.putValue("carrinho", carrinho);
			
		}//end if (carrinho == null) 
		
		//caso contrario inclui item no carrinho
		Item item = new Item();
		Produto p = produtoDao.encontrar(idProd);
		item.setProduto(p);
		item.setQuantidade(1);
		item.setValorTotal(p.getvalUnit());
		
		carrinhoService.adicionaItem(carrinho, item);

		//return new ModelAndView("redirect:/carrinho");
		return new ModelAndView("redirect:/carrinho").addObject("carrinho", carrinho);
		

	}//end public ModelAndView adicionarItem(Item item)
	
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/carrinho/del/{idProd}")
	public ModelAndView removerItem(HttpSession session, @PathVariable("idProd") Integer idProd){
		
		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
		
		if (carrinho == null) {
			
			//caso a sessão não possua carrinho cria
			carrinho = new Carrinho();
			session.putValue("carrinho", carrinho);
			
		}//end if (carrinho == null) 
		
		
		carrinhoService.removeItem(carrinho, idProd);		

		//return new ModelAndView("redirect:/carrinho");
		return new ModelAndView("redirect:/carrinho").addObject("carrinho", carrinho);

	}//end public ModelAndView adicionarItem(Item item)
	


	@SuppressWarnings("deprecation")
	@RequestMapping(value="/pedido")
	ModelAndView finalizaCompra(HttpSession session) {
		
		
		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
		
		if (carrinho == null) {			
			
			//caso a sessão não possua carrinho cria um novo e volta para o cardapio
			carrinho = new Carrinho();
			session.putValue("carrinho", carrinho);
			
			return new ModelAndView("redirect:/cardapio");
			
		}//end if (carrinho == null)
		
		
		//verifica se existe usuario da sessão http
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		//caso não exista usuario não permite continuar
		if (usuario == null){
			
			return new ModelAndView("redirect:/carrinho");
			
		}//end if (usuario == null)
		
		
		//verifica se o carrinho não está vazio
		if ( !carrinhoService.carrinhoVazio(carrinho)) {
			
			//adiciona cliente do pedido
			carrinhoService.adicionaCliente(carrinho, usuario);
			
			//inicia gravação do carrinho 
			carrinhoService.gravaCarrinho(carrinho);		
			
			return new ModelAndView("pedido").addObject("pedido", carrinho);
			
		}//end if ( !carrinhoService.carrinhoVazio(carrinho)) 
		
		return new ModelAndView("redirect:/cardapio");
		
	}//end ModelAndView finalizaCompra() 
	

}//end public class CarrinhoController
