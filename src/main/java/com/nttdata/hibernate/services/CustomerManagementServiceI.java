package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Customer;

/**
 * Formación - Hibernate - Taller 2
 * 
 * Interface del servicio de clientes.
 * 
 * @author NTT Data Sevilla
 *
 */
public interface CustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final Customer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(final Customer updatedCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(final Customer deletedCustomer);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param customerId
	 */
	public Customer searchById(final Long customerId);

	/**
	 * Obtiene un cliente por su nombre completo.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return List<Customer>
	 */
	public List<Customer> searchByFullName(final String name, final String surname1, final String surname2);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> searchAll();

}
