package com.nttdata.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * NTT DATA - DAO IMPLEMENTADO ENTIDAD CONTRACTS
 * 
 * @author dhraq
 *
 */

public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {
	
	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión de conexión con la BBDD */
	private Session session;

	/**
	 * Constructor sobrecargado
	 * 
	 * @param session
	 */
	public CommonDaoImpl(final Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public Long insert(final T newEntityT) {

		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción
		final Long newEntityId = (Long) session.save(newEntityT);

		// Commit
		session.getTransaction().commit();
		return newEntityId;
	}

	@Override
	public void delete(final T removeEntityT) {
		
		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Actualización
		session.remove(removeEntityT);

		// Commit
		session.getTransaction().commit();			
	}

	@Override
	public T searchById(Long entityTIdToSearch) {
		
		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		//Buscar por Id(PK)
		final T entityResult = session.get(this.entityClass, entityTIdToSearch);
		
		return entityResult;
	}

	@Override
	public void update(final T updateEntityT) {
		
		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Actualización
		session.update(updateEntityT);

		// Commit
		session.getTransaction().commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Comprobación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		//Busqueda completa
		final List<T> entityListResult = session.createQuery("FROM " + this.entityClass.getName()).list();
		
		return entityListResult;
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}


}
