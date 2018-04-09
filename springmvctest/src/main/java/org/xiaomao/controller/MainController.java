package org.xiaomao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xiaomao.entity.TestBean;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @RequestMapping(path = "/clock", method = RequestMethod.GET)
    public String printHello(HttpServletRequest request, HttpServletResponse response) {
        return "clock";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String loginGet(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        if (name != null && passwd != null && name.equals("shenqius") && passwd.equals("123456")) {
            return "success";
        }
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String loginPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        if (name != null && passwd != null && name.equals("shenqius") && passwd.equals("123456")) {
            return "success";
        }
        return "login";
    }

    @RequestMapping(path = "/success", method = RequestMethod.GET)
    public String loginSuccess(HttpServletRequest request, HttpServletResponse response) {
        return "success";
    }

    @RequestMapping(path = "/main", method = RequestMethod.GET)
    public String Main(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext servletContext = request.getServletContext();
        TestBean bean = new TestBean();
        bean.setMessage("我是abc");
        servletContext.setAttribute("abc", bean);
        return "main";
    }
}
