package com.nttdata.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.services.ContractManagementServiceI;
import com.nttdata.hibernate.services.ContractManagementServiceImpl;
import com.nttdata.hibernate.services.CustomerManagementServiceI;
import com.nttdata.hibernate.services.CustomerManagementServiceImpl;

/**
 * Formación - Hibernate - Taller 2
 * 
 * Clase principal
 * 
 * @author NTT Data Sevilla
 *
 */
public class NTTDataAppT2 {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final CustomerManagementServiceI customerService = new CustomerManagementServiceImpl(session);
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "SYS NTT Data";
		final Date updatedDate = new Date();

		// Nuevo cliente 1.
		Customer customer1 = new Customer();
		customer1.setIdentityDocNumber("11222333A");
		customer1.setName("Alejandro");
		customer1.setSurName1("Téllez");
		customer1.setSurName2("Rubio");
		customer1.setUpdatedDate(updatedDate);
		customer1.setUpdatedUser(updatedUser);
		customerService.insertNewCustomer(customer1);

		// Nuevo contrato 1.
		Contract contract1 = new Contract();
		contract1.setRelCustomer(customer1);
		contract1.setMensualPrice(50D);
		contract1.setStartDate(new Date());
		contract1.setUpdatedDate(updatedDate);
		contract1.setUpdatedUser(updatedUser);

		// Nuevo contrato 2.
		Contract contract2 = new Contract();
		contract2.setRelCustomer(customer1);
		contract2.setMensualPrice(10D);
		contract2.setStartDate(new Date());
		contract2.setUpdatedDate(updatedDate);
		contract2.setUpdatedUser(updatedUser);

		// Nuevo cliente 2.
		Customer customer2 = new Customer();
		customer2.setIdentityDocNumber("77888999C");
		customer2.setName("Ainara");
		customer2.setSurName1("Téllez");
		customer2.setSurName2("Campano");
		customer2.setUpdatedDate(updatedDate);
		customer2.setUpdatedUser(updatedUser);
		customerService.insertNewCustomer(customer2);

		// Nuevo contrato 3.
		Contract contract3 = new Contract();
		contract3.setRelCustomer(customer2);
		contract3.setMensualPrice(20D);
		contract3.setStartDate(new Date());
		contract3.setUpdatedDate(updatedDate);
		contract3.setUpdatedUser(updatedUser);

		// Insercción de contratos.
		contractService.insertNewContract(contract1);
		contractService.insertNewContract(contract2);
		contractService.insertNewContract(contract3);

		// Obtención de la lista de contratos insertados.
		List<Contract> contractsList = contractService.searchAll();
		if (contractsList != null && contractsList.size() > 0) {
			System.out.println("Total de contratos registrados: " + contractsList.size());
			for (Contract contract : contractsList) {
				System.out.println(contract.toString() + "\n");
			}
		}

		// Obtención de contratos asociados a un cliente.
		final List<Contract> contractsByCustomerList = contractService.searchByCustomer(customer2);

		if (contractsByCustomerList != null && contractsByCustomerList.size() > 0) {
			System.out.println("Total de contratos asociados al cliente con ID " + customer2.getCustomerId() + ": " + contractsByCustomerList.size());
			for (Contract contract : contractsByCustomerList) {
				System.out.println(contract.toString() + "\n");
			}
		}

		// Cierre de sesión.
		session.close();

	}

}
