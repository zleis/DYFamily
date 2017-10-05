package npu.manager.global;

import java.text.SimpleDateFormat;

/**
 * Created by  on .
 *
 * @version ${version}
 * @autor ZLei
 * @date 2017/9/16
 * @todo 公用变量
 */
public class GlobalVariable {

    public static final int REQUEST_SUCCESS = 10000; // 用户请求正确
    public static final int LOGIN_ERROR = 10001; // 登录失败
    public static final int UPLOAD_FILE_ERROR = 10002; // 文件上传出错
    public static final int NO_USER_LOGIN = 10003; // 用户未登录
    public static final int PARAM_IS_NULL = 10004; // HTTP请求信息不完整
    public static final int param_TYPE_ERROR = 10005; // 参数类型出错
    public static final int USER_IS_NULL = 10006; // 用户不存在
    public static final int GET_NOTICE_ERROR = 10007; // 获取公告失败

    public static final int REGISTER_IDNOTNUM_ERROR = 11001; // 用户id不是数字
    public static final int REGISTER_IDLENGTH_ERROR = 11002; // 用户id不是数字

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * session 表示的含义
     * 1. session.uid : 登录用户ID
     * 2. session.login_con : 用户登录状态 0. 未登录, 1.普通用户登录, 2. 管理员登录
     *
     */

    public static final String USER_LOGIN_CON = "1";
    public static final String MANAGER_LOGIN_CON = "2";
    public static final String NO_USER_LOGIN_CON = "0";
    public static final String HOST = "http://localhost:8080";

    public static final String TEST_UID = "2017203133";
}
