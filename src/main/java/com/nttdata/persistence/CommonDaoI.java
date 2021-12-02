package com.nttdata.persistence;

import java.util.List;

/**
 * NTT DATA - DAO COMMON
 * 
 * @author dhraq
 * @param <T>
 *
 */

public interface CommonDaoI<T> {
	/**
	 * Método para insertar registros
	 * 
	 * @param newEntityT
	 * 
	 * @return Long
	 */
	public Long insert(final T newEntityT);
	/**
	 * Método para borrar registros
	 * 
	 * @param removeEntityT
	 * 
	 */
	public void delete(final T removeEntityT);
	/**
	 * Método para buscar por id
	 * 
	 * @param entityTIdToSearch
	 * 
	 */
	public T searchById(final Long entityTIdToSearch);
	/**
	 * Método para actualizar registros
	 * 
	 * @param updateEntityT
	 */
	public void update(final T updateEntityT);

	/**
	 * Método para buscar todo
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();
}
