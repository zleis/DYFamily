package npu.manager.beans;


import java.util.Date;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/25
 * @todo
 */
public class Advice {
    private int aid;
    private String uid;
    private String bid;
    private String mid;
    private Date createTime;
    private int type;
    private int reid;
    private String title;
    private String detail;

    /**
     * 用户提建议所用到参数
     */
    public Advice(String uid, String bid, Date createTime, String title, String detail) {
        this.uid = uid;
        this.bid = bid;
        this.createTime = createTime;
        this.title = title;
        this.type = 1;
        this.detail = detail;
    }

    /**
     * 管理员回复需要用到的参数
     */
    public Advice(String mid, Date createTime, int reid, String detail) {
        this.mid = mid;
        this.createTime = createTime;
        this.reid = reid;
        this.detail = detail;
    }

    /**
     * @return aid : int
     */
    public int getAid() {
        return aid;
    }

    /**
     * @param aid : int
     */
    public void setAid(int aid) {
        this.aid = aid;
    }

    /**
     * @return uid : java.lang.String
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid : java.lang.String
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return bid : java.lang.String
     */
    public String getBid() {
        return bid;
    }

    /**
     * @param bid : java.lang.String
     */
    public void setBid(String bid) {
        this.bid = bid;
    }

    /**
     * @return mid : java.lang.String
     */
    public String getMid() {
        return mid;
    }

    /**
     * @param mid : java.lang.String
     */
    public void setMid(String mid) {
        this.mid = mid;
    }

    /**
     * @return createTime : java.sql.Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime : java.sql.Date
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return type : int
     */
    public int getType() {
        return type;
    }

    /**
     * @param type : int
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return reid : int
     */
    public int getReid() {
        return reid;
    }

    /**
     * @param reid : int
     */
    public void setReid(int reid) {
        this.reid = reid;
    }

    /**
     * @return title : java.lang.String
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title : java.lang.String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return detail : java.lang.String
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail : java.lang.String
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "aid=" + aid +
                ", uid='" + uid + '\'' +
                ", bid='" + bid + '\'' +
                ", mid='" + mid + '\'' +
                ", createTime=" + createTime +
                ", type=" + type +
                ", reid=" + reid +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
