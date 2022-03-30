package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - Taller 2
 * 
 * Entidad de tabla NTTDATA_TH2_CUSTOMER
 * 
 * @author NTT Data Sevilla
 *
 */
@Entity
@Table(name = "NTTDATA_TH2_CUSTOMER")
public class Customer extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long customerId;

	/** Nombre del cliente */
	private String name;

	/** Primer apellido */
	private String surName1;

	/** Segundo apellido */
	private String surName2;

	/** Documento de identidad */
	private String identityDocNumber;

	/** Lista de contratos relacionados */
	private List<Contract> contractsList;

	/**
	 * @return the customerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surName1
	 */
	@Column(name = "SURNAME1", nullable = false)
	public String getSurName1() {
		return surName1;
	}

	/**
	 * @param surName1
	 *            the surName1 to set
	 */
	public void setSurName1(String surName1) {
		this.surName1 = surName1;
	}

	/**
	 * @return the surName2
	 */
	@Column(name = "SURNAME2", nullable = true)
	public String getSurName2() {
		return surName2;
	}

	/**
	 * @param surName2
	 *            the surName2 to set
	 */
	public void setSurName2(String surName2) {
		this.surName2 = surName2;
	}

	/**
	 * @return the identityDocNumber
	 */
	@Column(name = "DOC_NUMBER", nullable = false, length = 9, unique = true)
	public String getIdentityDocNumber() {
		return identityDocNumber;
	}

	/**
	 * @param identityDocNumber
	 *            the identityDocNumber to set
	 */
	public void setIdentityDocNumber(String identityDocNumber) {
		this.identityDocNumber = identityDocNumber;
	}

	/**
	 * @return the contractsList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "relCustomer")
	public List<Contract> getContractsList() {
		return contractsList;
	}

	/**
	 * @param contractsList
	 *            the contractsList to set
	 */
	public void setContractsList(List<Contract> contractsList) {
		this.contractsList = contractsList;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", surName1=" + surName1 + ", surName2=" + surName2 + ", identityDocNumber="
		        + identityDocNumber + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Customer.class;
	}

}
