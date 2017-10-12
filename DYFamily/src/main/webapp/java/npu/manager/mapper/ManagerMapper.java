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
    public int getNoticeLen();


    /**
     * function addUser
     * @author Mike
     * @date 2017/9/30
     * @todo 注册一个用户,只录入id与密码信息
     */
    public void addUser(@Param(value = "uid") String uid, @Param(value = "pass") String pass);

    /**
     * function addReadTimes
     * @author Mike
     * @date 2017/9/30
     * @todo 添加阅读次数
     */
    public void addReadTimes(@Param(value = "nid")int nid);

    /**--------------------------- 管理员 -----------------------------*/

    /**
     * function getManagerByID
     * @author ZLei
     * @date 2017/9/19
     * @param mid
     * @return Manager
     * @todo 通过UID查找管理员信息
     */
    public Manager getManagerByID(@Param(value = "mid") String mid);

    /* ----------  公告操作  ------------- */
    /**
     * function
     * @author ZLei
     * @date 2017/9/28
     * @todo 获取公告列表
     */
    public List<Notice> getNoticeList();

    /**
     * function addNotice
     * @author ZLei
     * @date 2017/9/28
     * @todo 添加公告
     */
    public void addNotice(Notice notice);

    /**
     * function getUserNoticeList
     * @author ZLei
     * @date 2017/9/28
     * @todo 获取某个用户的公告列表
     */
    public UserNotice getUserNoticeList(@Param(value = "uid") String uid, @Param(value = "nid") int nid);

    /**
     * function insertReadNotice
     * @author ZLei
     * @date 2017/9/28
     * @todo 添加已读公告
     */
    public void insertReadNotice(@Param(value = "uid") String uid, @Param(value = "nid")int nid);

    /**
     * function insertReadNotice
     * @author ZLei
     * @date 2017/9/28
     * @todo 修改公告标题内容
     */
    public void updateNotcie(@Param(value = "nid")int nid, @Param(value = "title") String title,@Param(value = "detail") String detail);

    /**
     * function delNotice
     * @author ZLei
     * @date 2017/9/28
     * @todo 删除公告
     */
    public void delNotice(@Param(value = "nid")int nid);
    public void delUserNotice(@Param(value = "nid")int nid);

    /* ---------  用户操作  ----------- */
    /**
     * function getUserList
     * @author ZLei
     * @date 2017/9/28
     * @todo 获取用户列表
     */
    public List<User> getUserList();



    /* ------------  支部操作  ------------- */
    /**
     * function getBranchList
     * @author ZLei
     * @date 2017/9/28
     * @todo 获取支部列表
     */
    public List<Branch> getBranchList();


    /**
     * function addBranch
     * @author ZLei
     * @date 2017/9/28
     * @todo 添加支部
     */
    public void addBranch(@Param(value = "bid") String bid,
                          @Param(value = "bName") String bName,
                          @Param(value = "bDes") String bDes);


    /**
     * function editBranch
     * @author ZLei
     * @date 2017/9/28
     * @todo 修改支部
     */
    public void editBranch(@Param(value = "bid") String bid,
                           @Param(value = "bName") String bName,
                           @Param(value = "bDes") String bDes);

    /**
     * function getBranchByID
     * @author ZLei
     * @date 2017/9/28
     * @todo 通过支部查找ID
     */
    public Branch getBranchByID(@Param(value = "bid") String bid);

    /* ------------  支部活动操作  ------------- */

    /**
     * function insertRecord
     * @author ZLei
     * @date 2017/9/28
     * @todo 添加Record
     */
    public void insertRecord(Record record);

    /**
     * function getRecordList
     * @author ZLei
     * @date 2017/9/28
     * @todo 获取Record列表
     */
    public List<Record> getRecordList();

    public Record getRecordByID(@Param(value = "rid") int rid);

    /**
     * function updateRecord
     * @author ZLei
     * @date 2017/9/28
     * @todo 更新Record
     */
    public void updateRecord(Record record);

    /**
     * function delRecord
     * @author ZLei
     * @date 2017/9/28
     * @todo 更新Record
     */
    public void delRecord(@Param(value = "rid") int rid);

    public List<Advice> getAdviceList();


    /* ------------------------------  暂时用不到的操作  ------------------------------ */
    /**
     * @todo 获取用户个数
     */
    public int getUserListLen();


    /**
     * function delBranch
     * @author ZLei
     * @date 2017/9/28
     * @todo 删除支部
     */
    public void delBranch(@Param(value = "bid") String bid);

    /**
     *
     * @return 获取支部列表长度
     */
    public int getBranchListLen();


}
