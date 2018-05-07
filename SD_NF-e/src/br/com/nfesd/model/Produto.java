package br.com.nfesd.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Produto extends Model<Produto>{

	private static final long serialVersionUID = 8980430963437017436L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidproduto")
	@SequenceGenerator(name = "seqidproduto", sequenceName = "seqidproduto", allocationSize = 1)
	private Integer id;
	
	private String nome;
	
	private Integer codigo;
	
	private Double precoUni;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getPrecoUni() {
		return precoUni;
	}

	public void setPrecoUni(Double precoUni) {
		this.precoUni = precoUni;
	}
}