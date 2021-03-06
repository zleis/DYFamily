package npu.manager.beans;

import java.net.URLEncoder;

/**
 * Created by  on .
 *
 * @version ${version}
 * @autor ZLei
 * @date 2017/9/16
 * @todo 支部管理
 */
public class Branch {

    private String bid; // 支部ID
    private String bName; // 支部名称
    private String bDetail; // 支部描述

    public Branch() {
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
     * @return bName : java.lang.String
     */
    public String getbName() {
        return bName;
    }

    /**
     * @param bName : java.lang.String
     */
    public void setbName(String bName) {
        this.bName = bName;
    }

    /**
     * @return bDetail : java.lang.String
     */
    public String getbDetail() {
        return bDetail;
    }

    /**
     * @param bDetail : java.lang.String
     */
    public void setbDetail(String bDetail) {
        this.bDetail = bDetail;
    }

    /**
     * @todo 设置字符串编码
     */
    public void setEncoding(){
        try {
            if(this.bName != null){
                this.bName = URLEncoder.encode(this.bName, "utf-8");
            }
            if(this.bDetail != null){
                this.bDetail = URLEncoder.encode(this.bDetail,"utf-8");
            }
        }catch (Exception e){

        }
    }
    @Override
    public String toString() {
        return "Branch{" +
                "bid='" + bid + '\'' +
                ", bName='" + bName + '\'' +
                ", bDetail='" + bDetail + '\'' +
                '}';
    }
}
