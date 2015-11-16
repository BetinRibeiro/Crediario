package Bin.Compra;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {
	// TODO tenho que retornar e verificar essa classe para melhorar essa
	// questão de lista de insumos de compra 
	// mantia anteriormente uma lista de instancia de compra
	// mas quando começou a dar erro eu resolvi retirar e deixar mapeada
	// simplesmente dentro da instancia de compra o numero da venda equivalente

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;
	@Column(name = "data_compra", nullable = false)
	private Date data;
	private float valor;
	// tres atributos o primeiro idString[] segundo o custounitario e o terceiro
	// a quantidade
	// @ManyToMany(cascade = CascadeType.ALL)
	// public List<InstanciaCompra> listaCompra;

	public Compra() {
		super();
	}

	public Compra(Date data, float valor) {
		this.data = data;
		this.valor = valor;
	}

	// public Compra(Date data, float valor, List<InstanciaCompra> listaCompra)
	// {
	// super();
	// this.data = data;
	// this.valor = valor;
	// this.listaCompra = listaCompra;
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
	// public List<InstanciaCompra> getListaCompra() {
	//
	// return listaCompra;
	// }
	//
	// private void atualizaItenscomId() {
	// for (int i = 0; i < listaCompra.size(); i++) {
	// // listaCompra.get(i).setCompra(id);
	// }
	//
	// }
	//
	// public void setListaCompra(List<InstanciaCompra> listaCompra) {
	// this.listaCompra = listaCompra;
	// }

}
