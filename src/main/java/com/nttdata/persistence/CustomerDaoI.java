package com.nttdata.persistence;

import java.util.List;


/**
 * NTT DATA - DAO ENTIDAD CUSTOMER
 * 
 * @author dhraq
 *
 */

public interface CustomerDaoI extends CommonDaoI<Customer>{
	


	/**
	 * Método para buscar por nombre y apellidos
	 * 
	 * @param name
	 * @param surname
	 * @param secondSurname
	 * @return List<customer>
	 */
	public List<Customer> searchByCustomerFullName(String name, String surname, String secondSurname);



}

