package carrinho.lanchonete.controller;

//Imports Java
import javax.servlet.http.HttpSession;


//Imports Spring Boot
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//Imports prjLanchonete
import carrinho.lanchonete.modelo.Usuario;
import carrinho.lanchonete.service.UsuarioService;


@Controller
public class MainController {
	
	
	@Autowired UsuarioService usuarioService;
	
	
	//Mapeia a URL raiz, isto é, esta é a página principal, a "home". Mostra a página "index.jsp"
	@RequestMapping(value = "/")
	ModelAndView home( HttpSession session) {
		
		//busca usuário
		Usuario usuarioDoBanco = (Usuario) session.getAttribute("usuario");
		
		return new ModelAndView("index").addObject("usuario", usuarioDoBanco);
		
	}//end ModelAndView home( HttpSession session)  



	//Mapeia a URL raiz, isto é, esta é a página principal, a "home". Mostra a página "index.jsp"
	@RequestMapping(value = "/home")
	ModelAndView home2( HttpSession session) {
		
		//busca usuário
		Usuario usuarioDoBanco = (Usuario) session.getAttribute("usuario");
		
		return new ModelAndView("index").addObject("usuario", usuarioDoBanco);
		
	}//end ModelAndView home( HttpSession session) 	

	
	
	 //Mostra a página "sobre" (sobre.jsp)
	@RequestMapping("/sobre")
	String sobre() {
		
		return "sobre";
		
	}//end String sobre() 
	
	

	
}//End public class MainController 