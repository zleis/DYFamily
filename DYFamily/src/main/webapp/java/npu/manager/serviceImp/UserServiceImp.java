package npu.manager.serviceImp;


import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.User;
import npu.manager.global.GlobalVariable;
import npu.manager.service.UserService;
import npu.manager.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/16
 * @todo
 */
public class UserServiceImp implements UserService {

    @Autowired
    private ManagerMapper managerMapper;

    public UserServiceImp() {
    }

    @Override
    public int userLogin(JSONObject paramJson) {

        if((!paramJson.containsKey("uid")) || !paramJson.containsKey("pass")){
            return GlobalVariable.LOGIN_ERROR;
        }

        String uid = paramJson.getString("uid");
        String pass = paramJson.getString("pass");
        User loginUser  = managerMapper.getUserByID(uid);
        if(!loginUser.getPass().equals(pass)){
            return GlobalVariable.LOGIN_ERROR;
        }
        return GlobalVariable.REQUEST_SUCCESS;
    }
}
