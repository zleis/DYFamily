package npu.manager.serviceImp;

import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.Manager;
import npu.manager.beans.Notice;
import npu.manager.beans.User;
import npu.manager.global.GlobalVariable;
import npu.manager.mapper.ManagerMapper;
import npu.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/19
 * @todo 管理员服务
 */
@Service
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
    public int getNoticeByID(JSONObject paramJson, JSONObject resJson) {


        // 判断参数是否充足
        if(!paramJson.containsKey("nid")){
            return GlobalVariable.PARAM_IS_NULL;
        }

        // 提取参数
        String nidStr = paramJson.getString("nid");
        int nid ;
        try{
            nid = Integer.parseInt(nidStr);
        }catch (Exception e){
            return GlobalVariable.param_TYPE_ERROR;
        }

        // 操作
        Notice notice = managerMapper.getNoticeByID(nid);
        if(notice == null){
            return GlobalVariable.GET_NOTICE_ERROR;
        }

        notice.setEncoding();
        resJson.put("notice",notice);
        return GlobalVariable.REQUEST_SUCCESS;
    }


    @Override
    public int addNotice(JSONObject paramJson, JSONObject resJson) {
        // 判断参数是否完整
        if(!paramJson.containsKey("title") || !paramJson.containsKey("detail")){
            return GlobalVariable.PARAM_IS_NULL;
        }
        String title = paramJson.getString("title"); // 意见大标题
        String detail = paramJson.getString("detail"); // 意见内容
        Date createTime = new Date();
        int readTime = 0;
        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setDetail(detail);
        notice.setCreateTimes(createTime);
        notice.setReadTimes(readTime);
        managerMapper.addNotice(notice);
        return GlobalVariable.REQUEST_SUCCESS;
    }

    @Override
    public int adminLookUpUser(Map<String, String> paramMap,JSONObject resJson) {

//        List<User> userList = managerMapper.getUserListByInfo(paramMap)


        return 0;
    }
}
