package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Dual - Hibernate - Taller2
 * 
 * @author dhraq
 * 
 *         Entidad de tabla NTTDATA_CONTRACTS
 */



@Entity
@Table(name="T_CONTRACTS")
public class Contracts extends AbstractEntity implements Serializable{
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Idedntificador numérico (PK) */
	private Long contractsId;
	
	/** Fecha vigencia */
	private Date effectiveDate;
	
	/** Fecha caducidad */
	private Date expirationDate;
	
	/** Precio mensual*/
	private String price;
	
	/**Cliente(FK) */
	private Customer customer;

	/**
	 * @return the contractsId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getContractsId() {
		return contractsId;
	}

	/**
	 * @param contractsId the contractsId to set
	 */
	public void setContractsId(Long contractsId) {
		this.contractsId = contractsId;
	}

	/**
	 * @return the effectiveDate
	 */
	@Column(name="C_DATE_EFFECTIVE")
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the expirationDate
	 */
	@Column(name="C_DATE_EXPIRATION")
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the price
	 */
	@Column(name="C_PRICE_CONTRACTS")

	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the customer
	 */
	@ManyToOne
	@JoinColumn(name="ID_CUSTOMER_FK")
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * Método para responder a que hijo es
	 * 
	 * @return Contracts.class
	 */
	@Transient
	public Class<?>getClase(){
		return Contracts.class;
	}

	@Override
	public String toString() {
		return "Contracts [contractsId=" + contractsId + ", effectiveDate=" + effectiveDate + ", expirationDate="
				+ expirationDate + ", price=" + price + ", customer=" + customer + "]";
	}
	

	
}
