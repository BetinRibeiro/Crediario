package Bin.Equipe;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deposito")
public class Deposito {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",columnDefinition = "serial", nullable = false)
	private Integer id;
	
	private float valor;
	private Date data;
	private String banco;
	
	@ManyToOne(optional = true,cascade={CascadeType.ALL,CascadeType.REMOVE}  )
    @JoinColumn(name="equipe_id")
    private Equipe equipe;
	
	public Deposito(float valor, Date data, String banco, Equipe equipe) {
		super();
		this.valor = valor;
		this.data = data;
		this.banco = banco;
		this.equipe = equipe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Deposito() {
		super();
	}
	
	
	
	
	
}
