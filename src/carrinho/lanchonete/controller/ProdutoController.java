package carrinho.lanchonete.controller;

//imports java
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;




//imports springboot
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


//imports projeto
import carrinho.lanchonete.service.ProdutoService;
import carrinho.lanchonete.modelo.Produto;


@Controller
public class ProdutoController {
	
	@Autowired ProdutoService produtoService;

	
	//acessando e exibindo o card�pio (lista de produtos)
	@RequestMapping("/cardapio")
	ModelAndView buscarEntradas(HttpSession sessao) {		
			
		//cria lista de produtos preencho com os dados do BD
		List<Produto> produtos = produtoService.listarProdutos("S");
		
		//exibe o card�pio passando a lista de produtos
		return new ModelAndView("cardapio").addObject("cardapio", produtos);
		
	}//end ModelAndView buscarEntradas() 
	
	
	
	//exibindo pagina de cadastro de produtos
	/*******************************************************************
	 * Mapeia a URL "/cadprod?new", cria um novo objeto Produto vazio, *
	 * depois mostra a p�gina de edi��o de produtos                    *
	 * para permitir a inclus�o de um novo produto                     *
	 * *****************************************************************/
	@RequestMapping(value="/cadprod", params="new")
	public ModelAndView cadastrarNovoProduto(HttpSession sessao) {
		
		//criando objeto para receber os dados
		Produto produto = new Produto();
		
		//mostrar tela passando objeto 
		return new ModelAndView("cadprod").addObject("produto", produto);
		
			
	}//public ModelAndView cadastrarNovoProduto(HttpSession sessao) 
	
	
	
	/***********************************************************************************
	 * M�todo para mostrar a tela de cadastro de produtos com os dados de um produto.  *
	 * Mapeia a url "/entrada/<id-da-entrada>", isto �, o ID da entrada                *
	 * Vai na pr�pria URL, de acordo com o padr�o REST. O m�todo procura a entrada     *
	 *  pelo ID que est� na URL e mostra a tela de edi��o.                             *
	 * Se ocorrer algum erro, redireciona para a tela inicial e mostra a mensagem.     * 
	 * O objeto RedirectAttributes permite colocar a mensagem de erro para ser exibida *
	 * ap�s o redirecionamento.                                                        *
	 ***********************************************************************************/
	@RequestMapping(value="/cadprod/{id}")
	ModelAndView editarProduto(	@PathVariable("id") Integer id,	RedirectAttributes redirectAttributes, HttpSession sessao) {
		
		try {
			
			//busca entrada
			Produto produto = produtoService.findById(id);
			
			if (produto == null) {
				
				//n�o encontrou o produto
				throw new Exception("Entrada '" + id + "' n�o encontrada para edi��o!");
				
			}//end if (produto == null) 
			
			//mostra tela de edi��o
			return new ModelAndView("cadprod").addObject("produto", produto);
			
		}//end try
		catch (Exception e) {
			
			//mostra erro, se houver
			redirectAttributes.addFlashAttribute("erro", e.getMessage());      
			return new ModelAndView("redirect:/cadprod");
			
		}//end catch (Exception e)  
		
	}//end ModelAndView editarProduto(	@PathVariable("id") Integer id,	RedirectAttributes redirectAttributes, HttpSession sessao) 	
	
	
	
	/*********************************************************************************
	 * M�todo que recebe os dados de um novo produto a ser cadastrado.               *
	 * Recebe o objeto Protudo, o arquivo e o status do produto,                     *
	 * insere o novo produto no banco  no banco de dados e                           *
	 * Copia o arquivo para o diret�rio IMGPROD.                                     *
	 * Enfim, o m�todo redireciona para o card�pio e mostra uma mensagem de sucesso. *
	 *********************************************************************************/
	@RequestMapping(value="/cadprod", method = RequestMethod.POST) 
	ModelAndView confirmarNovoProduto(Produto produto, RedirectAttributes redirectAttributes, @RequestParam("urlProd") MultipartFile arquivo, @RequestParam("statusProd") boolean status) {
				
		if (!arquivo.isEmpty()) {
        
			String fileName = null;
			
			try {
				
				//obtendo o status
				if (status)
					produto.setStatusProd("S");
				else
					produto.setStatusProd("N");
				
				
				//salva no banco
				produtoService.insert(produto);
				
				redirectAttributes.addFlashAttribute("msg", "Registro '" + produto.getIdProd() + "' inserido com sucesso!");
				
				
				//trecho para fazer upload do arquivo em um diret�rio espec�fico
				fileName = produto.getIdProd() + ".jpg";
                
                byte[] bytes = arquivo.getBytes();
                
                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File("./src/main/webapp/imgprod/" + fileName)));
                
                buffStream.write(bytes);
                buffStream.close();
			
                
                return new ModelAndView("redirect:/cardapio");
                
			}//End try 
			catch (Exception e){
			
				//mostra erro, se houver
				return new ModelAndView("cadprod").addObject("erro", e.getMessage());
			
			}//catch 
		
			
		}//end if (!arquivo.isEmpty()) 
		
		return new ModelAndView("redirect:/cadprod");
		
		
	}//End ModelAndView confirmarNovoProduto()
	
	
	
	/*********************************************************
	 * M�todo que recebe os dados do produto sendo editado.  *
	 * Recebe o objeto Produto e atualiza no banco de dados. *
	 * Enfim, o m�todo redireciona para a lista de entradas  *
	 * e mostra uma mensagem de sucesso.                     *
	 *********************************************************/
	@RequestMapping(value="/cadprod/{id}", method = RequestMethod.POST)
	ModelAndView confirmarAtualizacaoProduto(Produto produto, RedirectAttributes redirectAttributes, HttpSession sessao,  @RequestParam("urlProd") MultipartFile arquivo, @RequestParam("statusProd") boolean status) {
		

	        
		String fileName = null;
		
		try {
			
			//obtendo o status
			if (status)
				produto.setStatusProd("S");
			else
				produto.setStatusProd("N");
		
			//update
			produtoService.update(produto);
			
			//sucesso
			redirectAttributes.addFlashAttribute("msg", "Registro '" + produto.getIdProd() + "' atualizado com sucesso!");
			
			if (!arquivo.isEmpty()) {
				
				//trecho para fazer upload do arquivo em um diret�rio espec�fico
				fileName = produto.getIdProd() + ".jpg";
	            
	            byte[] bytes = arquivo.getBytes();
	            
	            BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File("./src/main/webapp/imgprod/" + fileName)));
	            
	            buffStream.write(bytes);
	            buffStream.close();
			}//end if (!arquivo.isEmpty())
			
			return new ModelAndView("redirect:/cardapio_edit");
			
		}//end try
		catch (Exception e) {
			
			//mostra erro, se houver
			return new ModelAndView("cadprod").addObject("erro", e.getMessage());
			
		}//end catch
		
	}//end ModelAndView confirmarAtualizacaoProduto(Produto produto, RedirectAttributes redirectAttributes, HttpSession sessao) 
	
	
	
	/******************************************************************
	 * Remove um produto. O m�todo mapeia a URL contendo              *
	 * o ID: "/produto/remover/<id a ser removido>".                  *
	 * ELe ent�o chama o m�todo de servi�o para remover e redireciona *
	 * para a p�gina inicial mostrando uma mensagem de sucesso.       *
	 ******************************************************************/
	@RequestMapping(value="/cadprod/remover/{id}")
	ModelAndView removerProduto( @PathVariable("id") Integer id, RedirectAttributes redirectAttributes,	HttpSession sessao) {
		
		try {			

			//remove
			produtoService.delete(id);
			
			//mostra mensagem na listagem
			redirectAttributes.addFlashAttribute("msg", "Registro '" + id + "' removido com sucesso!");      
			return new ModelAndView("redirect:/cardapio");
			
		}//end try
		catch (Exception e) {
			
			//mostra erro, se houver
			redirectAttributes.addFlashAttribute("erro", e.getMessage());      
			return new ModelAndView("redirect:/cadprod");
			
		}//end catch (Exception e) 

	}//end ModelAndView removerEntrada( @PathVariable("id") Integer id, RedirectAttributes redirectAttributes,	HttpSession sessao) 
	

	
	//acessando e exibindo o card�pio (lista de produtos)
	@RequestMapping("/cardapio_edit")
	ModelAndView buscarEntradasEdit(HttpSession sessao) {		
			
		//cria lista de produtos preencho com os dados do BD
		List<Produto> produtos = produtoService.listarProdutos("N");
		
		//exibe o card�pio passando a lista de produtos
		return new ModelAndView("cardapio_edit").addObject("cardapio", produtos);
		
	}//end ModelAndView buscarEntradas() 
	
		
}//end public class ProdutoController 