package carrinho.lanchonete.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import carrinho.lanchonete.modelo.Usuario;

@Repository
public class UsuarioDao {
	
	@Autowired DataSource ds;

	
	public void inserir(Usuario usuario) {
		
		//preparando conexão
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = ds.getConnection();
			
			ps = c.prepareStatement(
				"INSERT INTO USUARIO ( NICKUSR, CPFCNPJ, CEPUSR, ENDUSR, NUMENDUSR, EMAILUSR, TELUSR, SENHA, NOME)" + 
				"VALUES              (       ?,       ?,      ?,      ?,         ?,        ?,      ?,     ?,    ?)",
				Statement.RETURN_GENERATED_KEYS);
						
			ps.setString(1, usuario.getNickUsr());
			ps.setString(2, usuario.getCpfCnpj());			
			ps.setString(3, usuario.getCepUsr());
			ps.setString(4, usuario.getEndUsr());
			ps.setString(5, usuario.getNumEndUsr());
			ps.setString(6, usuario.getEmailUsr());
			ps.setString(7, usuario.getTelUsr());
			ps.setString(8, usuario.getSenha());
			ps.setString(9, usuario.getNome());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				
				Integer id = rs.getInt(1);
				usuario.setIdUsr(id);
				
			}//End if (rs.next()) 
			
		}//End try
		catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("Falha ao inserir!", e);
			
		}//End catch (SQLException e) 
		finally {
			
			//fechando conexão
			if (c != null) {
				
				try {
					
					c.close();
					
				}//End try fechar conexão
				catch (SQLException e) {
					
					e.printStackTrace();
					
				}//End catch (SQLException e) 
			}//End if (c != null) 
		}//End finally
	}//End public void inserir(Prod prod) 
	
	
	
	public Usuario findByNomeUsuario(String nickusr) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
			try {
		
				con = ds.getConnection();
				ps = con.prepareStatement("SELECT * FROM USUARIO WHERE NICKUSR = ?");
				ps.setString(1, nickusr);
				
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					
					Usuario usuario =  new Usuario();
					
					usuario.setIdUsr(rs.getInt("IDUSR"));
					usuario.setNickUsr(rs.getString("NICKUSR"));
					usuario.setCpfCnpj(rs.getString("CPFCNPJ"));
					usuario.setCepUsr(rs.getString("CEPUSR"));
					usuario.setEndUsr(rs.getString("ENDUSR"));
					usuario.setNumEndUsr(rs.getString("NUMENDUSR"));
					usuario.setEmailUsr(rs.getString("EMAILUSR"));
					usuario.setTelUsr(rs.getString("TELUSR"));
					usuario.setSenha(rs.getString("SENHA"));
					usuario.setNome(rs.getString("NOME"));
					usuario.setUltimoAcesso(rs.getTimestamp("ULTACESSO"));
					usuario.setTipUsr(rs.getString("TIPUSR"));
					
					return usuario;
					
				}//end if (rs.next()) 
				else {
					
					return null;
					
				}//end else 
				
		}//try
		catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}//end catch (SQLException e) 
		finally {
			
			if (con != null) {
				
				try {
				
					con.close();
					
				}//end try
				catch (SQLException e) {
					
					e.printStackTrace();
					
				}//end catch (SQLException e)
				
			}//end if (con != null) 
			
		}//end finally 
	}//end public Usuario findByNomeUsuario(String string) 
	
	

	public void atualizarUltimoAcesso(Integer id, Date data) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			con = ds.getConnection();
			
			ps = con.prepareStatement("update usuario set ULTACESSO = ? where IDUSR = ?");
			ps.setTimestamp(1, new java.sql.Timestamp(data.getTime()));
			ps.setInt(2, id);
			ps.executeUpdate();
			
		}//end try
		catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}//end catch (SQLException e) 
		finally {
			
			if (con != null) {
			
				try {
				
					con.close();
					
				}
				catch (SQLException e) {
					
					e.printStackTrace();
					
				}//end catch (SQLException e)
				
			}//end if (con != null) 
			
		}//end finally 
		
	}//end public void atualizarUltimoAcesso(Integer id, Date data) 
	
	
	
	//Implementando metodo find
	public Usuario encontrar(Integer id) {
		
		//criando conexão
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			//Preparando Conexão e consulta ao BD
			con = ds.getConnection();
			ps = con.prepareStatement("SELECT USUARIO.* FROM USUARIO WHERE IDUSR = ?");
			ps.setInt(1, id);
			
			//Executando consulta
			ResultSet rs = ps.executeQuery();
			
			//Acessando dados do retorno da consulta
			if (rs.next()) {
				
				Usuario usuario =  new Usuario();
				
				usuario.setIdUsr(rs.getInt("IDUSR"));
				usuario.setNickUsr(rs.getString("NICKUSR"));
				usuario.setCpfCnpj(rs.getString("CPFCNPJ"));
				usuario.setCepUsr(rs.getString("CEPUSR"));
				usuario.setEndUsr(rs.getString("ENDUSR"));
				usuario.setNumEndUsr(rs.getString("NUMENDUSR"));
				usuario.setEmailUsr(rs.getString("EMAILUSR"));
				usuario.setTelUsr(rs.getString("TELUSR"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setNome(rs.getString("NOME"));
				usuario.setUltimoAcesso(rs.getTimestamp("ULTACESSO"));
				usuario.setTipUsr(rs.getString("TIPUSR"));
				
				return usuario;
				
			}//end if (rs.next()) 
			else {
				
				return null;
				
			}//end else 
			
		}//End try 
		catch (SQLException e) {
			
			//Tratando exceções do BD
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}//End catch (SQLException e) 
		finally {
			
			//Depois de tudo fecha conexão caso esteja aberta 
			if (con != null) {
				
				try {
					
					con.close();
					
				}//End try 
				catch (SQLException e) {
					
					//Caso ocorra erro ao fechar conexão trata.
					e.printStackTrace();
					
				}//End catch (SQLException e) 
			}//End if (con != null) 
		}//End finally 
	}//End public produto find(Integer id) 
	

}//end public class UsuarioDao 