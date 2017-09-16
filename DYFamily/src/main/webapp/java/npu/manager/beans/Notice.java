package npu.manager.beans;

/**
 * Created by  on .
 *
 * @version ${version}
 * @autor ZLei
 * @date 2017/9/16
 * @todo
 */
public class Notice {

    private int nid; // 公告ID
    private int nType; // 公告类别
    private String title; // 公告标题
    private String subTitle; // 公告副标题
    private int readTimes;   // 阅读次数
    private String detail;  // 公告内容

    public Notice() {
    }

    /**
     * @return nid : int
     */
    public int getNid() {
        return nid;
    }

    /**
     * @param nid : int
     */
    public void setNid(int nid) {
        this.nid = nid;
    }

    /**
     * @return nType : int
     */
    public int getnType() {
        return nType;
    }

    /**
     * @param nType : int
     */
    public void setnType(int nType) {
        this.nType = nType;
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
     * @return subTitle : java.lang.String
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * @param subTitle : java.lang.String
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * @return readTimes : int
     */
    public int getReadTimes() {
        return readTimes;
    }

    /**
     * @param readTimes : int
     */
    public void setReadTimes(int readTimes) {
        this.readTimes = readTimes;
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
        return "Notice{" +
                "nid=" + nid +
                ", nType=" + nType +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", readTimes=" + readTimes +
                ", detail='" + detail + '\'' +
                '}';
    }
}
