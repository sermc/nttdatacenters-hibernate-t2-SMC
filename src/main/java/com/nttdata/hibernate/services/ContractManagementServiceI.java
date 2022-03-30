package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.Customer;

/**
 * Formación - Hibernate - Taller 2
 * 
 * Interface del servicio de contratos.
 * 
 * @author NTT Data Sevilla
 *
 */
public interface ContractManagementServiceI {

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final Contract updatedContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final Contract deletedContract);

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param contractId
	 */
	public Contract searchById(final Long contractId);

	/**
	 * Obtiene contratos asociados a un cliente.
	 * 
	 * @param customer
	 * @return List<Contract>
	 */
	public List<Contract> searchByCustomer(final Customer customer);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAll();

}
