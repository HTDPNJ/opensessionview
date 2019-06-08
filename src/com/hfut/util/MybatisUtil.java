package com.hfut.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession>tl=new ThreadLocal<>();
    static {
        try{
            InputStream is=Resources.getResourceAsStream("mybatis.xml");
            factory=new SqlSessionFactoryBuilder().build(is);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /*获取sqlSession的方法*/
    public static SqlSession getSession(){
        SqlSession session=tl.get();
        if(session==null){
            session=factory.openSession();
            tl.set(session);
        }
        return tl.get();
    }
    /*关闭session*/
    public static void clostSession(){
        SqlSession session=tl.get();
        if(session!=null){
            session.close();
        }
        tl.set(null);
    }
}
