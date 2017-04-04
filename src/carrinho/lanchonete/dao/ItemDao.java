package carrinho.lanchonete.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import carrinho.lanchonete.modelo.Item;

@Repository
public class ItemDao {

	@Autowired DataSource ds;	
	
	public int inserirItens(Item item, int idCar, int numItem) {
		
		
		//preparando conexão
		Connection c = null;
		PreparedStatement ps = null;
		
		Integer id=0;
		
		try {
			
			//obtem conexão
			c = ds.getConnection();
			
			//monta a query
			ps = c.prepareStatement(
					"INSERT INTO ITEMCAR ( IDCAR, NUMITEM, IDPROD, QTDITEM, VALITEM)" +
					"VALUES               (    ?,       ?,      ?,       ?,        ?)", 
					Statement.RETURN_GENERATED_KEYS);
						
			//atribui os parâmetros
			ps.setInt(1, idCar );
			ps.setInt(2, (numItem+1));
			ps.setInt(3, item.getProduto().getIdProd());
			ps.setInt(4, item.getQuantidade());
			ps.setDouble(5, item.getValorTotal());
			
			//executa a query
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				
				id = rs.getInt(1);
								
				
			}//End if (rs.next()) 
			
			return id;
			
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
		
		
		
	}//end public void inserirItens(Carrinho carrinho)  

}//end public class itemDao 
