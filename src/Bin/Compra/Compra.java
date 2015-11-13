package Bin.Compra;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data ;
	private float valor;
	//tres atributos o primeiro idString[] segundo o custounitario e o terceiro a quantidade
	private List<String[]> listaCompra;
	
	
	public Compra(Date data, float valor, List<String[]> listaCompra) {
		super();
		this.data = data;
		this.valor = valor;
		this.listaCompra = listaCompra;
	}


	public Compra() {
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


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}


	public List<String[]> getListaCompra() {
		return listaCompra;
	}


	public void setListaCompra(List<String[]> listaCompra) {
		this.listaCompra = listaCompra;
	}


	
	

}
