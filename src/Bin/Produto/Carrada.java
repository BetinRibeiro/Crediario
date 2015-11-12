package Bin.Produto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import Bin.Equipe.Equipe;
import Bin.Funcionario.Funcionario;
import Bin.Transporte.Transporte;

@Entity
@Table(name = "carrada")
public class Carrada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;
	@Column(nullable = true)
	private Date dataDispache;
	@Column(name = "custo", length = 10)
	private float custo;
	
	//Cada item é uma posição que carrega 0= id 1=custoUnitario 2=quantidade
	private String[][] listaMercadoria;

	@JoinColumn(name = "id_funcionario_motorista")
	private Funcionario motorista;
	@JoinColumn(name = "id_transporte")
	private Transporte transporte;
	@JoinColumn(name = "id_equipe")
	private Equipe equipe;
	
	
	
	public Carrada(Date dataDispache, float custo, String[][] listaMercadoria, Funcionario motorista,
			Transporte transporte) {
		super();
		this.dataDispache = dataDispache;
		this.custo = custo;
		this.listaMercadoria = listaMercadoria;
		this.motorista = motorista;
		this.transporte = transporte;
		this.equipe=null;
	}
	
	
	
	public Equipe getEquipe() {
		return equipe;
	}



	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataDispache() {
		return dataDispache;
	}
	public void setDataDispache(Date dataDispache) {
		this.dataDispache = dataDispache;
	}
	public float getCusto() {
		return custo;
	}
	public void setCusto(float custo) {
		this.custo = custo;
	}
	public String[][] getListaMercadoria() {
		return listaMercadoria;
	}
	public void setListaMercadoria(String[][] listaMercadoria) {
		this.listaMercadoria = listaMercadoria;
	}
	public Funcionario getMotorista() {
		return motorista;
	}
	public void setMotorista(Funcionario motorista) {
		this.motorista = motorista;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	
	
	
}
