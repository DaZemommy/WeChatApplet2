package org.wechatapplet.model;

public class Renzheng {
    private Integer rid;

    private String rname;

    private String rkey;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public String getRkey() {
        return rkey;
    }

    public void setRkey(String rkey) {
        this.rkey = rkey == null ? null : rkey.trim();
    }
}