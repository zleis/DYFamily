package npu.manager.mapper;

import npu.manager.beans.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/16
 * @todo 数据库查询操作
 */
public interface ManagerMapper{
    public User getUserByID(@Param(value = "uid") String uid);
}
