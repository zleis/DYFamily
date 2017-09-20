package npu.manager.service;

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
     * function adminLookUpUser
     * @author ZLei
     * @date 2017/9/19
     * @param paramJson {uid:用户ID, uName:用户名称}
     * @return int 返回查询状态执行情况
     * @todo
     */
    public int adminLookUpUser(Map<String, String> paramMap,JSONObject resJson);
}
