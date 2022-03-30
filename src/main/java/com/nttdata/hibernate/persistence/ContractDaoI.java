package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Formación - Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH2_CONTRACT
 * 
 * @author NTT Data Sevilla
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract> {

	/**
	 * Obtiene un contrato por cliente.
	 * 
	 * @param paramT
	 * @return List<Contract>
	 */
	public List<Contract> searchByCustomer(final Customer customer);

}
