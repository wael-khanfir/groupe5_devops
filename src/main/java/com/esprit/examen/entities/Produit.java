package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorieProduit == null) ? 0 : categorieProduit.hashCode());
		result = prime * result + ((codeProduit == null) ? 0 : codeProduit.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((dateDerniereModification == null) ? 0 : dateDerniereModification.hashCode());
		result = prime * result + ((detailFacture == null) ? 0 : detailFacture.hashCode());
		result = prime * result + ((idProduit == null) ? 0 : idProduit.hashCode());
		result = prime * result + ((libelleProduit == null) ? 0 : libelleProduit.hashCode());
		result = prime * result + Float.floatToIntBits(prix);
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
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
		Produit other = (Produit) obj;
		if (categorieProduit == null) {
			if (other.categorieProduit != null)
				return false;
		} else if (!categorieProduit.equals(other.categorieProduit))
			return false;
		if (codeProduit == null) {
			if (other.codeProduit != null)
				return false;
		} else if (!codeProduit.equals(other.codeProduit))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (dateDerniereModification == null) {
			if (other.dateDerniereModification != null)
				return false;
		} else if (!dateDerniereModification.equals(other.dateDerniereModification))
			return false;
		if (detailFacture == null) {
			if (other.detailFacture != null)
				return false;
		} else if (!detailFacture.equals(other.detailFacture))
			return false;
		if (idProduit == null) {
			if (other.idProduit != null)
				return false;
		} else if (!idProduit.equals(other.idProduit))
			return false;
		if (libelleProduit == null) {
			if (other.libelleProduit != null)
				return false;
		} else if (!libelleProduit.equals(other.libelleProduit))
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getLibelleProduit() {
		return libelleProduit;
	}

	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}

	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Set<DetailFacture> getDetailFacture() {
		return detailFacture;
	}

	public void setDetailFacture(Set<DetailFacture> detailFacture) {
		this.detailFacture = detailFacture;
	}

	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prix;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
	private Date dateDerniereModification;
	@ManyToOne
	@JsonIgnore
	private Stock stock;
	@OneToMany(mappedBy = "produit")
	@JsonIgnore
	private Set<DetailFacture> detailFacture;
	@ManyToOne
	@JsonIgnore
	private CategorieProduit categorieProduit;

	public Produit(String codeProduit, String libelleProduit, float prix, Date date, Date date2) {
		super();
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prix = prix;
	}

	

}
