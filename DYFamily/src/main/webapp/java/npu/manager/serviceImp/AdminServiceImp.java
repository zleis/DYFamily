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
        if(loginManager == null){
            return GlobalVariable.LOGIN_ERROR;
        }
        if(!loginManager.getPass().equals(pass)){
            return GlobalVariable.LOGIN_ERROR;
        }
        return GlobalVariable.REQUEST_SUCCESS;
    }

    /*------------------------- 公告管理 ---------------------------*/
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
    public int editNotice(JSONObject paramJson, JSONObject resJson) {
        // 判断参数是否完整
        if(!paramJson.containsKey("nid") || !paramJson.containsKey("title") || !paramJson.containsKey("detail")){
            return GlobalVariable.PARAM_IS_NULL;
        }
        String title = paramJson.getString("title"); // 意见大标题
        String detail = paramJson.getString("detail"); // 意见内容
        int nid = 0;
        try {
            nid = Integer.parseInt(paramJson.getString("nid"));
        }catch (Exception e){
            return GlobalVariable.param_TYPE_ERROR;
        }

        managerMapper.updateNotcie(nid,title,detail);

        return GlobalVariable.REQUEST_SUCCESS;
    }

    @Override
    public int delNotice(JSONObject paramJson, JSONObject resJson) {

        if(!paramJson.containsKey("nid")){
            return GlobalVariable.PARAM_IS_NULL;
        }

        int nid;
        try{
            nid = Integer.parseInt(paramJson.getString("nid"));
        }catch (Exception e){
            return GlobalVariable.param_TYPE_ERROR;
        }
        managerMapper.delUserNotice(nid);
        managerMapper.delNotice(nid);
        return GlobalVariable.REQUEST_SUCCESS;
    }

    /*------------------------- 支部管理 ---------------------------*/
    @Override
    public int addBranch(JSONObject paramJson, JSONObject resJson) {
        if(!paramJson.containsKey("branchID") || !paramJson.containsKey("branchName") || !paramJson.containsKey("branchDes")){
            return GlobalVariable.PARAM_IS_NULL;
        }

        String branchID = paramJson.getString("branchID");
        String branchName = paramJson.getString("branchName");
        String branchDes = paramJson.getString("branchDes");
        managerMapper.addBranch(branchID, branchName, branchDes);
        return GlobalVariable.REQUEST_SUCCESS;
    }

    @Override
    public int delBranch(JSONObject paramJson, JSONObject resJson) {

        if(!paramJson.containsKey("bid")){
            return GlobalVariable.PARAM_IS_NULL;
        }

        String bid = paramJson.getString("bid");
        return 0;
    }

    @Override
    public int editBranch(JSONObject paramJson, JSONObject resJson) {
        if(!paramJson.containsKey("branchID") || !paramJson.containsKey("branchName") || !paramJson.containsKey("branchDes")){
            return GlobalVariable.PARAM_IS_NULL;
        }

        String branchID = paramJson.getString("branchID");
        String branchName = paramJson.getString("branchName");
        String branchDes = paramJson.getString("branchDes");
        managerMapper.editBranch(branchID, branchName, branchDes);
        return GlobalVariable.REQUEST_SUCCESS;
    }

    @Override
    public int adminLookUpUser(Map<String, String> paramMap,JSONObject resJson) {

//        List<User> userList = managerMapper.getUserListByInfo(paramMap)


        return 0;
    }
}
