package Bin.Mercadoria;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
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

import Bin.Compra.ItemCompra;
import Bin.Equipe.Equipe;

@Entity
@Table(name = "ItemMercadoria")
public class Carrada {
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
	@Column(name = "valor_frete")
	private float valorFrete;
	private String cidade;
	
	@ManyToOne
    @JoinColumn(name="equipe_id")
    private Equipe equipe;
	@OneToMany(mappedBy = "carrada", fetch=FetchType.LAZY)
	private Set<ItemCarrada> itemCarrada;


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
		return itemCarrada;
	}


	public void setCarrada(Set<ItemCarrada> itemcarrada) {
		this.itemCarrada = itemcarrada;
	}
	
	
	
	
	
	

}