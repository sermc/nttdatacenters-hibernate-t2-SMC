package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.persistence.CustomerDaoI;
import com.nttdata.hibernate.persistence.CustomerDaoImpl;

/**
 * Formación - Hibernate - Taller 2
 * 
 * Implementación del servicio de clientes.
 * 
 * @author NTT Data Sevilla
 *
 */
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {

	/** DAO: NTTDATA_TH2_CUSTOMER */
	private CustomerDaoI customerDao;

	/**
	 * Método constructor.
	 */
	public CustomerManagementServiceImpl(final Session session) {
		this.customerDao = new CustomerDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(final Customer newCustomer) {

		// Verificación de nulidad e inexistencia.
		if (newCustomer != null && newCustomer.getCustomerId() == null) {

			// Insercción del nuevo cliente.
			customerDao.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(final Customer updatedCustomer) {

		// Verificación de nulidad y existencia.
		if (updatedCustomer != null && updatedCustomer.getCustomerId() != null) {

			// Actualización del cliente.
			customerDao.update(updatedCustomer);
		}

	}

	@Override
	public void deleteCustomer(final Customer deletedCustomer) {

		// Verificación de nulidad y existencia.
		if (deletedCustomer != null && deletedCustomer.getCustomerId() != null) {

			// Eliminación del cliente.
			customerDao.delete(deletedCustomer);
		}

	}

	@Override
	public Customer searchById(final Long customerId) {

		// Resultado.
		Customer customer = null;

		// Verificación de nulidad.
		if (customerId != null) {

			// Obtención del cliente por ID.
			customer = customerDao.searchById(customerId);
		}

		return customer;
	}

	@Override
	public List<Customer> searchByFullName(final String name, final String surname1, final String surname2) {

		// Resultado.
		List<Customer> customersList = new ArrayList<Customer>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(surname1) && StringUtils.isNotBlank(surname2)) {

			// Obtención del cliente por nombre completo.
			customersList = customerDao.searchByCustomerFullName(name, surname1, surname2);
		}

		return customersList;
	}

	@Override
	public List<Customer> searchAll() {

		// Resultado.
		List<Customer> customersList = new ArrayList<Customer>();

		// Obtención de clientes.
		customersList = customerDao.searchAll();

		return customersList;
	}

}
