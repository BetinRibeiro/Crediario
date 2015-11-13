package Bin.Transporte;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transporte")
public class Transporte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;
	@Column(name = "modelo",length=80)
	private String modelo;
	@Column(name = "cor",length=20)
	private String cor;
	@Column(name = "ano",length=9)
	private String ano;
	@Column(name = "placa",length=7)
	private String placa;
	@Column(name = "renavan",length=15)
	private int renavan;
	@Column(name = "proprietario",length=80)
	private String proprietario;
	@Column(name = "anoDocumento",length=4)
	private int anoDocumento;
	
	
	public Transporte() {
		super();
	}
	public Transporte(String modelo, String cor, String ano, String placa, int renavan, String proprietario,
			int anoDocumento) {
		super();
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
		this.placa = placa;
		this.renavan = renavan;
		this.proprietario = proprietario;
		this.anoDocumento = anoDocumento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getRenavan() {
		return renavan;
	}
	public void setRenavan(int renavan) {
		this.renavan = renavan;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public int getAnoDocumento() {
		return anoDocumento;
	}
	public void setAnoDocumento(int anoDocumento) {
		this.anoDocumento = anoDocumento;
	}
	
	
	

}
