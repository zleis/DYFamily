package npu.manager.service;

import com.alibaba.fastjson.JSONObject;

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

}
