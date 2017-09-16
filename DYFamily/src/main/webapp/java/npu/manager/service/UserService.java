package npu.manager.service;

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
}
