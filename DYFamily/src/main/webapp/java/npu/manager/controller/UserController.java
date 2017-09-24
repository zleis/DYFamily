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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    /**
     * function userLogin
     * @author ZLei
     * @date 2017/9/16
     * @param request
     * @return java.lang.String
     * @todo 用户登录后台判断
     * 请求时密码是md5加密
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(HttpServletRequest request, HttpServletResponse response){

        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        JSONObject resJson = new JSONObject();
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        int feedback = userService.userLogin(paramJson);
        if(feedback == GlobalVariable.REQUEST_SUCCESS){
            HttpSession session = request.getSession();
            session.setAttribute("uid",((String) paramJson.get("uid")));
            session.setAttribute("login_con","1");
        }
        resJson.put("feedback",feedback);
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
    @RequestMapping( value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response) throws IOException {


        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if(!session.getAttribute("login_con").equals("1")){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }

        if(!multipartFile.isEmpty()){
            String path = "src/main/webapp/resources/static/uploadImage/";
            GlobalFun.fileUpload(path,session.getAttribute("uid") + ".jpg",multipartFile);
        }
        return resJson.toString();
    }

    /**
     * function getNotictTitleList
     * @author ZLei
     * @date 2017/9/24
     * @param request, response
     * request: {"limit":"每页的个数"，"itemNum"：起始位置}
     * @return java.lang.String
     * @todo
     */
    @RequestMapping( value = "/noticeTitleList", method = RequestMethod.POST)
    @ResponseBody
    public String getNotictTitleList(HttpServletRequest request, HttpServletResponse response){


        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if(!session.getAttribute("login_con").equals("1")){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }


        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        paramJson.put("uid",session.getAttribute("uid"));
        int feedback = userService.getNoticeTitleList(paramJson,resJson);

        resJson.put("feedback",feedback);
        System.out.println(resJson.toString());
        return resJson.toString();
    }







    /*********--------------完成中----------------------***************/

    @RequestMapping( value = "/getNoticeByID", method = RequestMethod.POST)
    @ResponseBody
    public String getNoticeByID(HttpServletRequest request, HttpServletResponse response){
        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if(!session.getAttribute("login_con").equals("1")){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }


        JSONObject paramJson = GlobalFun.getParamFromRequest(request);

        int feedback = userService.getNoticeByID(paramJson, resJson);

        return resJson.toString();
    }



    /*********--------------未完成----------------------***************/





    /**
     * function userRegister
     * @author ZLei
     * @date 2017/9/16
     * @param request
     * @return java.lang.String
     * @todo 用户新账号注册
     */
    @RequestMapping( value = "/userRegister",method = RequestMethod.POST)
    @ResponseBody
    public String userRegister(HttpServletRequest request, HttpServletResponse response){

        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

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
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public String updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        // 未登录
        if(!session.getAttribute("login_con").equals("1")){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }



        /**
         * todo
         */

        return resJson.toString();

    }



    @RequestMapping( value = "/addNewRecord", method = RequestMethod.POST)
    @ResponseBody
    public String addNewRecord(HttpServletRequest request, HttpServletResponse response){

        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if(!session.getAttribute("login_con").equals("1")){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }

        JSONObject paramJson = GlobalFun.getParamFromRequest(request);

        return resJson.toString();

    }


}
