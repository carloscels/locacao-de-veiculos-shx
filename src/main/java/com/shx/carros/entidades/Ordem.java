package com.shx.carros.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shx.carros.entidades.enums.OrdemdeStatus;




@Entity
public class Ordem implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd'T'HH-mm-ss'Z'", timezone = "GMT")
	private Instant alugar;
	
	private Integer ordemStatus;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
	

	@OneToMany(mappedBy = "id.ordem")
	private Set<OrdemProduto> itens = new HashSet<>();

	@OneToOne(mappedBy = "ordem", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Ordem() {
		
	}


	public Ordem(Long id,Instant alugar, OrdemdeStatus ordemStatus, Usuario cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.alugar = alugar;
		setOrdemStatus(ordemStatus);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Instant getAlugado() {
		return alugar;
	}


	public void setAlugado(Instant alugar) {
		this.alugar = alugar;
	}


	public OrdemdeStatus getOrdemStatus() {
		return OrdemdeStatus.valueOf(ordemStatus) ;
	}


	public void setOrdemStatus(OrdemdeStatus ordemStatus) {
		if (ordemStatus != null) {
		this.ordemStatus = ordemStatus.getCode();
		}
	}


	public Usuario getCliente() {
		return cliente;
	}


	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	public Set<OrdemProduto> getItems() {
		return itens;
	}
	
	public double getTotal() {
		double soma = 0.0;
		for(OrdemProduto x : itens) {
			soma += x.getSubTotal();
		}
		return soma;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordem other = (Ordem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	
}
