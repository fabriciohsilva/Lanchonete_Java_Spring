package carrinho.lanchonete.modelo;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idUsr;
	private String nickUsr;
	private String cpfCnpj;
	private String cepUsr;
	private String endUsr;
	private String numEndUsr;
	private String emailUsr;
	private String telUsr;
	private String senha;
	private String nome;
	private Date ultimoAcesso;
	private String tipUsr;
	
	
	public Integer getIdUsr() {
		return idUsr;
	}
	
	public void setIdUsr(Integer idUsr) {
		this.idUsr = idUsr;
	}
	
	
	public String getNickUsr() {
		return nickUsr;
	}
	
	public void setNickUsr(String nickUsr) {
		this.nickUsr = nickUsr;
	}
	
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	
	public String getCepUsr() {
		return cepUsr;
	}
	
	public void setCepUsr(String cepUsr) {
		this.cepUsr = cepUsr;
	}
	
	
	public String getEndUsr() {
		return endUsr;
	}
	
	public void setEndUsr(String endUsr) {
		this.endUsr = endUsr;
	}
	
	
	public String getEmailUsr() {
		return emailUsr;
	}
	
	public void setEmailUsr(String emailUsr) {
		this.emailUsr = emailUsr;
	}
	
	
	public String getTelUsr() {
		return telUsr;
	}
	
	public void setTelUsr(String telUsr) {
		this.telUsr = telUsr;
	}
	
	
	public String getNumEndUsr() {
		return numEndUsr;
	}
	
	public void setNumEndUsr(String numEndUsr) {
		this.numEndUsr = numEndUsr;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}
	
	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
	

	public String getTipUsr() {
		return tipUsr;
	}

	public void setTipUsr(String tipUsr) {
		this.tipUsr = tipUsr;
	}

	
}//end public class Usuario implements Serializable 