package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - Taller 2
 * 
 * Entidad de tabla NTTDATA_TH2_CONTRACT
 * 
 * @author NTT Data Sevilla
 *
 */
@Entity
@Table(name = "NTTDATA_TH2_CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contractId;

	/** Fecha de inicio de vigencia */
	private Date startDate;

	/** Fecha de fin de vigencia */
	private Date endDate;

	/** Precio mensual */
	private Double mensualPrice;

	/** Cliente asociado (FK) */
	private Customer relCustomer;

	/**
	 * @return the contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContractId() {
		return contractId;
	}

	/**
	 * @param contractId
	 *            the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the startDate
	 */
	@Column(name = "START_DATE", nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	@Column(name = "END_DATE", nullable = true)
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the mensualPrice
	 */
	@Column(name = "MENSUAL_PRICE", nullable = true)
	public Double getMensualPrice() {
		return mensualPrice;
	}

	/**
	 * @param mensualPrice
	 *            the mensualPrice to set
	 */
	public void setMensualPrice(Double mensualPrice) {
		this.mensualPrice = mensualPrice;
	}

	/**
	 * @return the relCustomer
	 */
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getRelCustomer() {
		return relCustomer;
	}

	/**
	 * @param relCustomer
	 *            the relCustomer to set
	 */
	public void setRelCustomer(Customer relCustomer) {
		this.relCustomer = relCustomer;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", startDate=" + startDate + ", endDate=" + endDate + ", mensualPrice=" + mensualPrice
		        + ", relCustomer=" + relCustomer + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

}
