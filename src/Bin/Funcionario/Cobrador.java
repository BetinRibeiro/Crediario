package Bin.Funcionario;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cobrador")
public class Cobrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;
	
	@ManyToOne(optional = true)
	private Funcionario cobrador;
	
	@Column(name = "percentual_cobranca")
	private float percentualCobranca;
	
	@Column(name = "vale_cobrador")
	private float valeCobrador;

	
	public Cobrador(Funcionario cobrador, float percentualCobranca, float valeCobrador) {
		super();
		this.cobrador = cobrador;
		this.percentualCobranca = percentualCobranca;
		this.valeCobrador = valeCobrador;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Funcionario getCobrador() {
		return cobrador;
	}


	public void setCobrador(Funcionario cobrador) {
		this.cobrador = cobrador;
	}


	public float getPercentualCobranca() {
		return percentualCobranca;
	}


	public void setPercentualCobranca(float percentualCobranca) {
		this.percentualCobranca = percentualCobranca;
	}


	public float getValeCobrador() {
		return valeCobrador;
	}


	public void setValeCobrador(float valeCobrador) {
		this.valeCobrador = valeCobrador;
	}


	public Cobrador() {
		super();
	}

}
