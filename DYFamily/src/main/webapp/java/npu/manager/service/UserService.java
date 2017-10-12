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
     * function getNoticeTitleList
     * @author ZLei
     * @date 2017/9/24
     * @param paramJson, resJson
     * @return int
     * @todo 获取公告标题列表
     */
    public int getNoticeTitleList(JSONObject paramJson, JSONObject resJson);

    /**
     * function getNoticeByID
     * @author ZLei
     * @date 2017/9/25
     * @param paramJson, resJson
     * @return int
     * @todo
     */
    public int getNoticeByID(JSONObject paramJson, JSONObject resJson);


    /**
     * function setNoticeRead
     * @author ZLei
     * @date 2017/9/25 
     * @param paramJson{"uid":用户id, "nid":公告ID}
     * @return 
     * @todo 设置某个用户的公告为已读
     */
    public void setNoticeRead(JSONObject paramJson);
    
    /**
     * function giveAdvice
     * @author ZLei
     * @date 2017/9/26
     * @todo 用户提交意见
     */
    public int giveAdvice(JSONObject paramJson);

    /***********--------------完成中-------------------------*/



    /***********--------------未完成-------------------------*/

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

    /**
     * function userRegister
     * @author Mike
     * @date 2017/9/16
     * @param paramJson
     * @return int 用户注册状态
     * @todo 判断用户注册
     */
    public int userRegister(JSONObject paramJson);


    /**
     * function updateUserInfo
     * @author Mike
     * @date 2017/10/12
     * @param paramJson
     * @return int 完善信息状态
     * @todo 完善个人信息
     */
    public int updateUserInfo(JSONObject paramJson);

}
