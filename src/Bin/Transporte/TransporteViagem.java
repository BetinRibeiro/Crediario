package Bin.Transporte;

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
@Table(name = "tansp_viagem")
public class TransporteViagem implements Comparable<TransporteViagem>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;
	private Integer kminicial;
	private Integer kmfinal;
	private float manutencao;
	@ManyToOne(optional = false)
	private Equipe equipe;
	@ManyToOne(optional = false)
	private Transporte transporte;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getKminicial() {
		return kminicial;
	}
	public void setKminicial(Integer kminicial) {
		this.kminicial = kminicial;
	}
	public Integer getKmfinal() {
		return kmfinal;
	}
	public void setKmfinal(Integer kmfinal) {
		this.kmfinal = kmfinal;
	}
	public float getManutencao() {
		return manutencao;
	}
	public void setManutencao(float manutencao) {
		this.manutencao = manutencao;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public TransporteViagem() {
		super();
	}
	public TransporteViagem(Integer kminicial, Integer kmfinal, float manutencao, Equipe equipe,
			Transporte transporte) {
		super();
		this.kminicial = kminicial;
		this.kmfinal = kmfinal;
		this.manutencao = manutencao;
		this.equipe = equipe;
		this.transporte = transporte;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	@Override
	public int compareTo(TransporteViagem o) {
		// TODO Auto-generated method stub
		return Integer.compare(o.getId(), getId());
	}
	
	
	
	
}
