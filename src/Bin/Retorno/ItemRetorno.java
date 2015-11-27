package Bin.Retorno;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Bin.Equipe.Equipe;
import Bin.Produto.Produto;
@Entity
@Table(name = "item_retor")
public class ItemRetorno {
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
	
	@ManyToOne
    @JoinColumn(name="retorno_id")
    private Retorno retorno;
//	@ManyToOne(optional = false)
//	private Compra compra;
	
	@ManyToOne(optional = false)
	private Equipe equipe;
	
	
	@ManyToOne(optional = false)
	private Produto produto;
	
	
	
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public ItemRetorno() {
		super();
	}

	public ItemRetorno(Produto produto, float custo, float quantidade) {
		super();
		this.custo = custo;
		this.quantidade = quantidade;
//		this.compra = compra;
		this.produto = produto;
	}
	
	public ItemRetorno(float custo, float quantidade, Produto produto, Retorno retorno) {
		super();
		this.custo = custo;
		this.quantidade = quantidade;
		this.retorno = retorno;
		this.produto = produto;
	}






	public Retorno getRetorno() {
		return retorno;
	}

	public void setRetorno(Retorno retorno) {
		this.retorno = retorno;
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
