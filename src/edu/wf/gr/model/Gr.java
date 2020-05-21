package edu.wf.gr.model;

import edu.wf.client.model.Client;
import edu.wf.spot.model.Spot;
import edu.wf.teams.model.Teams;

public class Gr {

    private Integer gr_id;
    private String gr_pho;
    private Integer fk_grClient_id;
    private Integer fk_grSpot_id;
    private Integer fk_grTeams_id;
    private Integer gr_grade;
    private String gr_message;
    private Client client;
    private Spot spot;
    private Teams teams;
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

	public Teams getTeams() {
		return teams;
	}

	public void setTeams(Teams teams) {
		this.teams = teams;
	}

	/**
     * 获取  字段:gr.gr_id
     *
     * @return  gr.gr_id
     */
    public Integer getGr_id() {
        return gr_id;
    }

    /**
     * 设置  字段:gr.gr_id
     *
     * @param gr_id  gr.gr_id
     */
    public void setGr_id(Integer gr_id) {
        this.gr_id = gr_id;
    }

    /**
     * 获取  字段:gr.gr_pho
     *
     * @return  gr.gr_pho
     */
    public String getGr_pho() {
        return gr_pho;
    }

    /**
     * 设置  字段:gr.gr_pho
     *
     * @param gr_pho  gr.gr_pho
     */
    public void setGr_pho(String gr_pho) {
        this.gr_pho = gr_pho == null ? null : gr_pho.trim();
    }

    /**
     * 获取  字段:gr.fk_grClient_id
     *
     * @return  gr.fk_grClient_id
     */
    public Integer getFk_grClient_id() {
        return fk_grClient_id;
    }

    /**
     * 设置  字段:gr.fk_grClient_id
     *
     * @param fk_grClient_id  gr.fk_grClient_id
     */
    public void setFk_grClient_id(Integer fk_grClient_id) {
        this.fk_grClient_id = fk_grClient_id;
    }

    /**
     * 获取  字段:gr.fk_grSpot_id
     *
     * @return  gr.fk_grSpot_id
     */
    public Integer getFk_grSpot_id() {
        return fk_grSpot_id;
    }

    /**
     * 设置  字段:gr.fk_grSpot_id
     *
     * @param fk_grSpot_id  gr.fk_grSpot_id
     */
    public void setFk_grSpot_id(Integer fk_grSpot_id) {
        this.fk_grSpot_id = fk_grSpot_id;
    }

    /**
     * 获取  字段:gr.fk_grTeams_id
     *
     * @return  gr.fk_grTeams_id
     */
    public Integer getFk_grTeams_id() {
        return fk_grTeams_id;
    }

    /**
     * 设置  字段:gr.fk_grTeams_id
     *
     * @param fk_grTeams_id  gr.fk_grTeams_id
     */
    public void setFk_grTeams_id(Integer fk_grTeams_id) {
        this.fk_grTeams_id = fk_grTeams_id;
    }

    /**
     * 获取  字段:gr.gr_grade
     *
     * @return  gr.gr_grade
     */
    public Integer getGr_grade() {
        return gr_grade;
    }

    /**
     * 设置  字段:gr.gr_grade
     *
     * @param gr_grade  gr.gr_grade
     */
    public void setGr_grade(Integer gr_grade) {
        this.gr_grade = gr_grade;
    }

    /**
     * 获取  字段:gr.gr_message
     *
     * @return  gr.gr_message
     */
    public String getGr_message() {
        return gr_message;
    }

    /**
     * 设置  字段:gr.gr_message
     *
     * @param gr_message  gr.gr_message
     */
    public void setGr_message(String gr_message) {
        this.gr_message = gr_message == null ? null : gr_message.trim();
    }
}