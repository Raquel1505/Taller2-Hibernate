package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Contracts;

/**
 * NTT DATA - INTERFAZ CONTRACTS SERVICE
 * 
 * @author dhraq
 *
 */
public interface ContractsServiceI {
	

	/**
	 * Método para eliminar contratos
	 * 
	 * @param newContracts
	 */
	public void deleteContracts(Contracts removeContracts);
	

	/**
	 * Método para crear nuevo contrato
	 * 
	 * @param removeContracts
	 * 
	 * @return idContracts
	 */
	public Long insertNewContracts(Contracts newContracts);
	
	/**
	 * Método para buscar por ID de contrato
	 * 
	 * @param contractsId
	 * @return idContracts
	 */
	public Contracts searchById(Long contractsId);
	
	/**
	 * Método para buscar todos los contratos
	 * 
	 * @return List<Contracts>
	 */
	public List<Contracts> findeAllContractsFromSystem();
	
	/**
	 * Método para actualizar contratos
	 * 
	 * @param updateContracts
	 */
	public void updateContracts(Contracts updateContracts);
	
	/**
	 * Método para buscar contratos por ID de cliente
	 * 
	 * @param customerId
	 * @return List<Contracts>
	 */
	public List<Contracts> searchContractsByIdCustomer(Long customerId);
	



}

