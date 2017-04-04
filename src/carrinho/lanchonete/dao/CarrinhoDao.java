package carrinho.lanchonete.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import carrinho.lanchonete.modelo.Carrinho;


@Repository
public class CarrinhoDao {
	
	@Autowired DataSource ds;
	
	public int inserirCarrinho(Carrinho carrinho) {
		
		//preparando conexão
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//obtem conexão
			c = ds.getConnection();
			
			//monta a query
			ps = c.prepareStatement(
					"INSERT INTO CARRINHO ( VALTOTCAR, IDCLI, TIPPAGTO)" +
					"VALUES               (         ?,     ?,        ?)", 
					Statement.RETURN_GENERATED_KEYS);
						
			//atribui os parâmetros
			ps.setDouble(1, carrinho.getTotal());
			ps.setInt(2,    carrinho.getCliente().getIdUsr());
			ps.setString(3, carrinho.getTipPagto());
			
			//executa a query
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				
				Integer id = rs.getInt(1);
				carrinho.setIdCar(id);
				
			}//End if (rs.next()) 
			
			return carrinho.getIdCar();
			
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
	

}//end public class CarrinhoDao 