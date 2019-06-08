package com.hfut.service.impl;

import com.hfut.mapper.LogMapper;
import com.hfut.pojo.Log;
import com.hfut.service.LogService;
import com.hfut.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class LogServiceImpl implements LogService {
    @Override
    public int ins(Log log) {
        SqlSession session= MybatisUtil.getSession();
        LogMapper mapper=session.getMapper(LogMapper.class);
        return mapper.ins(log);
    }
}
