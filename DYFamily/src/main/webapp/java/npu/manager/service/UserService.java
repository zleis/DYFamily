package npu.manager.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/16
 * @todo
 */

public interface UserService {

    /**
     * function userLogin
     * @author ZLei
     * @date 2017/9/16
     * @param paramJson
     * @return int 用户登录状态
     * @todo 判断用户登录
     */
    public int userLogin(JSONObject paramJson);

    /**
     * function userAddNewRecord
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson Http请求参数 {"recordTime":"报告时间", "recordPlace":"报告地点","recordHost":"主持人",
     *                  "recorder":"记录人", "recordExpectPeople":"会议人数","recordRealPeople":"实际到会人数"
     *                  "recordType":"会议类型","recordDetail":"会议内容"}
     *
     * @return int
     * @todo 用户添加组织生活新记录
     */
    public int userAddNewRecord(JSONObject paramJson);
}
