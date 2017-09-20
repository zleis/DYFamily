package npu.manager.serviceImp;

import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.Manager;
import npu.manager.beans.User;
import npu.manager.global.GlobalVariable;
import npu.manager.mapper.ManagerMapper;
import npu.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/19
 * @todo 管理员服务
 */
public class AdminServiceImp implements AdminService {

    @Autowired
    private ManagerMapper managerMapper; // 数据库

    public AdminServiceImp() {
    }

    @Override
    public int adminLogin(JSONObject paramJson) {

        if((!paramJson.containsKey("uid")) || !paramJson.containsKey("pass")){
            return GlobalVariable.LOGIN_ERROR;
        }
        String uid = (String)paramJson.get("uid");
        String pass = (String)paramJson.get("pass");
        Manager loginManager  = managerMapper.getManagerByID(uid);
        if(!loginManager.getPass().equals(pass)){
            return GlobalVariable.LOGIN_ERROR;
        }
        return GlobalVariable.REQUEST_SUCCESS;
    }

    @Override
    public int adminLookUpUser(Map<String, String> paramMap,JSONObject resJson) {

//        List<User> userList = managerMapper.getUserListByInfo(paramMap)


        return 0;
    }
}
