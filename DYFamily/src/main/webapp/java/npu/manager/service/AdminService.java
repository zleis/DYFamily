package npu.manager.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.Map;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/19
 * @todo
 */
@Service()
public interface AdminService {

    /**
     * function adminLogin
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson HTTP 请求参数 {uid:用户ID,pass:用户密码}
     * @return int HTTP请求状态
     * @todo 管理员登录
     */
    public int adminLogin(JSONObject paramJson);

    /**
     * function getNoticeByID
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson HTTP 请求参数
     * @return int HTTP请求状态
     * @todo 根据ID获取公告
     */
    public int getNoticeByID(JSONObject paramJson,JSONObject resJson);

    /**
     * function addNotice
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson HTTP 请求参数
     * @return int HTTP请求状态
     * @todo 添加公告
     */
    public int addNotice(JSONObject paramJson,JSONObject resJson);

    /**
     * function editNotice
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson HTTP 请求参数
     * @return int HTTP请求状态
     * @todo 修改公告
     */
    public int editNotice(JSONObject paramJson,JSONObject resJson);

    /**
     * function delNotice
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson HTTP 请求参数
     * @return int HTTP请求状态
     * @todo 删除公告
     */
    public int delNotice(JSONObject paramJson,JSONObject resJson);

    /**
     * function addBranch
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson HTTP 请求参数
     * @return int HTTP请求状态
     * @todo 添加支部
     */
    public int addBranch(JSONObject paramJson,JSONObject resJson);

    /**
     * function delBranch
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson HTTP 请求参数
     * @return int HTTP请求状态
     * @todo 删除支部
     */
    public int delBranch(JSONObject paramJson,JSONObject resJson);

    /**
     * function editBranch
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson HTTP 请求参数
     * @return int HTTP请求状态
     * @todo 修改支部
     */
    public int editBranch(JSONObject paramJson,JSONObject resJson);

    /**
     * function adminLookUpUser
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson {uid:用户ID, uName:用户名称}
     * @return int 返回查询状态执行情况
     * @todo
     */
    public int adminLookUpUser(Map<String, String> paramMap,JSONObject resJson);
}
