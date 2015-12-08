package Bin.Equipe;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Bin.DespExtra;
import Bin.ReceitaExtra;
import Bin.Devolucao.Devolucao;
import Bin.Funcionario.ChefeEquipe;
import Bin.Mercadoria.Carrada;
import Bin.Retorno.Retorno;
import Bin.Transporte.TransporteViagem;

@Entity
@Table(name = "equipe")
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private Integer id;

	@Column(name = "titulo", length = 80)
	private String titulo;

	@ManyToOne(optional = true)
	private ChefeEquipe chefe;

	@ManyToOne(optional = true)
	private Venda venda;

	@ManyToOne(optional = true)
	private Cobranca cobranca;

	@OneToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
	private Set<TransporteViagem> traspViagem;

	@Column(name = "valor_manutencao")
	private float valorManutencao;

	@OneToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
	private Set<Deposito> deposito;

	@Column(name = "total_depositos")
	private float totalDepositos;
	
	@Column(name = "meta_venda")
	private float metaVenda;

	@OneToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
	private Set<Carrada> carrada;

	@Column(name = "preco_carradas")
	private float precoCarradas;

	@Column(name = "custo_carradas")
	private float custoCarradas;

	@Column(name = "valor_fretes")
	private float valorFretes;

	@OneToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
	private Set<VendedorEquipe> vendedor;
	
	@Column(name = "total_divida_vendedores")
	private float dividaVendedores;

	@Column(name = "total_vales_vendedores")
	private float valesVendedores;

	@Column(name = "total_comissao_vendedores")
	private float comissaoVendedores;

	@Column(name = "total_fichas")
	private float totalFichas;

	@OneToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
	private Set<Retorno> retorno;

	@Column(name = "preco_retornos")
	private float precoRetornos;

	@Column(name = "custo_retornos")
	private float custoRetornos;

	@OneToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
	private Set<Devolucao> devolucao;

	@Column(name = "preco_devolucao")
	private float precoDevolucao;

	@Column(name = "custo_devolucao")
	private float custoDevolucao;

	@OneToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
	private Set<DespExtra> despExtra;
	
	@Column(name = "total_desp_extra")
	private float totalDespExtra;
	
	@OneToMany(mappedBy = "equipe", fetch = FetchType.EAGER)
	private Set<ReceitaExtra> receitaExtra;
	
	@Column(name = "total_receita_extra")
	private float totalreceitaExtra;
	
	@Column(name = "lucro_bruta")
	private float lucroBruto;

	@Column(name = "lucro_liquido")
	private float lucroLiquido;
	
	@Column(name = "total_desp_local")
	private float totalDespLocal;
	
	@Column(name = "saldo_neg_vendedor")
	private float saldoNegVendedores;



	


	public float getSaldoNegVendedores() {
		return saldoNegVendedores;
	}


	public void setSaldoNegVendedores(float saldoNegVendedores) {
		this.saldoNegVendedores = saldoNegVendedores;
	}


	public Equipe(String titulo, ChefeEquipe chefe, Venda venda, Cobranca cobranca, Set<TransporteViagem> traspViagem,
			float valorManutencao, Set<Deposito> deposito, float totalDepositos, float metaVenda, Set<Carrada> carrada,
			float precoCarradas, float custoCarradas, float valorFretes, Set<VendedorEquipe> vendedor,
			float dividaVendedores, float valesVendedores, float comissaoVendedores, float totalFichas,
			Set<Retorno> retorno, float precoRetornos, float custoRetornos, Set<Devolucao> devolucao,
			float precoDevolucao, float custoDevolucao, Set<DespExtra> despExtra, float totalDespExtra,
			Set<ReceitaExtra> receitaExtra, float totalreceitaExtra, float lucroBruto, float lucroLiquido,
			float totalDespLocal,float saldoNegVend) {
		super();
		this.titulo = titulo;
		this.chefe = chefe;
		this.venda = venda;
		this.cobranca = cobranca;
		this.traspViagem = traspViagem;
		this.valorManutencao = valorManutencao;
		this.deposito = deposito;
		this.totalDepositos = totalDepositos;
		this.metaVenda = metaVenda;
		this.carrada = carrada;
		this.precoCarradas = precoCarradas;
		this.custoCarradas = custoCarradas;
		this.valorFretes = valorFretes;
		this.vendedor = vendedor;
		this.dividaVendedores = dividaVendedores;
		this.valesVendedores = valesVendedores;
		this.comissaoVendedores = comissaoVendedores;
		this.totalFichas = totalFichas;
		this.retorno = retorno;
		this.precoRetornos = precoRetornos;
		this.custoRetornos = custoRetornos;
		this.devolucao = devolucao;
		this.precoDevolucao = precoDevolucao;
		this.custoDevolucao = custoDevolucao;
		this.despExtra = despExtra;
		this.totalDespExtra = totalDespExtra;
		this.receitaExtra = receitaExtra;
		this.totalreceitaExtra = totalreceitaExtra;
		this.lucroBruto = lucroBruto;
		this.lucroLiquido = lucroLiquido;
		this.totalDespLocal = totalDespLocal;
		this.saldoNegVendedores = saldoNegVend;
	}


	public float getTotalDespLocal() {
		return totalDespLocal;
	}


	public void setTotalDespLocal(float totalDespLocal) {
		this.totalDespLocal = totalDespLocal;
	}


	


	public float getLucroBruto() {
		return lucroBruto;
	}


	public void setLucroBruto(float lucroBruto) {
		this.lucroBruto = lucroBruto;
	}


	public float getLucroLiquido() {
		return lucroLiquido;
	}


	public void setLucroLiquido(float lucroLiquido) {
		this.lucroLiquido = lucroLiquido;
	}


	public float getMetaVenda() {
		return metaVenda;
	}


	public void setMetaVenda(float metaVenda) {
		this.metaVenda = metaVenda;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public ChefeEquipe getChefe() {
		return chefe;
	}


	public void setChefe(ChefeEquipe chefe) {
		this.chefe = chefe;
	}


	public Venda getVenda() {
		return venda;
	}


	public void setVenda(Venda venda) {
		this.venda = venda;
	}


	public Cobranca getCobranca() {
		return cobranca;
	}


	public void setCobranca(Cobranca cobranca) {
		this.cobranca = cobranca;
	}


	public Set<TransporteViagem> getTraspViagem() {
		return traspViagem;
	}


	public void setTraspViagem(Set<TransporteViagem> traspViagem) {
		this.traspViagem = traspViagem;
	}


	public float getValorManutencao() {
		return valorManutencao;
	}
	
	public float getDespLocal() {
		return saldoNegVendedores+valorFretes+valorManutencao;
	}


	public void setValorManutencao(float valorManutencao) {
		this.valorManutencao = valorManutencao;
	}


	public Set<Deposito> getDeposito() {
		return deposito;
	}


	public void setDeposito(Set<Deposito> deposito) {
		this.deposito = deposito;
	}


	public float getTotalDepositos() {
		return totalDepositos;
	}


	public void setTotalDepositos(float totalDepositos) {
		this.totalDepositos = totalDepositos;
	}


	public Set<Carrada> getCarrada() {
		return carrada;
	}


	public void setCarrada(Set<Carrada> carrada) {
		this.carrada = carrada;
	}


	public float getPrecoCarradas() {
		return precoCarradas;
	}


	public void setPrecoCarradas(float precoCarradas) {
		this.precoCarradas = precoCarradas;
	}


	public float getCustoCarradas() {
		return custoCarradas;
	}


	public void setCustoCarradas(float custoCarradas) {
		this.custoCarradas = custoCarradas;
	}


	public float getValorFretes() {
		return valorFretes;
	}


	public void setValorFretes(float valorFretes) {
		this.valorFretes = valorFretes;
	}


	public Set<VendedorEquipe> getVendedor() {
		return vendedor;
	}


	public void setVendedor(Set<VendedorEquipe> vendedor) {
		this.vendedor = vendedor;
	}


	public float getDividaVendedores() {
		return dividaVendedores;
	}


	public void setDividaVendedores(float dividaVendedores) {
		this.dividaVendedores = dividaVendedores;
	}


	public float getValesVendedores() {
		return valesVendedores;
	}


	public void setValesVendedores(float valesVendedores) {
		this.valesVendedores = valesVendedores;
	}


	public float getComissaoVendedores() {
		return comissaoVendedores;
	}


	public void setComissaoVendedores(float comissaoVendedores) {
		this.comissaoVendedores = comissaoVendedores;
	}


	public float getTotalFichas() {
		return totalFichas;
	}


	public void setTotalFichas(float totalFichas) {
		this.totalFichas = totalFichas;
	}


	public Set<Retorno> getRetorno() {
		return retorno;
	}


	public void setRetorno(Set<Retorno> retorno) {
		this.retorno = retorno;
	}


	public float getPrecoRetornos() {
		return precoRetornos;
	}


	public void setPrecoRetornos(float precoRetornos) {
		this.precoRetornos = precoRetornos;
	}


	public float getCustoRetornos() {
		return custoRetornos;
	}


	public void setCustoRetornos(float custoRetornos) {
		this.custoRetornos = custoRetornos;
	}


	public Set<Devolucao> getDevolucao() {
		return devolucao;
	}


	public void setDevolucao(Set<Devolucao> devolucao) {
		this.devolucao = devolucao;
	}


	public float getPrecoDevolucao() {
		return precoDevolucao;
	}


	public void setPrecoDevolucao(float precoDevolucao) {
		this.precoDevolucao = precoDevolucao;
	}


	public float getCustoDevolucao() {
		return custoDevolucao;
	}


	public void setCustoDevolucao(float custoDevolucao) {
		this.custoDevolucao = custoDevolucao;
	}


	public Set<DespExtra> getDespExtra() {
		return despExtra;
	}


	public void setDespExtra(Set<DespExtra> despExtra) {
		this.despExtra = despExtra;
	}


	public float getTotalDespExtra() {
		return totalDespExtra;
	}


	public void setTotalDespExtra(float totalDespExtra) {
		this.totalDespExtra = totalDespExtra;
	}


	public Set<ReceitaExtra> getReceitaExtra() {
		return receitaExtra;
	}


	public void setReceitaExtra(Set<ReceitaExtra> receitaExtra) {
		this.receitaExtra = receitaExtra;
	}


	public float getTotalreceitaExtra() {
		return totalreceitaExtra;
	}


	public void setTotalreceitaExtra(float totalreceitaExtra) {
		this.totalreceitaExtra = totalreceitaExtra;
	}


	public Equipe() {
		super();
	}

	

}
