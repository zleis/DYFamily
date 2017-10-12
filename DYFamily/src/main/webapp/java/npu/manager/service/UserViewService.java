package npu.manager.service;

import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.User;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/29
 * @todo 用户界面
 */
public interface UserViewService {
    public User getUserByID(String uid);
    /**
     * function getBranchList
     * @author ZLei
     * @date 2017/9/30
     * @todo 获取支部列表
     */
    public JSONObject getBranchList();
}
