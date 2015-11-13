package Bin.Produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;
	@Column(name = "descricao",length=80)
	private String descricao;
	@Column(name = "estoqueMin",length=10)
	private float estoqueMin;
	@Column(name = "preco",length=10)
	private float preco;
	@Column(name = "custo",length=10)
	private float custo;
	@Column(name = "quantidade",length=10)
	private float quantidade;
	
	

	public Produto() {
		super();
	}
	public Produto(String descricao, float estoqueMin, float preco) {
		super();
		this.descricao = descricao;
		this.estoqueMin = estoqueMin;
		this.preco = preco;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getEstoqueMin() {
		return estoqueMin;
	}
	public void setEstoqueMin(float estoqueMin) {
		this.estoqueMin = estoqueMin;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
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
	
	
	

}
