package npu.manager.serviceImp;


import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.objects.Global;
import npu.manager.beans.Advice;
import npu.manager.beans.Notice;
import npu.manager.beans.User;
import npu.manager.beans.UserNotice;
import npu.manager.global.GlobalFun;
import npu.manager.global.GlobalVariable;
import npu.manager.service.UserService;
import npu.manager.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.regex.Pattern;

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
        String uid = (String)paramJson.get("uid");
        String pass = (String)paramJson.get("pass");
        User loginUser  = managerMapper.getUserByID(uid);
        if(loginUser == null){
            return GlobalVariable.USER_IS_NULL;
        }
        if(!loginUser.getPass().equals(pass)){
            return GlobalVariable.LOGIN_ERROR;
        }
        return GlobalVariable.REQUEST_SUCCESS;
    }

    @Override
    public int userAddNewRecord(JSONObject paramJson) {

        if(!paramJson.containsKey("recordTime")){

        }


        return 0;
    }

    @Override
    public int getNoticeTitleList(JSONObject paramJson, JSONObject resJson) {

        // 检查参数完整性
        if(!paramJson.containsKey("itemNum") || !paramJson.containsKey("limit")){
//            resJson.
            return GlobalVariable.PARAM_IS_NULL;
        }

        // 获取参数
        String uid = paramJson.getString("uid");
        String itemNumStr = paramJson.getString("itemNum");
        String limitStr = paramJson.getString("limit");
        int itemNum = 0;
        int limit = 0;
        try {
            itemNum = Integer.parseInt(itemNumStr);
            limit = Integer.parseInt(limitStr);
        }catch (Exception e){
            return GlobalVariable.param_TYPE_ERROR;
        }

        // 操作
        UserNotice userNotice = managerMapper.getNoticeTitleList(uid, itemNum, limit);
        if(userNotice == null){
            return GlobalVariable.GET_NOTICE_ERROR;
        }
        userNotice.setEncoding(); // 设置编码
        resJson.put("noticeList",userNotice);
        if(paramJson.containsKey("isGetLen") && paramJson.getString("isGetLen").equals("1")){
            resJson.put("noticeLen", managerMapper.getNoticeLen());
        }

        System.out.println(((Notice) userNotice.getNoticeList().get(0)).toString());

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
        String uid = paramJson.getString("uid");
        int nid = 0;
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
        managerMapper.addReadTimes(nid);
        notice.setEncoding();
        resJson.put("notice",notice);
        return GlobalVariable.REQUEST_SUCCESS;
    }

    @Override
    public void setNoticeRead(JSONObject paramJson) {
        try{
            int nid = Integer.parseInt(paramJson.getString("nid"));
            String uid = paramJson.getString("uid");
            UserNotice userNotice = managerMapper.getUserNoticeList(uid,nid);
            if(userNotice == null){
                managerMapper.insertReadNotice(uid, nid);
            }else{
                managerMapper.setNoticeRead(uid, nid);
            }

        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            System.out.println("setNoticeRead error");

        }
    }

    @Override
    public int giveAdvice(JSONObject paramJson) {

        // 判断参数是否完整
        if(!paramJson.containsKey("title") || !paramJson.containsKey("advice")){
            return GlobalVariable.PARAM_IS_NULL;
        }

        // 获取参数
        String uid = paramJson.getString("uid"); // 用户ID
        String title = paramJson.getString("title"); // 意见大标题
        String detail = paramJson.getString("detail"); // 意见内容
        Date createTime = new Date();
        User user = managerMapper.getUserByID(uid);
        String bid = user.getBid();
        Advice advice = new Advice(uid,bid, createTime,title,detail);
        managerMapper.addAdvice(advice);
        return GlobalVariable.REQUEST_SUCCESS;
    }

    @Override
    public int userRegister(JSONObject paramJson) {

        if((!paramJson.containsKey("uid")) || (!paramJson.containsKey("pass1")) ) {
            return GlobalVariable.LOGIN_ERROR;
        }
        String uid = (String)paramJson.get("uid");
        String pass1 = (String)paramJson.get("pass1");
        //判断uid是否为数字，位数10
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(uid).matches()) {
            if (uid.length() == 10) {
                //数据库存储数据,包括用户名和密码
                managerMapper.addUser(uid,pass1);
                return GlobalVariable.REQUEST_SUCCESS;
            }else {
                return GlobalVariable.REGISTER_IDLENGTH_ERROR;
            }
        } else {
            return GlobalVariable.REGISTER_IDNOTNUM_ERROR;
        }
    }
}
