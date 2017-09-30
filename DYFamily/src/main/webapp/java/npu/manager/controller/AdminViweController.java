package npu.manager.controller;

import com.alibaba.fastjson.JSONObject;
import npu.manager.beans.Notice;
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
        if(!session.getAttribute("login_con").equals(GlobalVariable.MANAGER_LOGIN_CON)){
            model.setViewName("admin/Login");
            return model;
        }
        JSONObject msg = adminViewService.getNoticeList();

        model.addObject("noticeList",(List<Notice>)msg.get("noticeList"));
        model.addObject("noticeLen",msg.getIntValue("noticeLen"));
        model.setViewName("admin/noticeList");
        return model;
    }

    @RequestMapping(value = "/noticeItem", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView noticeItem(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        model.setViewName("admin/noticeItem");
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        model.addObject("nid",paramJson.getString("nid"));
        return model;
    }
}
