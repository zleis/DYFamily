package npu.manager.controller;

import com.alibaba.fastjson.JSONObject;
import npu.manager.global.GlobalFun;
import npu.manager.global.GlobalVariable;
import npu.manager.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.mangofactory.swagger.paths.RelativeSwaggerPathProvider.ROOT;

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

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

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
        if(feedback == GlobalVariable.REQUEST_SUCCESS){
            HttpSession session = request.getSession();
            session.setAttribute("uid",((String[]) paramJson.get("uid"))[0]);
            session.setAttribute("login_con",1);
        }
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

    /**
     * function updateUserInfo
     * @author ZLei
     * @date 2017/9/16
     * @param request
     * @return java.lang.String
     * @todo 更新个人信息
     */
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public String updateUserInfo(HttpServletRequest request){

        JSONObject resJson = new JSONObject();

        /**
         * todo
         */

        return resJson.toString();

    }

    /**
     * function uploadImage
     * @author ZLei
     * @date 2017/9/17
     * @param multipartFile, request
     * @return java.lang.String
     * @todo 用户上传照片
     */
    @RequestMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){

        JSONObject resJson = new JSONObject();
        HttpSession session = request.getSession();
        session.setAttribute("uid","2017203133");
        if(!multipartFile.isEmpty()){
            String path = "src/main/webapp/resources/static/uploadImage/";
            GlobalFun.fileUpload(path,session.getAttribute("uid") + ".jpg",multipartFile);
        }
        /**
         * todo
         */

        return resJson.toString();
    }
}
