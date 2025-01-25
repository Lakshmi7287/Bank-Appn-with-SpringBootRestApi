package com.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="restbank")
public class Bank {

	@Id
	private Long accountNo;
	private String name;
	private String password;
	@Transient //Should Not Exist/save in DataBase
	private String cpassword;
	private Double balance;
	private String address;
	private String mobileNo;
	@Transient //Should Not Exist/save in DataBase
	private Long transferAccountNo;
	private String status;
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(Long accountNo, String name, String password, String cpassword, Double balance, String address,
			String mobileNo, Long transferAccountNo,String status) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.password = password;
		this.cpassword = cpassword;
		this.balance = balance;
		this.address = address;
		this.mobileNo = mobileNo;
		this.transferAccountNo = transferAccountNo;
		this.status = status;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Long getTransferAccountNo() {
		return transferAccountNo;
	}
	public void setTransferAccountNo(Long transferAccountNo) {
		this.transferAccountNo = transferAccountNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	
	@Override
	public String toString() {
		return "Bank [accountNo=" + accountNo + ", name=" + name + ", password=" + password + ", cpassword=" + cpassword
				+ ", balance=" + balance + ", address=" + address + ", mobileNo=" + mobileNo + ", transferAccountNo="
				+ transferAccountNo + "status="+status+"]";
	}
	
	
}
