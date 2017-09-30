package npu.manager.serviceImp;

import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.Manager;
import npu.manager.beans.Notice;
import npu.manager.beans.UserNotice;
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
@Service
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

}
