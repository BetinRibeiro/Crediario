package Bin.Devolucao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Bin.Produto.Produto;
@Entity
@Table(name = "item_devol")
public class ItemDevolucao {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",columnDefinition = "serial", nullable = false)
	private Integer id;
	
	private float custo;
	private float valor;
	private float quantidade;
	
//	
	
	@ManyToOne(optional = true)
    @JoinColumn(name="devolucao_id", nullable = true)
    private Devolucao devolucao;
//	@ManyToOne(optional = false)
//	private Compra compra;
	
	
	
	@ManyToOne(optional = true)
	private Produto produto;
	
	
	

	public Devolucao getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}

	public ItemDevolucao() {
		super();
	}

	public ItemDevolucao(Produto produto, float custo, float quantidade) {
		super();
		this.custo = custo;
		this.quantidade = quantidade;
//		this.compra = compra;
		this.produto = produto;
	}
	
	public ItemDevolucao(float custo, float quantidade, Produto produto, Devolucao devolucao) {
		super();
		this.custo = custo;
		this.quantidade = quantidade;
		this.devolucao = devolucao;
		this.produto = produto;
	}






	public Devolucao getdevolucao() {
		return devolucao;
	}

	public void setdevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	

}
