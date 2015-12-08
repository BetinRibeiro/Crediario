package Bin.Devolucao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

import Bin.Endereco;
import Bin.Equipe.Equipe;

@Entity
@Table(name = "devolucao")
public class Devolucao {

	public Devolucao() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;
	@Column(name = "data_Devolucao", nullable = false)
	private Date data;
	private float custo;
	private float valor;
	private Endereco endereco;
	private String responsavel;
	private boolean recolhido;

	public boolean isRecolhido() {
		return recolhido;
	}

	public void setRecolhido(boolean recolhido) {
		this.recolhido = recolhido;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	@ManyToOne
	@JoinColumn(name = "equipe_id")
	private Equipe equipe;

	@OneToMany(mappedBy = "devolucao", fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE })
	private Set<ItemDevolucao> devolucao;

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

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Set<ItemDevolucao> getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Set<ItemDevolucao> devolucao) {
		this.devolucao = devolucao;
	}

	public Devolucao(Date data, float custo, float valor, Endereco endereco, String responsavel, boolean recolhido,
			Equipe equipe) {
		super();
		this.data = data;
		this.custo = custo;
		this.valor = valor;
		this.endereco = endereco;
		this.responsavel = responsavel;
		this.recolhido = recolhido;
		this.equipe = equipe;
	}

}
