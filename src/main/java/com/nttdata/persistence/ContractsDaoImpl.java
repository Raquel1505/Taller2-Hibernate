package com.nttdata.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * NTT DATA - DAO ENTIDAD CONTRACTS
 * 
 * @author dhraq
 *
 */

public class ContractsDaoImpl extends CommonDaoImpl<Contracts> implements ContractsDaoI {
	
	/** Sesión de conexión con la BBDD */
	private Session session;

	/**
	 * Constructor sobrecargado
	 * 
	 * @param session
	 */
	public ContractsDaoImpl(final Session session) {
		super(session);
		this.session = session;
	}
	
/**
 * Método para buscar contrato a trevés de id de cliente
 * @param customerIdTo
 * @return List<Contracts>
 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contracts> searchContractsByIdCustomer(final Long customerId) {

		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		//Localizar contratos en función del Id del cliente
		final List<Contracts> contractsList = session.createQuery("FROM Contracts WHERE customer.customerId = '" + customerId + "'" ).list();
		
		return contractsList;
	}

}
