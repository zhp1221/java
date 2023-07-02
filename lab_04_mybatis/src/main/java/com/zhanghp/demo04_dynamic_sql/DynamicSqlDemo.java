package com.zhanghp.demo04_dynamic_sql;

import com.zhanghp.connect.ConnectUtil;
import com.zhanghp.dao.mapper.DemoMapper;
import com.zhanghp.dao.pojo.Demo;
import com.zhanghp.utils.CommonUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Arrays;

/**
 * @author zhanghp
 * @date 2023/6/27 18:54
 */
public class DynamicSqlDemo {
    private final SqlSession SQLSESSION = ConnectUtil.getSqlSession();
    private final DemoMapper MAPPER = SQLSESSION.getMapper(DemoMapper.class);

    public void dynamicIf() {
        try {
            // test1 select * from demo where 1=1 and name = ?
            CommonUtil.printList(MAPPER.dynamicIf("小胡"));
            // test2 select * from demo where 1=1
            CommonUtil.printList(MAPPER.dynamicIf(null));
            // test3 <if test = "name != null and name != ''">
            // select * from demo where 1=1
            CommonUtil.printList(MAPPER.dynamicIf(""));
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    public void dynamicIfByDemo() {
        try {
            // select * from demo where 1=1 and name = ?
            CommonUtil.printList(MAPPER.dynamicIfByDemo(new Demo(null, "小胡", null)));
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    public void dynamicIfFuzzy() {
        try {
            // select * from demo where 1=1 and name like concat('%','小','%')
            CommonUtil.printList(MAPPER.dynamicIfFuzzy("小"));
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    public void dynamicChooseWhenAndOtherwise() {
        try {
            // test1 select * from demo where 1=1 and age = ?
            CommonUtil.printList(MAPPER.dynamicChooseWhenAndOtherwise(new Demo(null, null, 10), ""));
            // test2 select * from demo where 1=1 and name = ?
            CommonUtil.printList(MAPPER.dynamicChooseWhenAndOtherwise(new Demo(null, null, null), "小胡"));
            // test3 select * from demo where 1=1 and name like concat('%','小','%')
            CommonUtil.printList(MAPPER.dynamicChooseWhenAndOtherwise(new Demo(null, null, null), ""));
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    public void dynamicWhere() {
        try {
            // select * from demo
            CommonUtil.printList(MAPPER.dynamicWhere(""));
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    public void dynamicTrim() {
        try {
            // select * from demo where 1=1
            CommonUtil.printList(MAPPER.dynamicTrim());
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    public void dynamicSet() {
        try {
            // test1 update demo SET age = ? where id = ?
            System.out.println(MAPPER.dynamicSet(11, 2));
            //test2 报错：age=null 所以无法更新  update demo where id = 2
            System.out.println(MAPPER.dynamicSet(null, 2));
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    public void dynamicForeach() {
        try {
            // select * from demo where id in ( ? , ? , ? )
            CommonUtil.printList(MAPPER.dynamicForeach(Arrays.asList(1, 2, 3)));
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    public void dynamicSql() {
        try {
            // select name, age from demo
            CommonUtil.printList(MAPPER.dynamicSql());
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }

    public void dynamicBind() {
        try {
            // select * from demo where name like ?
            CommonUtil.printList(MAPPER.dynamicBind(new Demo(null, "小", null)));
        } finally {
            ConnectUtil.release(SQLSESSION);
        }
    }
}
