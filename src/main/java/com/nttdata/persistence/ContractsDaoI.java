package com.nttdata.persistence;

import java.util.List;

/**
 * NTT DATA - DAO ENTIDAD CONTRACTS
 * 
 * @author dhraq
 *
 */

public interface ContractsDaoI extends CommonDaoI<Contracts>{

	/**
	 * Método para buscar contrato a trevés de id de cliente
	 * @param customerIdTo
	 * @return List<Contracts>
	 */
	
	List<Contracts> searchContractsByIdCustomer(Long customerId);
	

}
