package com.shx.carros.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shx.carros.entidades.pk.OrdemdeProdutopk;

@Entity
public class OrdemProduto implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrdemdeProdutopk id = new OrdemdeProdutopk();
	 
	private Integer quantidade;
	private Double preco;
	
	public OrdemProduto() {
		
	}

	public OrdemProduto(Ordem ordem, Produto produto,Integer quantidade, Double preco) {
		super();
		id.setOrdem(ordem);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	@JsonIgnore
	public Ordem getOrdem() {
		return id.getOrdem();
	}
	
	public void setOrdem(Ordem ordem) {
		id.setOrdem(ordem);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	public void setProduto(Produto produto) {
		id.setProduto(produto);;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public double getSubTotal() {
		return preco*quantidade;
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
		OrdemProduto other = (OrdemProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}