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
	
	
	@OneToMany(mappedBy="equipe", fetch = FetchType.EAGER)
	private Set<TransporteViagem> traspViagem;
	
	@OneToMany(mappedBy="equipe", fetch = FetchType.EAGER)
	private Set<Deposito> deposito;

	@OneToMany(mappedBy="equipe", fetch = FetchType.EAGER)
	private Set<Carrada> carrada;
	
	@OneToMany(mappedBy="equipe", fetch = FetchType.EAGER)
	private Set<VendedorEquipe> vendedor;
	
	@OneToMany(mappedBy="equipe", fetch = FetchType.EAGER)
	private Set<Retorno> retorno;
	
	//estruturas nna qual a equipe se divide
	
	@ManyToOne(optional = true)
	private Venda venda;
	
	@ManyToOne(optional = true)
	private Cobranca cobranca;

	@ManyToOne(optional = true)
	private ChefeEquipe chefe;




	public Equipe(String titulo, Set<TransporteViagem> traspViagem, Set<Deposito> deposito, Set<Carrada> carrada,
			Set<VendedorEquipe> vendedor, Set<Retorno> retorno, Venda venda, Cobranca cobranca, ChefeEquipe chefe) {
		super();
		this.titulo = titulo;
		this.traspViagem = traspViagem;
		this.deposito = deposito;
		this.carrada = carrada;
		this.vendedor = vendedor;
		this.retorno = retorno;
		this.venda = venda;
		this.cobranca = cobranca;
		this.chefe = chefe;
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


	public Set<TransporteViagem> getTraspViagem() {
		return traspViagem;
	}


	public void setTraspViagem(Set<TransporteViagem> traspViagem) {
		this.traspViagem = traspViagem;
	}


	public Set<Deposito> getDeposito() {
		return deposito;
	}


	public void setDeposito(Set<Deposito> deposito) {
		this.deposito = deposito;
	}


	public Set<Carrada> getCarrada() {
		return carrada;
	}


	public void setCarrada(Set<Carrada> carrada) {
		this.carrada = carrada;
	}


	public Set<VendedorEquipe> getVendedor() {
		return vendedor;
	}


	public void setVendedor(Set<VendedorEquipe> vendedor) {
		this.vendedor = vendedor;
	}


	public Set<Retorno> getRetorno() {
		return retorno;
	}


	public void setRetorno(Set<Retorno> retorno) {
		this.retorno = retorno;
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


	public ChefeEquipe getChefe() {
		return chefe;
	}


	public void setChefe(ChefeEquipe chefe) {
		this.chefe = chefe;
	}


	public Equipe() {
		super();
	}
	
	
	

}
