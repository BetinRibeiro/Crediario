package Bin.Mercadoria;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Bin.Compra.Compra;
import Bin.Produto.Produto;

@Entity
@Table(name = "item_carrada")
public class ItemCarrada {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",columnDefinition = "serial", nullable = false)
	private Integer id;
	private float custo;
	private float quantidade;
	private float preco;
	@ManyToOne(optional = false)
    @JoinColumn(name="carrada_id")
    private Carrada carrada;
	@ManyToOne(optional = true)
	private Produto produto;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public float getCusto() {
		return custo;
	}


	public void setCusto(float custo) {
		this.custo = custo;
	}


	public float getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public Carrada getCarrada() {
		return carrada;
	}


	public void setCarrada(Carrada carrada) {
		this.carrada = carrada;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public float getTotalCusto() {
		return custo*quantidade;
		
	}
	
	
	public float getTotalPreco() {
		return preco*quantidade;
		
	}
	
	
	
}
