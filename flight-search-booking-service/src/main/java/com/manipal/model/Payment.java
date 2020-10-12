package com.manipal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Payments")

public class Payment {
	
		
		@Column(name="person_id")
		private int personId;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="payemnt_id")
		private int paymentId;
		
		@Column(name="card_no")
		private String cardNo;
		
		@Column(name="expiry_date")
		private LocalDate expiryDate;
		
		@Column(name="name") 
			private String nameOnCard;
		@Column(name="cvv")
		private String cvv;
		public Payment() {}

		public Payment(int personId, int paymentId, String cardNo, LocalDate expiryDate, String nameOnCard,String cvv) {
			super();
			this.personId = personId;
			this.paymentId = paymentId;
			this.cardNo = cardNo;
			this.expiryDate = expiryDate;
			this.nameOnCard = nameOnCard;
			this.cvv=cvv;
		}
		

		public String getCvv() {
			return cvv;
		}

		public void setCvv(String cvv) {
			this.cvv = cvv;
		}

		public int getPersonId() {
			return personId;
		}

		public void setPersonId(int personId) {
			this.personId = personId;
		}

		public int getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(int paymentId) {
			this.paymentId = paymentId;
		}

		public String getCardNo() {
			return cardNo;
		}

		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}

		public LocalDate getExpiryDate() {
			return expiryDate;
		}

		public void setExpiryDate(LocalDate expiryDate) {
			this.expiryDate = expiryDate;
		}

		public String getNameOnCard() {
			return nameOnCard;
		}

		public void setNameOnCard(String nameOnCard) {
			this.nameOnCard = nameOnCard;
		}

		@Override
		public String toString() {
			return "Payment [personId=" + personId + ", paymentId=" + paymentId + ", cardNo=" + cardNo + ", expiryDate="
					+ expiryDate + ", nameOnCard=" + nameOnCard + "]";
		}
		
		
		
		
}
