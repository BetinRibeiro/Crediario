package Bin;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "endereco")
public class Endereco {
	@Column(name = "numero", length = 3)
	private String numero;
	@Column(name = "lougradouro", length = 100)
	private String lougradouro;
	@Column(name = "cidade", length = 50)
	private String cidade;
	@Column(name = "bairro", length = 50)
	private String bairro;
	@Column(name = "uf_endereco", length = 2)
	private String ufEndereco;
	@Column(name = "cep", length = 9)
	private String cep;
	
	
//	public Endereco(String numero, String lougradouro, String cidade, String bairro, String ufEndereco, String cep) {
//		super();
//		this.numero = numero;
//		this.lougradouro = lougradouro;
//		this.cidade = cidade;
//		this.bairro = bairro;
//		this.ufEndereco = ufEndereco;
//		this.cep = cep;
//	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getLougradouro() {
		return lougradouro;
	}
	public void setLougradouro(String lougradouro) {
		this.lougradouro = lougradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getUfEndereco() {
		return ufEndereco;
	}
	public void setUfEndereco(String ufEndereco) {
		this.ufEndereco = ufEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
	
}