package com.hfut.filter;

import com.hfut.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.InputStream;

@WebFilter("/*")
public class OpenSessionInview  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

       SqlSession session= MybatisUtil.getSession();

       try{
           filterChain.doFilter(servletRequest,servletResponse);
           session.commit();
       }catch (Exception e){
           session.rollback();
           e.printStackTrace();
       }finally {
           MybatisUtil.clostSession();
       }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
