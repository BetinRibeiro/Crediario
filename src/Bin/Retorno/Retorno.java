package Bin.Retorno;

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

import Bin.Equipe.Equipe;

@Entity
@Table(name = "retorno")
public class Retorno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;
	@Column(name = "data_retorno", nullable = false)
	private Date data;
	private float custo;
	private float valor;
	
	
	@ManyToOne
	@JoinColumn(name = "equipe_id")
	private Equipe equipe;
	
	
	@OneToMany(mappedBy = "retorno", fetch=FetchType.EAGER)
	private Set<ItemRetorno> itemRetorno;
	

	public Set<ItemRetorno> getInstaRetorno() {
		return itemRetorno;
	}

	public void setProjetos( Set<ItemRetorno> itemRetorno) {
		this.itemRetorno = itemRetorno;
	}

	public Retorno() {
		super();
	}

	public Retorno(Date data, float valor) {
		this.data = data;
		this.valor = valor;
	}

	// public Retorno(Date data, float valor, List<ItemRetorno> listaRetorno)
	// {
	// super();
	// this.data = data;
	// this.valor = valor;
	// this.listaRetorno = listaRetorno;
	// }

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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
		// atualizaItenscomId();
	}
	//
	// public List<ItemRetorno> getListaRetorno() {
	//
	// return listaRetorno;
	// }
	//
	// private void atualizaItenscomId() {
	// for (int i = 0; i < listaRetorno.size(); i++) {
	// // listaRetorno.get(i).setRetorno(id);
	// }
	//
	// }
	//
	// public void setListaRetorno(List<ItemRetorno> listaRetorno) {
	// this.listaRetorno = listaRetorno;
	// }

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}

}
