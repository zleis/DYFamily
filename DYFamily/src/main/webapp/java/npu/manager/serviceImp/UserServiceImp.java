package npu.manager.serviceImp;


import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.User;
import npu.manager.global.GlobalVariable;
import npu.manager.service.UserService;
import npu.manager.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/16
 * @todo
 */
@Service("userService")
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
        String uid = ((String[])paramJson.get("uid"))[0];
        String pass = ((String[])paramJson.get("pass"))[0];
        User loginUser  = managerMapper.getUserByID(uid);
        if(!loginUser.getPass().equals(pass)){
            return GlobalVariable.LOGIN_ERROR;
        }
        return GlobalVariable.REQUEST_SUCCESS;
    }
}
