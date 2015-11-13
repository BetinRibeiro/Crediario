package Bin.Compra;

import java.sql.Date;

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
	private String[][] listaCompra;
	
	
	public Compra() {
		super();
	}


	public Compra(Date data, float valor, String[][] listaCompra) {
		super();
		this.data = data;
		this.valor = valor;
		this.listaCompra = listaCompra;
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


	public String[][] getListaCompra() {
		return listaCompra;
	}


	public void setListaCompra(String[][] listaCompra) {
		this.listaCompra = listaCompra;
	}
	
	
	

}
