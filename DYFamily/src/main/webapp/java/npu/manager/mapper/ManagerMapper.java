package npu.manager.mapper;

import npu.manager.beans.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/16
 * @todo 数据库查询操作
 */
public interface ManagerMapper{
    /**
     * function getUserByID
     * @author ZLei
     * @date 2017/9/19 
     * @param uid
     * @return  User
     * @todo 通过UID查找User
     */
    public User getUserByID(@Param(value = "uid") String uid);

    /**
     * function getManagerByID
     * @author ZLei
     * @date 2017/9/19 
     * @param mid
     * @return Manager
     * @todo 通过UID查找管理员信息
     */
    public Manager getManagerByID(@Param(value = "mid") String mid);
    
    /**
     * function getNoticeTitleList
     * @author ZLei
     * @date 2017/9/24 
     * @param num 列表的
     * @return 返回通告列表
     * @todo 获取通知列表中的前num个，首先按照是否阅读排序，其次按照时间排序
     */
    public UserNotice getNoticeTitleList(@Param(value = "uid") String uid, @Param(value = "start") int start, @Param(value = "itemNum") int num);

    /**
     * function getNoticeByID
     * @author ZLei
     * @date 2017/9/24 
     * @param id
     * @return 返回当前公告
     * @todo 通过ID获取公告
     */
    public Notice getNoticeByID(@Param(value = "nid")int id);
    
    /**
     * function setNoticeRead
     * @author ZLei
     * @date 2017/9/25 
     * @param uid,nid
     * @todo 设置某个用户的公告为已读
     */
    public void setNoticeRead(@Param(value = "uid") String uid,@Param(value = "nid") int nid);
    
    /**
     * function addAdvice
     * @author ZLei
     * @date 2017/9/25
     * @todo 添加意见
     */
    public void addAdvice(Advice advice);
    
    /**
     * function getNoticeLen
     * @author ZLei
     * @date 2017/9/27
     * @todo 获取公告的数量
     */
    public int getNoticeLen(@Param(value = "uid") String uid);

    /**
     * function addUser
     * @author Mike
     * @date 2017/9/30
     * @todo 注册一个用户,只录入id与密码信息
     */
    public void addUser(@Param(value = "uid") String uid, @Param(value = "pass") String pass);

    public List<User> getUserListByInfo(Map<String, Object> map);
}
