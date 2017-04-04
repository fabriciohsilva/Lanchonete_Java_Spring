package carrinho.lanchonete.dao;

//imports SQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;



//Imports Classes
import carrinho.lanchonete.modelo.Produto;


@Repository
public class ProdutoDao {
	
	@Autowired DataSource ds;
	
	
	
	public void inserir(Produto prod) {
		
		//preparando conexão
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = ds.getConnection();
			
			ps = c.prepareStatement(
				"INSERT INTO PRODUTO ( DESPROD, STATUS, VALUNIT)" + 
				"VALUES              (       ?,      ?,       ?)", 
				Statement.RETURN_GENERATED_KEYS);
						
			ps.setString(1, prod.getdesProd());
			ps.setString(2, prod.getStatusProd());			
			ps.setDouble(3, prod.getvalUnit());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				
				Integer id = rs.getInt(1);
				prod.setIdProd(id);
				
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
	
	
	
	//Implementando metodo find
	public Produto encontrar(Integer id) {
		
		//criando conexão
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			//Preparando Conexão e consulta ao BD
			con = ds.getConnection();
			ps = con.prepareStatement("SELECT PRODUTO.* FROM PRODUTO WHERE IDPROD = ?");
			ps.setInt(1, id);
			
			//Executando consulta
			ResultSet rs = ps.executeQuery();
			
			//Acessando dados do retorno da consulta
			if (rs.next()) {
				
				//Instanciando objeto e atribuindo resultado da consulta para os atributos 
				Produto prod = new Produto();
				prod.setIdProd(rs.getInt("IDPROD"));
				prod.setdesProd(rs.getString("DESPROD"));
				//prod.setuM(rs.getString("UM")); Fabricio 21/05/2015
				prod.setStatusProd(rs.getString("STATUS")); 
				prod.setvalUnit(rs.getDouble("VALUNIT"));
				
				//Retornando objeto
				return prod;
				
			}//End if (rs.next())
			else {
				
				//Se a consulta não obter resultado retornar nulo
				return null;
				
			}//End else 
			
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
	
	
	public int atualizar(Produto produto){

		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			
			con = ds.getConnection();
			ps = con.prepareStatement("UPDATE PRODUTO SET DESPROD = ?, STATUS = ?, VALUNIT = ? WHERE IDPROD = ?");
			
			ps.setString(1, produto.getdesProd());
			//ps.setString(1, produto.getuM()); Fabricio 21/05/2015
			ps.setString(2, produto.getStatusProd());
			ps.setDouble(3, produto.getvalUnit());
			ps.setInt(4, produto.getIdProd());
			
			return ps.executeUpdate();
			
		}//end try
		catch (SQLException e){
			
			e.printStackTrace();
			throw new RuntimeException(e);		
		
		}//End catch (SQLException e)
		finally {
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//End catch (SQLException e) 
			}
		
		}//End finnaly 

	}//End public int update(Produto produto)
	
	
	
	public int remover(Integer id){
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement("DELETE FROM PRODUTO WHERE IDPROD = ?");
			ps.setInt(1, id);
			
			return ps.executeUpdate();
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}//end public int remove(Integer id)
	
	
	public List<Produto> listar(String status) {
		
		//cria coneção e Statment deixando-os como nulo (evita problemas de inicialização)
		Connection con = null;
		PreparedStatement ps = null;

		try {
			
			
			//obtem conexão com o BD
			con = ds.getConnection();
			
			if (status == "S") {
			
				ps = con.prepareStatement("SELECT PRODUTO.* FROM PRODUTO WHERE PRODUTO.STATUS = ? ORDER BY PRODUTO.IDPROD");			
				ps.setString(1, status);
				
			}//end if (status == "S") 
			else{
				
				ps = con.prepareStatement("SELECT PRODUTO.* FROM PRODUTO ORDER BY PRODUTO.IDPROD");
				
			}//end else			
			
			//após alimementar todos os parâmetros, executa a query e grava em um resultset 
			ResultSet rs = ps.executeQuery();
			
			//cria uma lista de objetos da classe Entrada para receber os registros do banco
			List<Produto> lista = new ArrayList<Produto>();			
			
			//o resultset deverá ser percorrido para preencher a lista
			while (rs.next()) {
			
				//cria objeto da classe entrada para receber os dados do BD e posteriormente gravar na lista
				Produto p = new Produto();
				
				//alimenta o objeto com dados do banco (resultset)
				p.setIdProd(rs.getInt("IDPROD"));
				p.setdesProd(rs.getString("DESPROD"));
				p.setStatusProd(rs.getString("STATUS")); 
				p.setvalUnit(rs.getDouble("VALUNIT"));
								
				//grava objeto carregado na lista
				lista.add(p);
				
			}//end while (rs.next()) 
			
			//retorna a lista que foi carregada com os dados do banco
			return lista;			
			
		}//end try
		catch (SQLException e) {
		
			//trecho para tratamento de exceções (sql)
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}//end catch (SQLException e) 
		finally {
		
			//trecho que será executado sempre independentemente de erro
			//teste para verificar se a conexão está aberta
			if (con != null) {			
				
				try {
					//caso esteja aberta a conexão será fechada
					con.close();
					
				}//end try
				catch (SQLException e) {
					//tratando exceções sql
					e.printStackTrace();
				}//end catch (SQLException e) 
			}//end if (con != null) 
		}//end finally
	}//end public List<Produto> listar()  

		

}//End public class ProdutoDao