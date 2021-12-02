package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Customer;

/**
 * NTT DATA - INTERFAZ CUSTOMER SERVICE
 * 
 * @author dhraq
 *
 */
public interface CustomerServiceI {
	
	/**
	 * Método para crear nuevo cliente
	 * 
	 * @param newCustomer
	 * @return newCustomer
	 */
	public Long insertNewCustomer(Customer newCustomer);
	
	/**
	 * Método para borrar cliente
	 * 
	 * @param removeCustomer
	 */
	public void deleteCustomer(Customer removeCustomer);
	
	/**
	 * Método para buscar por ID de cliente
	 * @param customerId
	 * @return customerId
	 */
	public Customer searchById(Long customerId);
	
	/**
	 * Método para buscar por nombre y apellidos de cliente
	 * 
	 * @param name
	 * @param surname
	 * @param secondSurname
	 * @return List<Customer>
	 */
	public List<Customer> searchByName(String name, String surname, String secondSurname);
	
	/**
	 * Método para actualizar cliente
	 * 
	 * @param updateCustomer
	 */
	public void updateCustomer(Customer updateCustomer);
	
	/**
	 * Método para buscar todos los clientes
	 * 
	 * List<Customer>
	 * @return
	 */
	public List<Customer> findeAllPCustomerFromSystem();	


}
