package edu.wf.client.model;


public class Client {

    private Integer client_id;
    private String client_account;
    private String client_password;
    private String client_paypassword;
    private String client_name;
    private String client_tel;
    private String client_date;
    private Integer client_power;
    private String fk_clientFac_id;
	public String getFk_clientFac_id() {
		return fk_clientFac_id;
	}
	public void setFk_clientFac_id(String fk_clientFac_id) {
		this.fk_clientFac_id = fk_clientFac_id;
	}
	public Integer getClient_id() {
		return client_id;
	}
	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	public String getClient_account() {
		return client_account;
	}
	public void setClient_account(String client_account) {
		this.client_account = client_account;
	}
	public String getClient_password() {
		return client_password;
	}
	public void setClient_password(String client_password) {
		this.client_password = client_password;
	}
	public String getClient_paypassword() {
		return client_paypassword;
	}
	public void setClient_paypassword(String client_paypassword) {
		this.client_paypassword = client_paypassword;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getClient_tel() {
		return client_tel;
	}
	public void setClient_tel(String client_tel) {
		this.client_tel = client_tel;
	}
	public String getClient_date() {
		return client_date;
	}
	public void setClient_date(String client_date) {
		this.client_date = client_date;
	}
	public Integer getClient_power() {
		return client_power;
	}
	public void setClient_power(Integer client_power) {
		this.client_power = client_power;
	}

}