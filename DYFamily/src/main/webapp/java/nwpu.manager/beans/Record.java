package nwpu.manager.beans;

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
    private String uid; // 记录人ID
    private Date recordTime; // 活动时间
    private String recordDetail; // 记录内容
    private String fileName; // 记录文件内容
    private String comment; // 记录备注

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
     * @return fileName : java.lang.String
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName : java.lang.String
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    @Override
    public String toString() {
        return "Record{" +
                "rid=" + rid +
                ", uid='" + uid + '\'' +
                ", recordTime=" + recordTime +
                ", recordDetail='" + recordDetail + '\'' +
                ", fileName='" + fileName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
