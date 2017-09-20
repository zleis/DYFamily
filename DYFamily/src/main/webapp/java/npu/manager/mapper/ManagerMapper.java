package npu.manager.mapper;

import npu.manager.beans.Manager;
import npu.manager.beans.User;
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
     * @param uid
     * @return Manager
     * @todo 通过UID查找管理员信息
     */
    public Manager getManagerByID(@Param(value = "mid") String mid);

    public List<User> getUserListByInfo(Map<String, Object> map);
}
