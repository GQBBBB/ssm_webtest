package com.gqb.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MethodTimeInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(MethodTimeInterceptor.class);

    //前置
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        request.setAttribute("start", start);
        LOGGER.info(request.getRequestURI() + "访问");
        return true;//返回true才会去找下一个拦截器
    }

    //后置
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long start = (Long) request.getAttribute("start");
        long cost = System.currentTimeMillis() - start;
        if(cost > 1000){
            LOGGER.warn("方法耗时严重: " + cost);
        }else{
            LOGGER.info("方法耗时: " + cost);
        }
    }

    //完成
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
