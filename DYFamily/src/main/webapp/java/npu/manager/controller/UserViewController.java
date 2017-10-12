package npu.manager.controller;

import com.alibaba.fastjson.JSONObject;
import npu.manager.global.GlobalFun;
import npu.manager.global.GlobalVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by  on .
 *
 * @autor ZLei
 * @date 2017/9/27
 * @todo
 */
@Controller
@RequestMapping("/userView")
public class UserViewController {
    /**
     * function userLogin
     * @author ZLei
     * @date 2017/9/27
     * @return 
     * @todo  用户登录页面
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userLogin(){
        ModelAndView model = new ModelAndView();
        model.setViewName("user/Login");
        return model;
    }

    @RequestMapping(value = "/usermsg", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView usermsg(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        model.setViewName("user/usermsg");
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        model.addObject("uid",paramJson.getString("uid"));
        return model;
    }

    @RequestMapping(value = "/userindex", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userIndex(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();

        if(session.getAttribute("login_con") == null || !session.getAttribute("login_con").equals("1")){
            model.setViewName("user/Login");
            return model;
        }

        model.setViewName("user/index");
        return model;
    }


    @RequestMapping(value = "/noticeList", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView noticeList(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        model.setViewName("user/noticeList");
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        model.addObject("pageNum",paramJson.getString("pageNum"));
        return model;
    }

    @RequestMapping(value = "/noticeItem", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView noticeItem(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        model.setViewName("user/noticeItem");
        JSONObject paramJson = GlobalFun.getParamFromRequest(request);
        model.addObject("nid",paramJson.getString("nid"));
        return model;
    }

    @RequestMapping(value = "/advice", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView advice(){
        ModelAndView model = new ModelAndView();
        model.setViewName("user/advice");
        return model;
    }


    /**
     * function userRegister
     * @author Mike
     * @date 2017/9/29
     * @return
     * @todo  用户注册界面
     */
    @RequestMapping(value = "/userRegister", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userRegister(){
        ModelAndView model = new ModelAndView();
        model.setViewName("user/Register");
        return model;
    }

}
