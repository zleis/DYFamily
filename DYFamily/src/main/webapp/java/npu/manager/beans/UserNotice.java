package npu.manager.beans;

import java.util.List;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/24
 * @todo
 */
public class UserNotice {

    private String uid; // 用户ID
//    private String nid;
//    private int isRead;
    private List<Notice> noticeList;

    public UserNotice() {
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
     * @return noticeList : java.util.List<npu.manager.beans.Notice>
     */
    public List<Notice> getNoticeList() {
        return noticeList;
    }

    /**
     * @param noticeList : java.util.List<npu.manager.beans.Notice>
     */
    public void setNoticeList(List<Notice> noticeList) {
        this.noticeList = noticeList;
    }

    @Override
    public String toString() {
        return "UserNotice{" +
                "uid='" + uid + '\'' +
                ", noticeList=" + noticeList +
                '}';
    }

    /**
     * function setEncoding
     * @author ZLei
     * @date 2017/9/25
     * @param
     * @return void
     * @todo 设置该对象的编码为utf-8
     */
    public void setEncoding(){

        for(Notice notice:this.noticeList){
            notice.setEncoding();
        }
    }
}
