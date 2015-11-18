package Bin.Equipe;

import java.util.Date;
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

import Bin.Despesa;
import Bin.Funcionario.Funcionario;
import Bin.Mercadoria.Carrada;

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
	private Funcionario chefe;

	@Column(name = "percentual_chefe")
	private float percentualChefe;
	
	@Column(name = "vale_chefe")
	private float valeChefe;

	@OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
	private Set<Carrada> carrada;

	// @ManyToOne(optional = true)
	// private Carrada retorno;
	// @Column(name = "data_saida")
	// private Date dataSaida;
	// @Column(name = "data_chegada")
	// private Date dataChegada;
	// @Column(name = "data_cobranca")
	// private Date dataCobranca;
	// @Column(name = "data_ultima")
	// private Date ultimoDiaCobranca;
	// @Column(name = "dias_uteis")
	// private Integer diasUteisVenda;
	// @Column(name = "adiantamento")
	// private float adiantamento;
	// @Column(name = "dinheiro_emprestado")
	// private float dinheiroEmprestado;
	//// private float entradaPromissoria;
	// @Column(name = "dinheiro_devolvido")
	// private float dinheiroDevolvido;
	//

	// @OneToMany(mappedBy = "equipe", fetch=FetchType.LAZY)
	// private Set<VendedorEquipe> vendedorEquipe;
	//
	// private Set<Despesa> despesa;

	public Equipe(String titulo, Funcionario chefe, float percentualChefe) {
		super();
		this.titulo = titulo;
		this.chefe = chefe;
		this.percentualChefe = percentualChefe;
	}

	public Equipe() {
		super();
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

	public Funcionario getChefe() {
		return chefe;
	}

	public void setChefe(Funcionario chefe) {
		this.chefe = chefe;
	}

	public float getPercentualChefe() {
		return percentualChefe;
	}

	public void setPercentualChefe(float percentualChefe) {
		this.percentualChefe = percentualChefe;
	}

	public Set<Carrada> getCarradas() {
		return carrada;
	}

	public void setCarradas(Set<Carrada> carrada) {
		this.carrada = carrada;
	}

	public float getValeChefe() {
		return valeChefe;
	}

	public void setValeChefe(float valeChefe) {
		this.valeChefe = valeChefe;
	}

}
