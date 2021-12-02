package com.nttdata.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Customer;
import com.nttdata.persistence.CustomerDaoI;
import com.nttdata.persistence.CustomerDaoImpl;

/**
 * NTT DATA - IMPLEMENTACION CUSTOMER SERVICE INTERFAZ
 * 
 * @author dhraq
 *
 */
public class CustomerServiceImpl implements CustomerServiceI {

	/** DAO: T_CUSTOMER */
	private CustomerDaoI customerDao;
	
	/**
	 * Constructor
	 */
	public CustomerServiceImpl(final Session session) {
		this.customerDao = new CustomerDaoImpl(session);
	}

	@Override
	public Long insertNewCustomer(Customer newCustomer) {
		
		//Añadido de cliente
		final Long idCustomer = customerDao.insert(newCustomer);
		return idCustomer;
	}

	@Override
	public void deleteCustomer(Customer removeCustomer) {
		
		// Verificación de nulidad y existencia.
		if (removeCustomer != null) {

			// Eliminación del contrato.
			customerDao.delete(removeCustomer);
		}
	}

	@Override
	public Customer searchById(Long customerId) {
		//Buscar por ID
		return customerDao.searchById(customerId);
	}

	@Override
	public List<Customer> searchByName(String name, String surname, String secondSurname) {
		//Buscar por nombre y apellidos
		return customerDao.searchByCustomerFullName(name, surname, secondSurname);
	}

	@Override
	public void updateCustomer(Customer updateCustomer) {
		
		// Verificación de nulidad y existencia.
		if (updateCustomer != null && updateCustomer.getCustomerId() != null) {

			// Actualización del contrato.
			customerDao.update(updateCustomer);
		}	
	}
	
	@Override
	public List<Customer> findeAllPCustomerFromSystem(){
		return customerDao.searchAll();
	}
}
