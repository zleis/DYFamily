package npu.manager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.Branch;
import npu.manager.beans.Notice;
import npu.manager.beans.Record;
import npu.manager.global.GlobalFun;
import npu.manager.global.GlobalVariable;
import npu.manager.service.AdminViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/30
 * @todo
 */
@Controller
@RequestMapping("/adminView")
public class AdminViweController {

    @Autowired
    private AdminViewService adminViewService;
    /**
     * function userLogin
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  用户登录页面
     */
    @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userLogin(){
        ModelAndView model = new ModelAndView();
        model.setViewName("admin/Login");
        return model;
    }

    /**
     * function userLogin
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  用户主页面
     */
    @RequestMapping(value = "/adminIndex", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userIndex(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model = new ModelAndView();

        HttpSession session = request.getSession();
        if(session.getAttribute("login_con") == null || !session.getAttribute("login_con").equals("2")){
            model.setViewName("admin/Login");
            return model;
        }

        adminViewService.getAdminPower((String)session.getAttribute("uid"));
        JSONObject jsonObject = GlobalFun.getMenu(1);
        model.addObject("menu",jsonObject);
        model.addObject("userName",session.getAttribute("uid"));
        model.setViewName("admin/Index");
        return model;
    }

    /**
     * function userLogin
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  用户主页面
     */
    @RequestMapping(value = "/listNotice", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView listNotice(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("login_con") == null || !session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }
        JSONObject msg = adminViewService.getNoticeList();

        model.addObject("noticeList",(List<Notice>)msg.get("noticeList"));
        model.addObject("noticeLen",msg.getIntValue("noticeLen"));
        model.setViewName("admin/noticeList");
        return model;
    }

    /**
     * function noticeItem
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  公告详情
     */
    @RequestMapping(value = "/noticeItem", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView noticeItem(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("login_con") == null || !session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }
        model.setViewName("admin/noticeItem");
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        model.addObject("nid",paramJson.getString("nid"));
        return model;
    }

    /**
     * function addNotice
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  添加公告
     */
    @RequestMapping(value = "/addNotice", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView addNotice(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("login_con") == null || !session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }
        model.setViewName("admin/noticeAdd");
        return model;
    }

    /**
     * function editNotice
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  修改公告
     */
    @RequestMapping(value = "/editNotice", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView editNotice(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        Notice notice = adminViewService.getNoticeByID(Integer.parseInt(paramJson.getString("nid")));

        model.addObject("nid",paramJson.getString("nid"));
        model.addObject("notice",notice);
        model.setViewName("admin/noticeEdit");
        return model;
    }


    /*---------------------------------user----------------------------------*/

    /**
     * function userList
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  用户列表
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userList(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("login_con") == null || !session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }

        JSONObject msg = adminViewService.getUserList();
        JSONObject branchMsg = adminViewService.getBranchList();

        model.addObject("userList",msg.get("userList"));
        model.addObject("branchList",branchMsg.get("branchList"));

        model.setViewName("admin/userList");
        return model;
    }

    /**
     * function userList
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  用户列表
     */
    @RequestMapping(value = "/userItem", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userItem(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("login_con") == null || !session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }

        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        JSONObject msg = adminViewService.getUserByID(paramJson.getString("uid"));
        model.addObject("user",msg.get("user"));
        model.addObject("userBranchName",msg.get("userBranchName"));
        model.setViewName("admin/userItem");
        return model;
    }

    /*---------------------------------branch----------------------------------*/

    /**
     * function branchList
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  支部列表
     */
    @RequestMapping(value = "/branchList", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView branchList(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }
        JSONObject msg = adminViewService.getBranchList();
        model.addObject("branchList",msg.get("branchList"));

        model.setViewName("admin/branchList");
        return model;
    }

    /**
     * function branchAdd
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  添加支部
     */
    @RequestMapping(value = "/branchAdd", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView branchAdd(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }

        model.setViewName("admin/branchAdd");
        return model;
    }

    /**
     * function branchEdit
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  修改支部
     */
    @RequestMapping(value = "/branchEdit", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView branchEdit(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        Branch msg = adminViewService.getBranchByID(paramJson.getString("bid"));
        model.addObject("branch",msg);
        model.setViewName("admin/branchEdit");
        return model;
    }


    /* ---------------------- 活动记录 ------------------------- */
    /**
     * function recordAdd
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  修改支部
     */
    @RequestMapping(value = "/recordAdd", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView recordAdd(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }
        JSONObject msg = adminViewService.getBranchList();
        model.addObject("branchList",msg.get("branchList"));
        model.setViewName("admin/recordAdd");
        return model;
    }

    /**
     * function recordList
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  活动记录列表
     */
    @RequestMapping(value = "/recordList", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView recordList(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }
        JSONObject branchMsg = adminViewService.getBranchList();
        JSONObject recordMsg = adminViewService.getRecordList();
//        System.out.println(recordMsg.toString());
        model.addObject("branchList",branchMsg.get("branchList"));
        model.addObject("recordList",recordMsg.get("recordList"));
        model.setViewName("admin/recordList");
        return model;
    }

    /**
     * function branchEdit
     * @author ZLei
     * @date 2017/9/27
     * @return
     * @todo  修改支部活动
     */
    @RequestMapping(value = "/recordEdit", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView recordEdit(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        JSONObject branchMsg = adminViewService.getBranchList();
        Record msg = adminViewService.getRecordByID(Integer.parseInt(paramJson.getString("rid")));

        model.addObject("record",msg);
        model.addObject("branchList",branchMsg.get("branchList"));
        model.setViewName("admin/recordEdit");
        return model;
    }

}
