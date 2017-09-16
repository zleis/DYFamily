package npu.manager.controller;

import com.alibaba.fastjson.JSONObject;
import npu.manager.global.GlobalFun;
import npu.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/16
 * @todo
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String Test(Model model){
        model.addAttribute("name","test");
        return "hello";
    }


    /**
     * function userLogin
     * @author ZLei
     * @date 2017/9/16
     * @param request
     * @return java.lang.String
     * @todo 用户登录后台判断
     * 请求时密码是md5加密
     */
    @RequestMapping("/userLogin")
    @ResponseBody
    public String userLogin(HttpServletRequest request){
        JSONObject resJson = new JSONObject();
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        int feedback = userService.userLogin(paramJson);
        resJson.put("feedback",feedback);
        return resJson.toString();
    }

    /**
     * function userRegister
     * @author ZLei
     * @date 2017/9/16
     * @param request
     * @return java.lang.String
     * @todo 用户新账号注册
     */
    @RequestMapping("/userRegister")
    @ResponseBody
    public String userRegister(HttpServletRequest request){
        JSONObject resJson = new JSONObject();

        /**
         * todo
         */

        return resJson.toString();
    }

}
