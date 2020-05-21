package edu.wf.orsp.model;

import java.util.Date;

import edu.wf.client.model.Client;
import edu.wf.spot.model.Spot;

public class Orsp {

    private Integer orsp_id;
    private Integer fk_orspSpot_id;
    private Integer fk_orspClient_id;
    private Integer orsp_money;
    private Integer orsp_num;
    private Integer orsp_child;
    private Date orsp_date;
    private String orsp_code;
    private String orsp_tel;
    private Integer orsp_status;
    private Client client;
    private Spot spot;
    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	/**
     * 获取  字段:orsp.orsp_id
     *
     * @return  orsp.orsp_id
     */
    public Integer getOrsp_id() {
        return orsp_id;
    }

    /**
     * 设置  字段:orsp.orsp_id
     *
     * @param orsp_id  orsp.orsp_id
     */
    public void setOrsp_id(Integer orsp_id) {
        this.orsp_id = orsp_id;
    }

    /**
     * 获取  字段:orsp.fk_orspSpot_id
     *
     * @return  orsp.fk_orspSpot_id
     */
    public Integer getFk_orspSpot_id() {
        return fk_orspSpot_id;
    }

    /**
     * 设置  字段:orsp.fk_orspSpot_id
     *
     * @param fk_orspSpot_id  orsp.fk_orspSpot_id
     */
    public void setFk_orspSpot_id(Integer fk_orspSpot_id) {
        this.fk_orspSpot_id = fk_orspSpot_id;
    }

    /**
     * 获取  字段:orsp.fk_orspClient_id
     *
     * @return  orsp.fk_orspClient_id
     */
    public Integer getFk_orspClient_id() {
        return fk_orspClient_id;
    }

    /**
     * 设置  字段:orsp.fk_orspClient_id
     *
     * @param fk_orspClient_id  orsp.fk_orspClient_id
     */
    public void setFk_orspClient_id(Integer fk_orspClient_id) {
        this.fk_orspClient_id = fk_orspClient_id;
    }

    /**
     * 获取  字段:orsp.orsp_money
     *
     * @return  orsp.orsp_money
     */
    public Integer getOrsp_money() {
        return orsp_money;
    }

    /**
     * 设置  字段:orsp.orsp_money
     *
     * @param orsp_money  orsp.orsp_money
     */
    public void setOrsp_money(Integer orsp_money) {
        this.orsp_money = orsp_money;
    }

    /**
     * 获取  字段:orsp.orsp_num
     *
     * @return  orsp.orsp_num
     */
    public Integer getOrsp_num() {
        return orsp_num;
    }

    /**
     * 设置  字段:orsp.orsp_num
     *
     * @param orsp_num  orsp.orsp_num
     */
    public void setOrsp_num(Integer orsp_num) {
        this.orsp_num = orsp_num;
    }

    /**
     * 获取  字段:orsp.orsp_child
     *
     * @return  orsp.orsp_child
     */
    public Integer getOrsp_child() {
        return orsp_child;
    }

    /**
     * 设置  字段:orsp.orsp_child
     *
     * @param orsp_child  orsp.orsp_child
     */
    public void setOrsp_child(Integer orsp_child) {
        this.orsp_child = orsp_child;
    }

    /**
     * 获取  字段:orsp.orsp_date
     *
     * @return  orsp.orsp_date
     */
    public Date getOrsp_date() {
        return orsp_date;
    }

    /**
     * 设置  字段:orsp.orsp_date
     *
     * @param orsp_date  orsp.orsp_date
     */
    public void setOrsp_date(Date orsp_date) {
        this.orsp_date = orsp_date;
    }

    /**
     * 获取  字段:orsp.orsp_code
     *
     * @return  orsp.orsp_code
     */
    public String getOrsp_code() {
        return orsp_code;
    }

    /**
     * 设置  字段:orsp.orsp_code
     *
     * @param orsp_code  orsp.orsp_code
     */
    public void setOrsp_code(String orsp_code) {
        this.orsp_code = orsp_code == null ? null : orsp_code.trim();
    }

    /**
     * 获取  字段:orsp.orsp_tel
     *
     * @return  orsp.orsp_tel
     */
    public String getOrsp_tel() {
        return orsp_tel;
    }

    /**
     * 设置  字段:orsp.orsp_tel
     *
     * @param orsp_tel  orsp.orsp_tel
     */
    public void setOrsp_tel(String orsp_tel) {
        this.orsp_tel = orsp_tel == null ? null : orsp_tel.trim();
    }

    /**
     * 获取  字段:orsp.orsp_status
     *
     * @return  orsp.orsp_status
     */
    public Integer getOrsp_status() {
        return orsp_status;
    }

    /**
     * 设置  字段:orsp.orsp_status
     *
     * @param orsp_status  orsp.orsp_status
     */
    public void setOrsp_status(Integer orsp_status) {
        this.orsp_status = orsp_status;
    }
}