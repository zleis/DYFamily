package npu.manager.service;

import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.Branch;
import npu.manager.beans.Notice;
import npu.manager.beans.Record;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/29
 * @todo
 */
public interface AdminViewService {

    /**
     * @param uid
     * @return 获取管理员权限
     */
    public int getAdminPower(String uid);

    /**
     * function getNoticeList
     * @author ZLei
     * @date 2017/9/30
     * @todo 获取公告列表
     */
    public JSONObject getNoticeList();

    /**
     * function getNoticeByID
     * @author ZLei
     * @date 2017/9/30
     * @todo 通过公告ID获取宫傲
     */
    public Notice getNoticeByID(int nid);

    /**
     * function getUserList
     * @author ZLei
     * @date 2017/9/30
     * @todo 获取用户列表
     */
    public JSONObject getUserList();

    /**
     * function getUserByID
     * @author ZLei
     * @date 2017/9/30
     * @todo 通过ID获取用户
     */
    public JSONObject getUserByID(String uid);

    /**
     * function getBranchList
     * @author ZLei
     * @date 2017/9/30
     * @todo 获取支部列表
     */
    public JSONObject getBranchList();

    /**
     * function getBranchByID
     * @author ZLei
     * @date 2017/9/30
     * @todo 获取支部详细信息
     */
    public Branch getBranchByID(String bid);

    /**
     * function getRecordList
     * @author ZLei
     * @date 2017/9/30
     * @todo 获取支部详细信息
     */
    public JSONObject getRecordList();

    public Record getRecordByID(int rid);

}
