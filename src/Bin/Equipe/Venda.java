package Bin.Equipe;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Bin.Despesa;

@Entity
@Table(name = "venda")
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;
	
	@Column(name = "data_saida")
	private Date dataSaida;
	
	@Column(name = "data_chegada")
	private Date dataChegada;
	
	@Column(name = "total_carradas")
	private float totalCarradas;
	
	@Column(name = "venda_praso")
	private float vendaPraso;
	
	
	@Column(name = "retorno")
	private float retorno;
	
	@Column(name = "adiantamento")
	private float adiantamento;
	
	@Column(name = "venda_vista")
	private float vendaVista;
	
	@Column(name = "entradas")
	private float entradas;
	
	
	@Column(name = "data_cobranca")
	private Date diaCobranca;
	
	@Column(name = "ultimo_dia")
	private Date ultimoDiaCobranca;
	
	@Column(name = "primeira_cidade")
	private String primeiraCidade;
	
	@Column(name = "estado")
	private String estado;
	
	@Embedded
	private Despesa despesa;
	
	@Column(name = "dinhe_devolvido")
	private float dinheiroDevolvido;

	@Column(name = "vale_caderno")
	private float valeCaderno;

	

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



	public float getTotalCarradas() {
		return totalCarradas;
	}



	public void setTotalCarradas(float totalCarradas) {
		this.totalCarradas = totalCarradas;
	}



	public float getVendaPraso() {
		return vendaPraso;
	}



	public void setVendaPraso(float vendaPraso) {
		this.vendaPraso = vendaPraso;
	}



	public float getRetorno() {
		return retorno;
	}



	public void setRetorno(float retorno) {
		this.retorno = retorno;
	}



	public float getAdiantamento() {
		return adiantamento;
	}



	public void setAdiantamento(float adiantamento) {
		this.adiantamento = adiantamento;
	}



	public float getVendaVista() {
		return vendaVista;
	}



	public void setVendaVista(float vendaVista) {
		this.vendaVista = vendaVista;
	}



	public float getEntradas() {
		return entradas;
	}



	public void setEntradas(float entradas) {
		this.entradas = entradas;
	}



	public Date getDiaCobranca() {
		return diaCobranca;
	}



	public void setDiaCobranca(Date diaCobranca) {
		this.diaCobranca = diaCobranca;
	}



	public Date getUltimoDiaCobranca() {
		return ultimoDiaCobranca;
	}



	public void setUltimoDiaCobranca(Date ultimoDiaCobranca) {
		this.ultimoDiaCobranca = ultimoDiaCobranca;
	}



	public String getPrimeiraCidade() {
		return primeiraCidade;
	}



	public void setPrimeiraCidade(String primeiraCidade) {
		this.primeiraCidade = primeiraCidade;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public Despesa getDespesa() {
		return despesa;
	}



	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}



	public float getDinheiroDevolvido() {
		return dinheiroDevolvido;
	}



	public void setDinheiroDevolvido(float dinheiroDevolvido) {
		this.dinheiroDevolvido = dinheiroDevolvido;
	}



	public float getValeCaderno() {
		return valeCaderno;
	}



	public void setValeCaderno(float valeCaderno) {
		this.valeCaderno = valeCaderno;
	}



	public Venda(Date dataSaida, Date dataChegada, float totalCarradas, float vendaPraso, float retorno,
			float adiantamento, float vendaVista, float entradas, Date diaCobranca, Date ultimoDiaCobranca,
			String primeiraCidade, String estado, Despesa despesa, float dinheiroDevolvido, float valeCaderno) {
		super();
		this.dataSaida = dataSaida;
		this.dataChegada = dataChegada;
		this.totalCarradas = totalCarradas;
		this.vendaPraso = vendaPraso;
		this.retorno = retorno;
		this.adiantamento = adiantamento;
		this.vendaVista = vendaVista;
		this.entradas = entradas;
		this.diaCobranca = diaCobranca;
		this.ultimoDiaCobranca = ultimoDiaCobranca;
		this.primeiraCidade = primeiraCidade;
		this.estado = estado;
		this.despesa = despesa;
		this.dinheiroDevolvido = dinheiroDevolvido;
		this.valeCaderno = valeCaderno;
	}



	public Venda() {
		super();
	}
	

}
