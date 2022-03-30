package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Formación - Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH2_CUSTOMER
 * 
 * @author NTT Data Sevilla
 *
 */
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public CustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByCustomerFullName(String name, String surname1, String surname2) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		// Localiza cliente por nombre completo.
		final List<Customer> customerList = session
		        .createQuery("FROM Customer WHERE name='" + name + "' AND surname1='" + surname1 + "' AND surname2='" + surname2 + "'").list();

		return customerList;
	}

}
