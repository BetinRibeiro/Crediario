package Bin.Equipe;

import java.util.Date;
import java.util.Set;

import javax.persistence.ManyToOne;

import Bin.Funcionario.Funcionario;
import Bin.Mercadoria.Carrada;

public class Equipe {
	private Integer id;
	@ManyToOne(optional = false)
	private Funcionario chefe;
	private String titulo;
	private Date dataSaida;
	private Date dataChegada;
	private Date cobranca;
	private Date ultimoDiaCobranca;
	private Integer diasUteisVenda;
	private Set<Carrada> carradas;
	private Set<VendedorEquipe> vendedorEquipe;
	private Carrada retorno;
	private float adiantamento;

}
