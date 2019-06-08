package com.hfut.servlet;

import com.hfut.pojo.Log;
import com.hfut.service.LogService;
import com.hfut.service.impl.LogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    private LogService logService=new LogServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Log log=new Log();
        log.setAccIn(req.getParameter("accin"));
        log.setAccOut(req.getParameter("accout"));
        log.setMoney(Double.parseDouble(req.getParameter("money")));
        int index=logService.ins(log);
        if(index>0){
            resp.sendRedirect("success.jsp");
        }else{
            resp.sendRedirect("error.jsp");
        }
    }
}
