package com.higradius;

public class Response {
	private String name_customer;
	private String cust_number;
	private String invoice_id;
	private String total_open_amount;
	private String due_in_date;
	private String predicted_clear_date;
	public String getName_customer() {
		return name_customer;
	}
	public String getPredicted_clear_date() {
		return predicted_clear_date;
	}
	public void setPredicted_clear_date(String predicted_clear_date) {
		this.predicted_clear_date = predicted_clear_date;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	public String getCust_number() {
		return cust_number;
	}
	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}
	public String getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
	}
	public String getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(String total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	public String getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(String due_in_date) {
		this.due_in_date = due_in_date;
	}
}
