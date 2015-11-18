package Bin.Equipe;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Bin.Funcionario.Funcionario;
@Entity
@Table(name = "vendedor_equipe")
public class VendedorEquipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",columnDefinition = "serial", nullable = false)
	private Integer id;

	@ManyToOne
    @JoinColumn(name="equipe_id")
	private Equipe equipe;

	@ManyToOne(optional = true)
	private Funcionario vendedor;
	@Column(name = "venda")
	private float venda;
	@Column(name = "percentual_comissao_venda")
	private float percComissaoVenda;
	@Column(name = "vale_local")
	private float valeLocal;
	@Column(name = "vale_viagem")
	private float valeViagem;
	@Column(name = "quitado")
	private float quitado;
	@Column(name = "devolvido")
	private float devolvido;
	@Column(name = "perca")
	private float perca;
	@Column(name = "quitado_parcial")
	private float quitadoParcial;
	@Column(name = "perca_parcial")
	private float percaParcial;
	@Column(name = "percentual_comissao_cobranca")
	private float percComissaoCobrancao;
	@Column(name = "dinheiro_entrada")
	private float dinheiroEntrada;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public float getvenda() {
		return venda;
	}

	public void setvenda(float venda) {
		this.venda = venda;
	}

	public float getPercComissaoVenda() {
		return percComissaoVenda;
	}

	public void setPercComissaoVenda(float percComissaoVenda) {
		this.percComissaoVenda = percComissaoVenda;
	}

	public float getValeLocal() {
		return valeLocal;
	}

	public void setValeLocal(float valeLocal) {
		this.valeLocal = valeLocal;
	}

	public float getValeViagem() {
		return valeViagem;
	}

	public void setValeViagem(float valeViagem) {
		this.valeViagem = valeViagem;
	}

	public float getquitado() {
		return quitado;
	}

	public void setquitado(float quitado) {
		this.quitado = quitado;
	}

	public float getdevolvido() {
		return devolvido;
	}

	public void setdevolvido(float devolvido) {
		this.devolvido = devolvido;
	}

	public float getperca() {
		return perca;
	}

	public void setperca(float perca) {
		this.perca = perca;
	}

	public float getquitadoParcial() {
		return quitadoParcial;
	}

	public void setquitadoParcial(float quitadoParcial) {
		this.quitadoParcial = quitadoParcial;
	}

	public float getPercaParcial() {
		return percaParcial;
	}

	public void setPercaParcial(float percaParcial) {
		this.percaParcial = percaParcial;
	}

	public float getPercComissaoCobrancao() {
		return percComissaoCobrancao;
	}

	public void setPercComissaoCobrancao(float percComissaoCobrancao) {
		this.percComissaoCobrancao = percComissaoCobrancao;
	}

	
	
	
	

	//Getrs especiais 

	public float getVlrComissaoVenda() {
		//fator do percentual de comissão vezes o total da venda
		return venda*percComissaoVenda;

	}

	public float getSaldoVenda() {
		//o valor da comissão da venda menos a divida
		return getVlrComissaoVenda()-getVlrDivida();
	}

	private float getVlrDivida() {
//		divida é o vale pego antes de sair e o vale pego na viagem
		return valeLocal+valeViagem;
	}

	public float getVlrTotalRecebido() {
		//valor total recebido é o total quitado mais o quitado parcial
		return quitado+quitadoParcial;

	}

	public float getVlrTotalPerdido() {
		//perca mais perca pacial
		return perca+percaParcial;

	}

	public float getVlrComissaoCobranca() {
		//o total recebido da venda vezes o valor do percentual de comissão da cobrança
		return getVlrTotalRecebido()*percComissaoCobrancao;

	}

	public float getVlrSaldoQuitacao() {
		//o saldo de quitação menos o que foi recebido como comissão da venda
		return getVlrSaldoQuitacao()-getVlrComissaoVenda();
		

	}
	
	
	
	
	
	
}
