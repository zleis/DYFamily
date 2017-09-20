package npu.manager.global;

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

    /**
     * session 表示的含义
     * 1. session.uid : 登录用户ID
     * 2. session.login_con : 用户登录状态 0. 未登录, 1.普通用户登录, 2. 管理员登录
     *
     */

}
