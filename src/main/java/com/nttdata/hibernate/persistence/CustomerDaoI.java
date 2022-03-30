package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Formación - Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH2_CUSTOMER
 * 
 * @author NTT Data Sevilla
 *
 */
public interface CustomerDaoI extends CommonDaoI<Customer> {

	/**
	 * Obtiene clientes en función del nombre completo.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return List<Customer>
	 */
	public List<Customer> searchByCustomerFullName(final String name, final String surname1, final String surname2);

}
