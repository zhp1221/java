package com.zhanghp.generate.service;

import com.zhanghp.generate.dao.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhanghp.generate.model.vo.TestVO;
import com.zhanghp.generate.model.ro.TestRO;
import com.zhanghp.generate.model.qo.TestQO;
import java.util.*;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhanghp
 * @since 2023-06-21
 */
public interface TestService extends IService<Test> {
    boolean create(TestRO ro);

    boolean delete(Integer id);

    boolean update(TestRO ro);

    TestVO getById(Integer id);

    List<TestVO> findList(TestQO qo);

    List<TestVO> findPage(TestQO qo);
}
