package edu.wf.spot.model;

import edu.wf.fac.model.Fac;

public class Spot {

    private Integer spot_id;
    private String spot_name;
    private String spot_addr;
    private String spot_time;
    private Integer spot_price;
    private String spot_message;
    private String spot_look;
    private String spot_link;
    private Integer spot_child;
    private String spot_logo;
    private Integer fk_spotFac_id;
    private Fac fac;
    public Fac getFac() {
		return fac;
	}

	public void setFac(Fac fac) {
		this.fac = fac;
	}

	public Integer getFk_spotFac_id() {
		return fk_spotFac_id;
	}

	public void setFk_spotFac_id(Integer fk_spotFac_id) {
		this.fk_spotFac_id = fk_spotFac_id;
	}


	/**
     * 获取  字段:spot.spot_id
     *
     * @return  spot.spot_id
     */
    public Integer getSpot_id() {
        return spot_id;
    }

    /**
     * 设置  字段:spot.spot_id
     *
     * @param spot_id  spot.spot_id
     */
    public void setSpot_id(Integer spot_id) {
        this.spot_id = spot_id;
    }

    /**
     * 获取  字段:spot.spot_name
     *
     * @return  spot.spot_name
     */
    public String getSpot_name() {
        return spot_name;
    }

    /**
     * 设置  字段:spot.spot_name
     *
     * @param spot_name  spot.spot_name
     */
    public void setSpot_name(String spot_name) {
        this.spot_name = spot_name == null ? null : spot_name.trim();
    }

    /**
     * 获取  字段:spot.spot_addr
     *
     * @return  spot.spot_addr
     */
    public String getSpot_addr() {
        return spot_addr;
    }

    /**
     * 设置  字段:spot.spot_addr
     *
     * @param spot_addr  spot.spot_addr
     */
    public void setSpot_addr(String spot_addr) {
        this.spot_addr = spot_addr == null ? null : spot_addr.trim();
    }

    /**
     * 获取  字段:spot.spot_time
     *
     * @return  spot.spot_time
     */
    public String getSpot_time() {
        return spot_time;
    }

    /**
     * 设置  字段:spot.spot_time
     *
     * @param spot_time  spot.spot_time
     */
    public void setSpot_time(String spot_time) {
        this.spot_time = spot_time == null ? null : spot_time.trim();
    }

    /**
     * 获取  字段:spot.spot_price
     *
     * @return  spot.spot_price
     */
    public Integer getSpot_price() {
        return spot_price;
    }

    /**
     * 设置  字段:spot.spot_price
     *
     * @param spot_price  spot.spot_price
     */
    public void setSpot_price(Integer spot_price) {
        this.spot_price = spot_price;
    }

    /**
     * 获取  字段:spot.spot_message
     *
     * @return  spot.spot_message
     */
    public String getSpot_message() {
        return spot_message;
    }

    /**
     * 设置  字段:spot.spot_message
     *
     * @param spot_message  spot.spot_message
     */
    public void setSpot_message(String spot_message) {
        this.spot_message = spot_message == null ? null : spot_message.trim();
    }

    /**
     * 获取  字段:spot.spot_look
     *
     * @return  spot.spot_look
     */
    public String getSpot_look() {
        return spot_look;
    }

    /**
     * 设置  字段:spot.spot_look
     *
     * @param spot_look  spot.spot_look
     */
    public void setSpot_look(String spot_look) {
        this.spot_look = spot_look == null ? null : spot_look.trim();
    }

    /**
     * 获取  字段:spot.spot_link
     *
     * @return  spot.spot_link
     */
    public String getSpot_link() {
        return spot_link;
    }

    /**
     * 设置  字段:spot.spot_link
     *
     * @param spot_link  spot.spot_link
     */
    public void setSpot_link(String spot_link) {
        this.spot_link = spot_link == null ? null : spot_link.trim();
    }

    /**
     * 获取  字段:spot.spot_child
     *
     * @return  spot.spot_child
     */
    public Integer getSpot_child() {
        return spot_child;
    }

    /**
     * 设置  字段:spot.spot_child
     *
     * @param spot_child  spot.spot_child
     */
    public void setSpot_child(Integer spot_child) {
        this.spot_child = spot_child;
    }

    /**
     * 获取  字段:spot.spot_logo
     *
     * @return  spot.spot_logo
     */
    public String getSpot_logo() {
        return spot_logo;
    }

    /**
     * 设置  字段:spot.spot_logo
     *
     * @param spot_logo  spot.spot_logo
     */
    public void setSpot_logo(String spot_logo) {
        this.spot_logo = spot_logo == null ? null : spot_logo.trim();
    }
}