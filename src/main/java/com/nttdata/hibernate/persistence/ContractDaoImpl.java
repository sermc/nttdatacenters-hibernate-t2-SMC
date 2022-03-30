package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Formación - Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH2_CONTRACT
 * 
 * @author NTT Data Sevilla
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByCustomer(final Customer customer) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza contratos en función del ID del cliente.
		final List<Contract> contractsList = session.createQuery("FROM Contract WHERE relCustomer.customerId=" + customer.getCustomerId()).list();

		return contractsList;
	}

}
