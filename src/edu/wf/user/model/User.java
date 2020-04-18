package edu.wf.user.model;

import edu.wf.role.model.Role;

public class User {

    private Integer user_id;
    private String user_name;
    private String account;
    private String password;
    private Integer delete_status;
    private String user_card;
    private String user_tel;
    private Integer user_sex;
    private Integer user_age;
    private String user_logo;
    private Integer fk_role_id;
    private Role role;
    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getFk_role_id() {
		return fk_role_id;
	}

	public void setFk_role_id(Integer fk_role_id) {
		this.fk_role_id = fk_role_id;
	}

	/**
     * 获取  字段:userinfo.user_id
     *
     * @return  userinfo.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * 设置  字段:userinfo.user_id
     *
     * @param user_id  userinfo.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * 获取  字段:userinfo.user_name
     *
     * @return  userinfo.user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * 设置  字段:userinfo.user_name
     *
     * @param user_name  userinfo.user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    /**
     * 获取  字段:userinfo.account
     *
     * @return  userinfo.account
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置  字段:userinfo.account
     *
     * @param account  userinfo.account
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取  字段:userinfo.password
     *
     * @return  userinfo.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置  字段:userinfo.password
     *
     * @param password  userinfo.password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取  字段:userinfo.delete_status
     *
     * @return  userinfo.delete_status
     */
    public Integer getDelete_status() {
        return delete_status;
    }

    /**
     * 设置  字段:userinfo.delete_status
     *
     * @param delete_status  userinfo.delete_status
     */
    public void setDelete_status(Integer delete_status) {
        this.delete_status = delete_status;
    }

    /**
     * 获取  字段:userinfo.user_card
     *
     * @return  userinfo.user_card
     */
    public String getUser_card() {
        return user_card;
    }

    /**
     * 设置  字段:userinfo.user_card
     *
     * @param user_card  userinfo.user_card
     */
    public void setUser_card(String user_card) {
        this.user_card = user_card == null ? null : user_card.trim();
    }

    /**
     * 获取  字段:userinfo.user_tel
     *
     * @return  userinfo.user_tel
     */
    public String getUser_tel() {
        return user_tel;
    }

    /**
     * 设置  字段:userinfo.user_tel
     *
     * @param user_tel  userinfo.user_tel
     */
    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel == null ? null : user_tel.trim();
    }

    /**
     * 获取  字段:userinfo.user_sex
     *
     * @return  userinfo.user_sex
     */
    public Integer getUser_sex() {
        return user_sex;
    }

    /**
     * 设置  字段:userinfo.user_sex
     *
     * @param user_sex  userinfo.user_sex
     */
    public void setUser_sex(Integer user_sex) {
        this.user_sex = user_sex;
    }

    /**
     * 获取  字段:userinfo.user_age
     *
     * @return  userinfo.user_age
     */
    public Integer getUser_age() {
        return user_age;
    }

    /**
     * 设置  字段:userinfo.user_age
     *
     * @param user_age  userinfo.user_age
     */
    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    /**
     * 获取  字段:userinfo.user_logo
     *
     * @return  userinfo.user_logo
     */
    public String getUser_logo() {
        return user_logo;
    }

    /**
     * 设置  字段:userinfo.user_logo
     *
     * @param user_logo  userinfo.user_logo
     */
    public void setUser_logo(String user_logo) {
        this.user_logo = user_logo == null ? null : user_logo.trim();
    }
}