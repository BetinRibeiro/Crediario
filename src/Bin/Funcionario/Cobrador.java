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
	private float percComissao;
	
	@Column(name = "vale_cobrador")
	private float valeCobrador;
	
	@Column(name = "divida")
	private float dividaCobrador;

	



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





	public float getPercComissao() {
		return percComissao;
	}





	public void setPercComissao(float percComissao) {
		this.percComissao = percComissao;
	}





	public float getValeCobrador() {
		return valeCobrador;
	}





	public void setValeCobrador(float valeCobrador) {
		this.valeCobrador = valeCobrador;
	}





	public float getDividaCobrador() {
		return dividaCobrador;
	}





	public void setDividaCobrador(float dividaCobrador) {
		this.dividaCobrador = dividaCobrador;
	}





	public Cobrador(Funcionario cobrador, float percComissao, float valeCobrador, float dividaCobrador) {
		super();
		this.cobrador = cobrador;
		this.percComissao = percComissao;
		this.valeCobrador = valeCobrador;
		this.dividaCobrador = dividaCobrador;
	}





	public Cobrador() {
		super();
	}





	public float getComissao(float recebidoTotal) {
		// TODO Auto-generated method stub
		return getPercComissao()*recebidoTotal/100;
	}

}
