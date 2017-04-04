package carrinho.lanchonete.modelo;

public class Produto {
	
	private Integer idProd;
	private String  desProd;
	private String  statusProd;
	private Double  valUnit;
	
//IdProd
	public Integer getIdProd() {
		return idProd;
	}//public Integer geIdProd() 
	
	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}//public void setIdProd(Integer idProd) 

	
//desProd
	public String getdesProd() {
		return desProd;
	}//public String getdesProd() 
	
	public void setdesProd(String desProd) {
		this.desProd = desProd;
	}//public void setdesProde(String desProd) 


//valUnit	
	public Double getvalUnit() {
		return valUnit;
	}
	
	public void setvalUnit(Double valUnit) {
		this.valUnit = valUnit;
	}
	
//valUnit
	public String getStatusProd() {
		return statusProd;
	}

	public void setStatusProd(String statusProd) {
		this.statusProd = statusProd;
	}
	
}//End public class Produto 