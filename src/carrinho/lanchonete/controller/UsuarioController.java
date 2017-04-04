package carrinho.lanchonete.controller;


import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import carrinho.lanchonete.modelo.Usuario;
import carrinho.lanchonete.service.UsuarioService;


@Controller
public class UsuarioController {
	
	@Autowired UsuarioService usuarioService;

	
	/**************************************************************************
	 * Faz a autentica��o do usu�rio.                                         *
	 * Recebe os dados (long e senha), busca no banco o usu�rio e             *
	 * ent�o verifica se o login existe e se a senha est� correta.            *
	 * Se ocorrer qualquer erro, volta � tela inicial com a mensagem de erro. * 
	 **************************************************************************/	
	@RequestMapping(value = "/login")
	ModelAndView loginError( @RequestParam String nickusr, @RequestParam String senha, HttpSession sessao) {
		
		//busca usu�rio
		Usuario usuarioDoBanco = usuarioService.buscaUsuario(nickusr);
		
		//verifica usu�rio e senha
		if (usuarioDoBanco != null && usuarioDoBanco.getSenha().equals(senha)) {
			
			usuarioService.atualizaAcesso(usuarioDoBanco.getIdUsr(), new Date());
			
			//ok, salva o usu�rio na sess�o e mostra entradas da agenda
			sessao.setAttribute("usuario", usuarioDoBanco);
			return new ModelAndView("redirect:/cardapio");
			
		}//end if (usuarioDoBanco != null && usuarioDoBanco.getSenha().equals(senha)) 
		else {
			
			//erro, mostra mensagem e fica na tela "home"
			return new ModelAndView("redirect:/home");
			
		}//end else 
		
	}//end ModelAndView loginError( @RequestParam String nomeUsuario, @RequestParam String senha, HttpSession sessao) 
	
	
	//Sai do sistema. Este m�todo invalida a sess�o do usu�rio e redireciona para a "home"
	@RequestMapping("/logout")
	String logout(HttpSession sessao) {
		
		sessao.invalidate();
		return "redirect:/";
		
	}//end String logout(HttpSession sessao) 
	
	
	
	@RequestMapping(value="/singin", params="new")
	public ModelAndView cadastrarNovoUsuario(HttpSession sessao) {
		
		//criando objeto para receber os dados
		Usuario usuario = new Usuario();
		
		//mostrar tela passando objeto 
		return new ModelAndView("singin").addObject("usuario", usuario);
		
			
	}//end public ModelAndView cadastrarNovoUsuario(HttpSession sessao) 
	
	
	
	@RequestMapping(value="/singin", method = RequestMethod.POST) 
	ModelAndView confirmarNovoUsuario(Usuario usuario, RedirectAttributes redirectAttributes) {
				
				
		//salva no banco
		usuarioService.insert(usuario);
				
		redirectAttributes.addFlashAttribute("msg", "Registro '" + usuario.getIdUsr() + "' inserido com sucesso!");
				
				    
        return new ModelAndView("redirect:/cardapio");

		
	}//End ModelAndView confirmarNovoProduto()
	
	@RequestMapping(value="/singin/{id}")
	ModelAndView editarUsuario(	@PathVariable("id") Integer id,	RedirectAttributes redirectAttributes, HttpSession sessao) {
		
		try {
			
			//busca entrada
			//Produto produto = produtoService.findById(id);
			Usuario usuario = usuarioService.findById(id);
			
			if (usuario == null) {
				
				//n�o encontrou o produto
				throw new Exception("Entrada '" + id + "' n�o encontrada para edi��o!");
				
			}//end if (produto == null) 
			
			//mostra tela de edi��o
			return new ModelAndView("singin").addObject("usuario", usuario);
			
		}//end try
		catch (Exception e) {
			
			//mostra erro, se houver
			redirectAttributes.addFlashAttribute("erro", e.getMessage());      
			return new ModelAndView("redirect:/home");
			
		}//end catch (Exception e)  
		
	}//end ModelAndView editarProduto(	@PathVariable("id") Integer id,	RedirectAttributes redirectAttributes, HttpSession sessao) 	
	
	

}//end public class UsuarioController 