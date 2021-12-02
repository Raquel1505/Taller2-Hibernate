package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Dual - Hibernate - Taller2
 * 
 * @author dhraq
 * 
 *         Entidad de tabla NTTDATA_CUSTOMER
 */

@Entity
@Table(name = "T_CUSTOMER")

public class Customer extends AbstractEntity implements Serializable{

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador numérico (PK) */
	private Long customerId;

	/** Nombre del cliente */
	private String name;

	/** Primer apellido del cliente */
	private String surname;

	/** Segundo apellido del cliente */
	private String secondSurname;

	/** DNI del cliente (FK) */
	private String dni;
	
	/** Listado de contratos asocioados al cliente */
	private List<Contracts> contractsList;
	

	/**
	 * @return customerId
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param setCustomerId
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return name
	 */
	@Column(name = "C_NAME_CUSTOMER")
	public String getName() {
		return name;
	}

	/**
	 * @param setName
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return surname
	 */
	@Column(name = "C_SURNAME_CUSTOMER")
	public String getSurname() {
		return surname;
	}

	/**
	 * @param setSurname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return secondSurname
	 */
	@Column(name = "C_SECONDSURNAME_CUSTOMER")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * @param setSecondSurname
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * @return secondSurname
	 */

	@Column(name = "C_DNI_CUSTOMER", nullable = false, unique = true)
	public String getDni() {
		return dni;
	}

	/**
	 * @param setSecondSurname
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

	/**
	 * @return the contractsList
	 */
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	public List<Contracts> getContractsList() {
		return contractsList;
	}

	/**
	 * @param contractsList the contractsList to set
	 */
	public void setContractsList(List<Contracts> contractsList) {
		this.contractsList = contractsList;
	}


	/**
	 * Método para responder a que hijo es
	 * 
	 * @return Customer.class
	 */
	@Transient
	public Class<?>getClase(){
		return Customer.class;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", surname=" + surname + ", secondSurname="
				+ secondSurname + ", dni=" + dni + "]";
	}
	
	
	

}
