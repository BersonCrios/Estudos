package br.com.nfesd.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unitins.frame.model.Model;

@Entity
public class NotaFiscal extends Model<NotaFiscal> {

	private static final long serialVersionUID = -3889014035501953049L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidnotafiscal")
	@SequenceGenerator(name = "seqidnotafiscal", sequenceName = "seqidnotafiscal", allocationSize = 1)
	private Integer id;

	private Integer numero;

	@Temporal(TemporalType.DATE)
	private Date data;

	private Double tributos;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "NotaFiscalProduto", joinColumns = {
			@JoinColumn(name = "idnotafiscal", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idproduto", nullable = false) })
	private List<Produto> listaProduto;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getTributos() {
		return tributos;
	}

	public void setTributos(Double tributos) {
		this.tributos = tributos;
	}
	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public String getDataDaNotaFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		return sdf.format(this.getData());
	}
}
