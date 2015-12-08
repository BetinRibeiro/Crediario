package Bin;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Bin.Equipe.Equipe;

@Entity
@Table(name = "deso_ext")
public class DespExtra implements Comparable<DespExtra>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",columnDefinition = "serial", nullable = false)
	private Integer id;
	private String descricao;
	private float valor;
	private Date data;
	@ManyToOne(optional = false)
	private Equipe equipe;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public DespExtra(String descricao, float valor, Date data, Equipe equipe) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.equipe = equipe;
	}
	public DespExtra() {
		super();
	}
	@Override
	public int compareTo(DespExtra des) {
		// TODO Auto-generated method stub
		return Integer.compare(des.getId(), getId());
	}
	
	
	
}
