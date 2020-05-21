package edu.wf.orte.model;

import java.util.Date;

import edu.wf.client.model.Client;
import edu.wf.teams.model.Teams;

public class Orte {

    private Integer orte_id;
    private Integer fk_orteTeams_id;
    private Integer fk_orteClient_id;
    private Integer orte_money;
    private Integer orte_num;
    private Integer orte_child;
    private Date orte_date;
    private String orte_code;
    private String orte_tel;
    private Integer orte_status;
    private Client client;
    private Teams teams;
    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Teams getTeams() {
		return teams;
	}

	public void setTeams(Teams teams) {
		this.teams = teams;
	}

	/**
     * 获取  字段:orte.orte_id
     *
     * @return  orte.orte_id
     */
    public Integer getOrte_id() {
        return orte_id;
    }

    /**
     * 设置  字段:orte.orte_id
     *
     * @param orte_id  orte.orte_id
     */
    public void setOrte_id(Integer orte_id) {
        this.orte_id = orte_id;
    }

    /**
     * 获取  字段:orte.fk_orteTeams_id
     *
     * @return  orte.fk_orteTeams_id
     */
    public Integer getFk_orteTeams_id() {
        return fk_orteTeams_id;
    }

    /**
     * 设置  字段:orte.fk_orteTeams_id
     *
     * @param fk_orteTeams_id  orte.fk_orteTeams_id
     */
    public void setFk_orteTeams_id(Integer fk_orteTeams_id) {
        this.fk_orteTeams_id = fk_orteTeams_id;
    }

    /**
     * 获取  字段:orte.fk_orteClient_id
     *
     * @return  orte.fk_orteClient_id
     */
    public Integer getFk_orteClient_id() {
        return fk_orteClient_id;
    }

    /**
     * 设置  字段:orte.fk_orteClient_id
     *
     * @param fk_orteClient_id  orte.fk_orteClient_id
     */
    public void setFk_orteClient_id(Integer fk_orteClient_id) {
        this.fk_orteClient_id = fk_orteClient_id;
    }

    /**
     * 获取  字段:orte.orte_money
     *
     * @return  orte.orte_money
     */
    public Integer getOrte_money() {
        return orte_money;
    }

    /**
     * 设置  字段:orte.orte_money
     *
     * @param orte_money  orte.orte_money
     */
    public void setOrte_money(Integer orte_money) {
        this.orte_money = orte_money;
    }

    /**
     * 获取  字段:orte.orte_num
     *
     * @return  orte.orte_num
     */
    public Integer getOrte_num() {
        return orte_num;
    }

    /**
     * 设置  字段:orte.orte_num
     *
     * @param orte_num  orte.orte_num
     */
    public void setOrte_num(Integer orte_num) {
        this.orte_num = orte_num;
    }

    /**
     * 获取  字段:orte.orte_child
     *
     * @return  orte.orte_child
     */
    public Integer getOrte_child() {
        return orte_child;
    }

    /**
     * 设置  字段:orte.orte_child
     *
     * @param orte_child  orte.orte_child
     */
    public void setOrte_child(Integer orte_child) {
        this.orte_child = orte_child;
    }

    /**
     * 获取  字段:orte.orte_date
     *
     * @return  orte.orte_date
     */
    public Date getOrte_date() {
        return orte_date;
    }

    /**
     * 设置  字段:orte.orte_date
     *
     * @param orte_date  orte.orte_date
     */
    public void setOrte_date(Date orte_date) {
        this.orte_date = orte_date;
    }

    /**
     * 获取  字段:orte.orte_code
     *
     * @return  orte.orte_code
     */
    public String getOrte_code() {
        return orte_code;
    }

    /**
     * 设置  字段:orte.orte_code
     *
     * @param orte_code  orte.orte_code
     */
    public void setOrte_code(String orte_code) {
        this.orte_code = orte_code == null ? null : orte_code.trim();
    }

    /**
     * 获取  字段:orte.orte_tel
     *
     * @return  orte.orte_tel
     */
    public String getOrte_tel() {
        return orte_tel;
    }

    /**
     * 设置  字段:orte.orte_tel
     *
     * @param orte_tel  orte.orte_tel
     */
    public void setOrte_tel(String orte_tel) {
        this.orte_tel = orte_tel == null ? null : orte_tel.trim();
    }

    /**
     * 获取  字段:orte.orte_status
     *
     * @return  orte.orte_status
     */
    public Integer getOrte_status() {
        return orte_status;
    }

    /**
     * 设置  字段:orte.orte_status
     *
     * @param orte_status  orte.orte_status
     */
    public void setOrte_status(Integer orte_status) {
        this.orte_status = orte_status;
    }
}