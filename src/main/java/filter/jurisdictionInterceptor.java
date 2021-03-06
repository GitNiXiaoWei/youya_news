package filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class jurisdictionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //1.查看session中有没有用户信息
        HttpSession session = httpServletRequest.getSession();
        //2.如果没有？如果有?
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        if(userInfo==null){
            httpServletResponse.sendRedirect("/youya_news/login.html");
            return false;
        }else{
            String jurisdiction = httpServletRequest.getRequestURI().split("/")[2];
            if (jurisdiction.equals("usermanage")&&userInfo.getRoleid()==1){
                return true;
            }else if (jurisdiction.equals("administrator")&&userInfo.getRoleid()==2){
                return true;
            }else if (jurisdiction.equals("author")&&userInfo.getRoleid()==3){
                return true;
            }
            httpServletResponse.sendRedirect("/youya_news/login.html");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
