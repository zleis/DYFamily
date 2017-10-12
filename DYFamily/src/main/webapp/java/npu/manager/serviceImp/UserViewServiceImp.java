package npu.manager.serviceImp;

import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.Branch;
import npu.manager.beans.Record;
import npu.manager.beans.User;
import npu.manager.mapper.ManagerMapper;
import npu.manager.service.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/29
 * @todo
 */
@Service("userViewService")
public class UserViewServiceImp implements UserViewService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public User getUserByID(String uid) {
        System.out.println(uid);
        User user = managerMapper.getUserByID(uid);
        System.out.println(user.toString());
        return user;
    }

    @Override
    public JSONObject getBranchList() {
        JSONObject resJson = new JSONObject();
        List<Branch> branchList = managerMapper.getBranchList();
        for(Branch branch:branchList){
            branch.setEncoding();
        }
        resJson.put("branchList",branchList);
        return resJson;
    }
}
