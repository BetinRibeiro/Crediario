package Bin;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "despesa")
public class Despesa {
	@Column(name = "gasolina", length = 3)
	private float gasolina;
	
	@Column(name = "diesel", length = 100)
	private float diesel;
	
	@Column(name = "desp_com_nota", length = 50)
	private float despComNota;
	
	@Column(name = "desp_sem_nota", length = 50)
	private float despSemNota;
	
	@Column(name = "diarias", length = 2)
	private float diarias;
	
	@Column(name = "manutencao", length = 9)
	private float manutencao;

	public float getGasolina() {
		return gasolina;
	}

	public void setGasolina(float gasolina) {
		this.gasolina = gasolina;
	}

	public float getDiesel() {
		return diesel;
	}

	public void setDiesel(float diesel) {
		this.diesel = diesel;
	}

	public float getDespComNota() {
		return despComNota;
	}

	public void setDespComNota(float despComNota) {
		this.despComNota = despComNota;
	}

	public float getDespSemNota() {
		return despSemNota;
	}

	public void setDespSemNota(float despSemNota) {
		this.despSemNota = despSemNota;
	}

	public float getDiarias() {
		return diarias;
	}

	public void setDiarias(float diarias) {
		this.diarias = diarias;
	}

	public float getManutencao() {
		return manutencao;
	}

	public void setManutencao(float manutencao) {
		this.manutencao = manutencao;
	}

	public Despesa(float gasolina, float diesel, float despComNota, float despSemNota, float diarias,
			float manutencao) {
		super();
		this.gasolina = gasolina;
		this.diesel = diesel;
		this.despComNota = despComNota;
		this.despSemNota = despSemNota;
		this.diarias = diarias;
		this.manutencao = manutencao;
	}

	public Despesa() {
		super();
	}
	
	
	
	
	
	
	
}