package nwpu.manager.beans;

import java.util.Date;

/**
 * Created by  on .
 *
 * @version ${version}
 * @autor ZLei
 * @date 2017/9/16
 * @todo 党费缴纳
 */
public class Payment {

    private int pid; //缴费ID
    private String uid; // 缴费用户ID
    private Date payTime; // 缴费时间
    private double payMoney; // 缴费金额
    private String comment; // 缴费备注

    public Payment() {
    }

    /**
     * @return pid : int
     */
    public int getPid() {
        return pid;
    }

    /**
     * @param pid : int
     */
    public void setPid(int pid) {
        this.pid = pid;
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
     * @return payTime : java.util.Date
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime : java.util.Date
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @return payMoney : double
     */
    public double getPayMoney() {
        return payMoney;
    }

    /**
     * @param payMoney : double
     */
    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
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
        return "Payment{" +
                "pid=" + pid +
                ", uid='" + uid + '\'' +
                ", payTime=" + payTime +
                ", payMoney=" + payMoney +
                ", comment='" + comment + '\'' +
                '}';
    }
}
