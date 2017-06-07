package org.wechatapplet.model;

public class Zixun {
    private Integer zid;

    private String zname;

    private String zdesc;

    private Integer zuid;

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname == null ? null : zname.trim();
    }

    public String getZdesc() {
        return zdesc;
    }

    public void setZdesc(String zdesc) {
        this.zdesc = zdesc == null ? null : zdesc.trim();
    }

    public Integer getZuid() {
        return zuid;
    }

    public void setZuid(Integer zuid) {
        this.zuid = zuid;
    }
}