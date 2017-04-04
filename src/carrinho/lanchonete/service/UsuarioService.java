package carrinho.lanchonete.service;

//imports java
import java.util.Date;




//imports spring boot
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




//imports projeto
import carrinho.lanchonete.dao.UsuarioDao;
import carrinho.lanchonete.modelo.Usuario;


@Service
public class UsuarioService {
	
	@Autowired	UsuarioDao usuarioDao;
	

/*	public Usuario autenticarUsuario(String nomeUsuario) {
		
		Usuario usuario = usuarioDao.findByNomeUsuario(nomeUsuario);
		
		if (usuario == null) {
			
			throw new RuntimeException("Usuário não cadastrado!");
			
		}//end if (usuario == null) 
		else {
			
		}//else
		
		
		usuarioDao.atualizarUltimoAcesso(usuario.getIdUsr(), new Date());
		
		return usuario;
		
	}//end public Usuario autenticarUsuario(String nomeUsuario) 
*/	
	
	
	public void insert(Usuario usuario) {
		
		try{
		
		usuarioDao.inserir(usuario);
		}
		catch(Exception e ){
			
			e.printStackTrace();
			throw new RuntimeException(e);
		
		}
		
	}//end public void insert(Usuario usuario)
	
	
	
	public Usuario buscaUsuario (String nickusr) {
		
		return usuarioDao.findByNomeUsuario(nickusr);
		
	}//end public void buscaUsuario (String string) 
	
	
	
	public void atualizaAcesso (Integer id, Date data) {
		
		usuarioDao.atualizarUltimoAcesso(id, data);
		
	}//end public void atualizaAcesso (Integer id, Date data) 
	
	
	
	//função para verificar se o usuário é administrador
	public boolean usuarioAdmin(Usuario usuario){		
		
		return ( usuario.getTipUsr() == "A");
		
	}//end public boolean carrinhoVazio(Carrinho carrinho)
	
	
	public Usuario findById(Integer id) {
		
		return usuarioDao.encontrar(id);
		
	}//public Produto findById(Integer id) 
	

}//end public class UsuarioService 