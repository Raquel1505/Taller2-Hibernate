package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * NTT DATA - SUPERCLASE PARA ENTIDADES
 * 
 * @author dhraq
 *
 */

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Auditoría - Usuario que actualiza el registro */
	private Date updateDate;

	/** Auditoría - Fecha en que se actualiza el registro */
	private String updateUser;

	/**
	 * @return the updateDate
	 */
	@Column(name = "C_UPDATE_DATE", nullable = false)
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the updateUser
	 */
	@Column(name = "C_UPDATE_USER", nullable = false)
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
