package npu.manager.controller;

import com.alibaba.fastjson.JSONObject;
import npu.manager.global.GlobalFun;
import npu.manager.global.GlobalVariable;
import npu.manager.service.AdminService;
import npu.manager.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/19
 * @todo 管理员Controller
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    /**
     * function userLogin
     * @author ZLei
     * @date 2017/9/19
     * @param request, response
     * @return java.lang.String
     * @todo 管理员登录
     */
    @RequestMapping(value = "/managerLogin", method = RequestMethod.POST)
    @ResponseBody
    public String managerLogin(HttpServletRequest request, HttpServletResponse response){

        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        JSONObject resJson = new JSONObject();
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        int feedback = adminService.adminLogin(paramJson);
        if(feedback == GlobalVariable.REQUEST_SUCCESS){
            HttpSession session = request.getSession();
            session.setAttribute("uid",(String) paramJson.get("uid"));
            session.setAttribute("login_con","2");
        }
        resJson.put("feedback",feedback);
        return resJson.toString();
    }


    /*----------------------------------- 公告管理 --------------------------*/
    /**
     * function getNoticeByID
     * @author ZLei
     * @date 2017/9/25
     * @param request, response
     *        request:{"nid":公告ID}
     * @return java.lang.String
     * @todo 获取某个公告，并设置为已读
     */
    @RequestMapping( value = "/getNoticeByID", method = RequestMethod.POST)
    @ResponseBody
    public String getNoticeByID(HttpServletRequest request, HttpServletResponse response){

        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }

        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        int feedback = adminService.getNoticeByID(paramJson, resJson);
        resJson.put("feedback",feedback);
        return resJson.toString();
    }

    /**
     * function addNotice
     * @author ZLei
     * @date 2017/9/25
     * @return java.lang.String
     * @todo 添加公告
     */
    @RequestMapping( value = "/addNotice", method = RequestMethod.POST)
    @ResponseBody
    public String addNotice(HttpServletRequest request, HttpServletResponse response){
        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }

        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        int feedback = adminService.addNotice(paramJson, resJson);
        resJson.put("feedback",feedback);
        return resJson.toString();
    }

    /**
     * function editNotice
     * @author ZLei
     * @date 2017/9/25
     * @return java.lang.String
     * @todo 修改公告
     */
    @RequestMapping( value = "/editNotice", method = RequestMethod.POST)
    @ResponseBody
    public String editNotice(HttpServletRequest request, HttpServletResponse response){
        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }

        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        int feedback = adminService.editNotice(paramJson, resJson);
        resJson.put("feedback",feedback);
        return resJson.toString();
    }

    /**
     * function delNotice
     * @author ZLei
     * @date 2017/9/25
     * @return java.lang.String
     * @todo 删除公告
     */
    @RequestMapping( value = "/delNotice", method = RequestMethod.POST)
    @ResponseBody
    public String delNotice(HttpServletRequest request, HttpServletResponse response){
        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }

        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        int feedback = adminService.delNotice(paramJson, resJson);
        resJson.put("feedback",feedback);
        return resJson.toString();
    }


    /*----------------------------------- 支部管理 --------------------------*/

    /**
     * function addBranch
     * @author ZLei
     * @date 2017/9/25
     * @return java.lang.String
     * @todo 添加支部
     */
    @RequestMapping( value = "/addBranch", method = RequestMethod.POST)
    @ResponseBody
    public String addBranch(HttpServletRequest request, HttpServletResponse response){
        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }

        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        int feedback = adminService.addBranch(paramJson, resJson);
        resJson.put("feedback",feedback);
        return resJson.toString();
    }


    /**
     * function delBranch
     * @author ZLei
     * @date 2017/9/25
     * @return java.lang.String
     * @todo 添加支部
     */
    @RequestMapping( value = "/delBranch", method = RequestMethod.POST)
    @ResponseBody
    public String delBranch(HttpServletRequest request, HttpServletResponse response){
        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }

        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        int feedback = adminService.delBranch(paramJson, resJson);
        resJson.put("feedback",feedback);
        return resJson.toString();
    }

    /**
     * function delBranch
     * @author ZLei
     * @date 2017/9/25
     * @return java.lang.String
     * @todo 添加支部
     */
    @RequestMapping( value = "/editBranch", method = RequestMethod.POST)
    @ResponseBody
    public String editBranch(HttpServletRequest request, HttpServletResponse response){
        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        HttpSession session = request.getSession();
        JSONObject resJson = new JSONObject();

        if( session.getAttribute("login_con") == null || !session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            resJson.put("feedback", GlobalVariable.NO_USER_LOGIN);
            return resJson.toString();
        }

        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        int feedback = adminService.editBranch(paramJson, resJson);
        resJson.put("feedback",feedback);
        return resJson.toString();
    }



    @RequestMapping(value = "/mamagerLookUpUser", method = RequestMethod.POST)
    @ResponseBody
    public String managerLookUpUser(HttpServletRequest request, HttpServletResponse response){

        //设置AJAX跨域访问
        response.addHeader("Access-Control-Allow-Origin","*");

        JSONObject resJson = new JSONObject();
        HttpSession session = request.getSession();
        Map<String, String> paramMap = GlobalFun.getMapParamFromRequest(request);
        int feedback = adminService.adminLookUpUser(paramMap,resJson);
        resJson.put("feedback", feedback);
        /**
         * todo
         */

        return resJson.toString();

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        JSONObject json = GlobalFun.getMenu(12);
        return json.toString();
    }
}
