package npu.manager.beans;

import java.net.URLEncoder;
import java.util.Date;

/**
 * Created by  on .
 *
 * @version ${version}
 * @autor ZLei
 * @date 2017/9/16
 * @todo 支部活动
 */
public class Record {

    private int rid; // 活动ID
    private String bid; // 活动支部 ID
    private Date recordTime; // 活动时间
    private int unNumber; // 应到人数
    private int arrNumber; // 实到人数
    private String theme; // 活动主题
    private String place; //活动地点
    private String comment; // 记录备注
    private String recordDetail; // 记录内容


    public Record() {
    }

    /**
     * @return rid : int
     */
    public int getRid() {
        return rid;
    }

    /**
     * @param rid : int
     */
    public void setRid(int rid) {
        this.rid = rid;
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
     * @return recordTime : java.util.Date
     */
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     * @param recordTime : java.util.Date
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * @return unNumber : int
     */
    public int getUnNumber() {
        return unNumber;
    }

    /**
     * @param unNumber : int
     */
    public void setUnNumber(int unNumber) {
        this.unNumber = unNumber;
    }

    /**
     * @return arrNumber : int
     */
    public int getArrNumber() {
        return arrNumber;
    }

    /**
     * @param arrNumber : int
     */
    public void setArrNumber(int arrNumber) {
        this.arrNumber = arrNumber;
    }

    /**
     * @return theme : java.lang.String
     */
    public String getTheme() {
        return theme;
    }

    /**
     * @param theme : java.lang.String
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * @return place : java.lang.String
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place : java.lang.String
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return recordDetail : java.lang.String
     */
    public String getRecordDetail() {
        return recordDetail;
    }

    /**
     * @param recordDetail : java.lang.String
     */
    public void setRecordDetail(String recordDetail) {
        this.recordDetail = recordDetail;
    }

    /**
     * @return comment : java.lang.String
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment : java.lang.String
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setEncoding(){
        try {
            if(this.theme != null){
                this.theme = URLEncoder.encode(this.theme, "utf-8");
            }

            if(this.place != null){
                this.place = URLEncoder.encode(this.place,"utf-8");
            }

            if(this.comment != null){
                this.comment = URLEncoder.encode(this.comment,"utf-8");
            }

            if(this.recordDetail != null){
                this.recordDetail = URLEncoder.encode(this.recordDetail,"utf-8");
            }
        }catch (Exception e){
            System.out.println("record setEncoding error");
        }
    }

    @Override
    public String toString() {
        return "Record{" +
                "rid=" + rid +
                ", bid='" + bid + '\'' +
                ", recordTime=" + recordTime +
                ", unNumber=" + unNumber +
                ", arrNumber=" + arrNumber +
                ", theme='" + theme + '\'' +
                ", place='" + place + '\'' +
                ", comment='" + comment + '\'' +
                ", recordDetail='" + recordDetail + '\'' +
                '}';
    }
}
