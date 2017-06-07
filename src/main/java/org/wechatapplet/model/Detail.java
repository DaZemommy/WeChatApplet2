package org.wechatapplet.model;

import java.util.Date;

public class Detail {
    private Integer did;

    private String dname;

    private String pics;

    private String fpic;

    private Integer flag;

    private Integer dzid;

    private Integer userid;

    private Date createtime;

    private String content;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    public String getFpic() {
        return fpic;
    }

    public void setFpic(String fpic) {
        this.fpic = fpic == null ? null : fpic.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getDzid() {
        return dzid;
    }

    public void setDzid(Integer dzid) {
        this.dzid = dzid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}