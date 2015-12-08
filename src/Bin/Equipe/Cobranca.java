package Bin.Equipe;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Bin.Despesa;
import Bin.Funcionario.Cobrador;

@Entity
@Table(name = "cobranca")
public class Cobranca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;
	
	@Column(name = "data_saida")
	private Date dataSaida;
	
	
	@Column(name = "data_chegada")
	private Date dataChegada;
	
	@Column(name = "valor_diaria")
	private float valorDiaria;
	
	@ManyToOne(optional = true)
	private Cobrador cobrador;
	
	@Column(name = "quitado")
	private float quitado;
	
	@Column(name = "devolvido")
	private float devolvido;
	
	@Column(name = "perdido")
	private float perdido;
	
	@Column(name = "recebido_parcial")
	private float recebidoParcial;
	
	@Column(name = "perdido_parcial")
	private float perdidoParcial;
	
	@Column(name = "adiantamento")
	private float adiantamento;
	
	@Embedded
	private Despesa despesa;
	
	@Column(name = "depositos")
	private float depositos;
	
	@Column(name = "dinhe_devolvido")
	private float dinheiroDevolvido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public float getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Cobrador getCobrador() {
		return cobrador;
	}

	public void setCobrador(Cobrador cobrador) {
		this.cobrador = cobrador;
	}

	public float getQuitado() {
		return quitado;
	}
	public float getRecebidoTotal() {
		return quitado+recebidoParcial;
	}
	
	public float getPerdidoTotal() {
		return perdido+perdidoParcial;
	}

	public void setQuitado(float quitado) {
		this.quitado = quitado;
	}

	public float getDevolvido() {
		return devolvido;
	}

	public void setDevolvido(float devolvido) {
		this.devolvido = devolvido;
	}

	public float getPerdido() {
		return perdido;
	}

	public void setPerdido(float perdido) {
		this.perdido = perdido;
	}

	public float getRecebidoParcial() {
		return recebidoParcial;
	}

	public void setRecebidoParcial(float recebidoParcial) {
		this.recebidoParcial = recebidoParcial;
	}

	public float getPerdidoParcial() {
		return perdidoParcial;
	}

	public void setPerdidoParcial(float perdidoParcial) {
		this.perdidoParcial = perdidoParcial;
	}

	public float getAdiantamento() {
		return adiantamento;
	}

	public void setAdiantamento(float adiantamento) {
		this.adiantamento = adiantamento;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public float getDepositos() {
		return depositos;
	}

	public void setDepositos(float depositos) {
		this.depositos = depositos;
	}

	public float getDinheiroDevolvido() {
		return dinheiroDevolvido;
	}

	public void setDinheiroDevolvido(float dinheiroDevolvido) {
		this.dinheiroDevolvido = dinheiroDevolvido;
	}

	public Cobranca(Date dataSaida, Date dataChegada, float valorDiaria, Cobrador cobrador, float quitado,
			float devolvido, float perdido, float recebidoParcial, float perdidoParcial, float adiantamento,
			Despesa despesa, float depositos, float dinheiroDevolvido) {
		super();
		this.dataSaida = dataSaida;
		this.dataChegada = dataChegada;
		this.valorDiaria = valorDiaria;
		this.cobrador = cobrador;
		this.quitado = quitado;
		this.devolvido = devolvido;
		this.perdido = perdido;
		this.recebidoParcial = recebidoParcial;
		this.perdidoParcial = perdidoParcial;
		this.adiantamento = adiantamento;
		this.despesa = despesa;
		this.depositos = depositos;
		this.dinheiroDevolvido = dinheiroDevolvido;
	}

	public Cobranca() {
		super();
	}
	
	
	
	
}
