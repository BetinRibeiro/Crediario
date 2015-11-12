package Bin.Funcionario;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Bin.Endereco;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;
	@Column(name = "nome",length=80)
	private String nome;
	@Column(name = "sobrenome",length=80)
	private String sobrenome;
	@Embedded
	private Endereco endereco;
	@Column(name = "telefone1",length=80)
	private long telefone1;
	@Column(name = "telefone2",length=80)
	private long telefone2;
	
	
	
	
	public Funcionario(String nome, String sobrenome, Endereco endereco, long telefone1, long telefone2) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public long getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(long telefone1) {
		this.telefone1 = telefone1;
	}
	public long getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(long telefone2) {
		this.telefone2 = telefone2;
	}
	
	
	
}
