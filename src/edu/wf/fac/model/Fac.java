package edu.wf.fac.model;
public class Fac {

    private Integer fac_id;
    private String fac_name;

    /**
     * 获取  字段:fac.fac_id
     *
     * @return  fac.fac_id
     */
    public Integer getFac_id() {
        return fac_id;
    }

    /**
     * 设置  字段:fac.fac_id
     *
     * @param fac_id  fac.fac_id
     */
    public void setFac_id(Integer fac_id) {
        this.fac_id = fac_id;
    }

    /**
     * 获取  字段:fac.fac_name
     *
     * @return  fac.fac_name
     */
    public String getFac_name() {
        return fac_name;
    }

    /**
     * 设置  字段:fac.fac_name
     *
     * @param fac_name  fac.fac_name
     */
    public void setFac_name(String fac_name) {
        this.fac_name = fac_name == null ? null : fac_name.trim();
    }
}