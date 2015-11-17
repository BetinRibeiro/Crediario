package Bin.Compra;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Bin.Produto.Produto;
@Entity
@Table(name = "inst_compra")
public class InstanciaCompra {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",columnDefinition = "serial", nullable = false)
	private Integer id;
	
	private float custo;
	private float quantidade;
	
//	
	
	@ManyToOne
    @JoinColumn(name="compra_id")
    private Compra compra;
//	@ManyToOne(optional = false)
//	private Compra compra;
	
	
	@ManyToOne(optional = false)
	private Produto produto;
	
	
	
	public InstanciaCompra() {
		super();
	}

	public InstanciaCompra(Produto produto, float custo, float quantidade) {
		super();
		this.custo = custo;
		this.quantidade = quantidade;
//		this.compra = compra;
		this.produto = produto;
	}
	
	public InstanciaCompra(float custo, float quantidade, Produto produto, Compra compra) {
		super();
		this.custo = custo;
		this.quantidade = quantidade;
		this.compra = compra;
		this.produto = produto;
	}






	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public Compra getCompra() {
//		return compra;
//	}
//	public void setCompra(Compra compra) {
//		this.compra = compra;
//	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
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
//	public Integer getCompra() {
//		return compra;
//	}
//	public void setCompra(Integer compra) {
//		this.compra = compra;
//	}
//	
	
	

}
