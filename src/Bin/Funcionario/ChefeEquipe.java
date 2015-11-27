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
@Table(name = "chefe_equipe")
public class ChefeEquipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;
	
	@ManyToOne(optional = true)
	private Funcionario chefe;
	@Column(name = "percentual_venda")
	private float percentualVenda;
	@Column(name = "percentual_cobranca")
	private float percentualCobranca;

	@Column(name = "vale_chefe")
	private float valeChefe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Funcionario getChefe() {
		return chefe;
	}

	public void setChefe(Funcionario chefe) {
		this.chefe = chefe;
	}

	public float getPercentualVenda() {
		return percentualVenda;
	}

	public void setPercentualVenda(float percentualVenda) {
		this.percentualVenda = percentualVenda;
	}

	public float getPercentualCobranca() {
		return percentualCobranca;
	}

	public void setPercentualCobranca(float percentualCobranca) {
		this.percentualCobranca = percentualCobranca;
	}

	public float getValeChefe() {
		return valeChefe;
	}

	public void setValeChefe(float valeChefe) {
		this.valeChefe = valeChefe;
	}

	public ChefeEquipe() {
		super();
	}

	public ChefeEquipe(Funcionario chefe, float percentualVenda, float percentualCobranca, float valeChefe) {
		super();
		this.chefe = chefe;
		this.percentualVenda = percentualVenda;
		this.percentualCobranca = percentualCobranca;
		this.valeChefe = valeChefe;
	}

}
