package com.nttdata.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Contracts;
import com.nttdata.persistence.ContractsDaoImpl;
import com.nttdata.persistence.Customer;

/**
 * NTT DATA - IMPLEMENTACION CONTRACTS SERVICE INTERFAZ
 * 
 * @author dhraq
 *
 */

public class ContractsServiceImpl implements ContractsServiceI{

	/** DAO: T_CUSTOMER */
	private ContractsDaoImpl contractsDao;
	
	/**
	 * Constructor
	 */
	public ContractsServiceImpl(final Session session) {
		this.contractsDao = new ContractsDaoImpl(session);
	}
	
	@Override
	public Long insertNewContracts(Contracts newContracts) {
		
		//Añadido de contrato
		final Long idContracts = contractsDao.insert(newContracts);
		return idContracts;
	}
	
	@Override
	public void deleteContracts(Contracts removeContracts) {
		
		// Verificación de nulidad y existencia.
		if (removeContracts != null) {

			// Eliminación del contrato.
			contractsDao.delete(removeContracts);
		}
	}
	
	@Override
	public Contracts searchById(Long contractsId) {
		//Buscar por ID
		return contractsDao.searchById(contractsId);
	}
	
	@Override
	public List<Contracts> findeAllContractsFromSystem(){
		return contractsDao.searchAll();
	}
	
	@Override
	public void updateContracts(Contracts updateContracts) {
		
		// Verificación de nulidad y existencia.
		if (updateContracts != null && updateContracts.getContractsId() != null) {

			// Actualización del contrato.
			contractsDao.update(updateContracts);
		}	
	}
	
	@Override
	public List<Contracts> searchContractsByIdCustomer (Long customerId) {
		return contractsDao.searchContractsByIdCustomer(customerId);
	}
}
	
