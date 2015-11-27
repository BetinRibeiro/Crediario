package Bin.Compra;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;
	@Column(name = "data_compra", nullable = false)
	private Date data;
	private float valor;
	@OneToMany(mappedBy = "compra", fetch=FetchType.LAZY)
	private Set<ItemCompra> itemCompra;
	
	

	public Set<ItemCompra> getInstaCompra() {
		return itemCompra;
	}

	public void setProjetos( Set<ItemCompra> itemCompra) {
		this.itemCompra = itemCompra;
	}

	public Compra() {
		super();
	}

	public Compra(Date data, float valor) {
		this.data = data;
		this.valor = valor;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
		// atualizaItenscomId();
	}

}
