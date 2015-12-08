package Bin.Mercadoria;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Bin.Equipe.Equipe;

@Entity
@Table(name = "carrada")
public class Carrada implements Comparable<Carrada> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;
	@Column(name = "data_envio", nullable = false)
	private Date data;
	private String motorista;
	@Column(name = "valor_total")
	private float valorTotal;
	private float custo;
	@Column(name = "valor_frete")
	private float valorFrete;
	private String cidade;

	@ManyToOne
	@JoinColumn(name = "equipe_id")
	private Equipe equipe;
	@OneToMany(mappedBy = "carrada", fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE })
	// , cascade = { CascadeType.ALL, CascadeType.REMOVE }
	// @Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private Set<ItemCarrada> carrada;

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Set<ItemCarrada> getItemCarrada() {
		return carrada;
	}

	public void setItemCarrada(Set<ItemCarrada> carrada) {
		this.carrada = carrada;
	}

	public Carrada() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public float getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(float valorFrete) {
		this.valorFrete = valorFrete;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Set<ItemCarrada> getCarrada() {
		System.out.println(carrada);
		return carrada;
	}

	public void setCarrada(Set<ItemCarrada> itemcarrada) {
		this.carrada = null;
		this.carrada = itemcarrada;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}

	public Carrada(Date data, String motorista, float valorTotal, float custo, float valorFrete, String cidade,
			Equipe equipe) {
		super();
		this.data = data;
		this.motorista = motorista;
		this.valorTotal = valorTotal;
		this.custo = custo;
		this.valorFrete = valorFrete;
		this.cidade = cidade;
		this.equipe = equipe;
	}

	@Override
	public int compareTo(Carrada o) {
		// TODO Auto-generated method stub
		return Integer.compare(o.getId(), getId());
	}

}
