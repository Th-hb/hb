package cn.hb.restful.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
   //在登录前进行拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       Object loginUser =request.getSession().getAttribute("loginUser");
       if(loginUser==null){
           //转发到登录页面
           request.setAttribute("msg","没有权限,请先登录");
           request.getRequestDispatcher("/index.html").forward(request,response);
        return  false;
       }else{
          return true;
       }
    }
}
