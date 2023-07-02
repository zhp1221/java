package com.zhanghp.demo03_sql_mapper;

import com.zhanghp.connect.ConnectUtil;
import com.zhanghp.dao.mapper.DemoMapper;
import com.zhanghp.dao.pojo.Demo;
import com.zhanghp.utils.CommonUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 模糊查询
 *
 * @author zhanghp
 * @date 2023/6/26 21:45
 */
public class FuzzySelectMapperDemo {
    private final SqlSession SQLSESSION = ConnectUtil.getSqlSession();
    private final DemoMapper MAPPER = SQLSESSION.getMapper(DemoMapper.class);

    public void fuzzyQuery(String fuzzyName) {
        try {
            final List<Demo> demos = MAPPER.fuzzyQuery(fuzzyName);
            CommonUtil.printList(demos);
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }
}
