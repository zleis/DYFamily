package npu.manager.serviceImp;

import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.*;
import npu.manager.global.GlobalVariable;
import npu.manager.mapper.ManagerMapper;
import npu.manager.service.AdminService;
import npu.manager.service.AdminViewService;
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
@Service("adminViewService")
public class AdminViewServiceImp implements AdminViewService{

    @Autowired
    private ManagerMapper managerMapper; // 数据库


    @Override
    public int getAdminPower(String uid) {

        Manager manager  = managerMapper.getManagerByID(uid);
        return manager.getPower();
    }

    @Override
    public JSONObject getNoticeList() {
        JSONObject resJson = new JSONObject();
        List<Notice> noticeList = managerMapper.getNoticeList();
        for(Notice notice:noticeList){
            notice.setEncoding();
        }
        resJson.put("noticeList",noticeList);
        resJson.put("noticeLen", managerMapper.getNoticeLen());
        return resJson;
    }

    @Override
    public Notice getNoticeByID(int nid) {
        Notice notice = managerMapper.getNoticeByID(nid);
        return notice;
    }

    @Override
    public JSONObject getUserList() {
        JSONObject resJson = new JSONObject();
        List<User> userList = managerMapper.getUserList();
        for(User user:userList){
            user.setEncoding();
        }
        resJson.put("userList",userList);
//        resJson.put("userLen", managerMapper.getUserListLen());
        return resJson;
    }

    @Override
    public JSONObject getUserByID(String uid) {
        JSONObject resJson = new JSONObject();
        User user = managerMapper.getUserByID(uid);
        user.setPass("");
        if(user.getBid()!=null){
            List<Branch> branchList = managerMapper.getBranchList();
            for(Branch branch:branchList){
                if(user.getBid().equals(branch.getBid())){
                    resJson.put("userBranchName",branch.getbName());
                    break;
                }
            }
        }
        user.setEncoding();
        resJson.put("user",user);
        return resJson;
    }

    @Override
    public JSONObject getBranchList() {
        JSONObject resJson = new JSONObject();
        List<Branch> branchList = managerMapper.getBranchList();
        for(Branch branch:branchList){
            branch.setEncoding();
        }
        resJson.put("branchList",branchList);
//        System.out.println(resJson.toString());
        return resJson;
    }

    @Override
    public Branch getBranchByID(String bid) {
        Branch branch = managerMapper.getBranchByID(bid);
        return branch;
    }

    @Override
    public JSONObject getRecordList() {
        JSONObject resJson = new JSONObject();
        List<Record> recordList = managerMapper.getRecordList();
        for(Record record:recordList){
            record.setEncoding();
        }
        resJson.put("recordList",recordList);
//        System.out.println(resJson.toString());
        return resJson;
    }

    @Override
    public Record getRecordByID(int rid) {
        Record record = managerMapper.getRecordByID(rid);
//        System.out.println(record.toString());
//        record.setEncoding();
        return record;
    }
}
