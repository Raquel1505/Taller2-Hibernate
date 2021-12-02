package com.nttdata.persistence;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Customer;

/**
 * NTT DATA - IMPLEMENTACIÓN DAO ENTIDAD CUSTOMER
 * 
 * @author dhraq
 *
 */

public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {

	/** Sesión de conexión con la BBDD */
	private Session session;

	/**
	 * Constructor sobrecargado
	 * 
	 * @param session
	 */
	public CustomerDaoImpl(final Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Customer> searchByCustomerFullName(String name, String surname, String secondSurname) {

			// Comprobación de sesión abierta
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}

			// Localizar al cliente por nombre y apellidos
			final List<Customer> customerList = session.createQuery("FROM Customer WHERE name='" + name
					+ "' AND surname= '" + surname + "' AND secondSurname= '" + secondSurname + "'").list();
			return customerList;
	}

}
