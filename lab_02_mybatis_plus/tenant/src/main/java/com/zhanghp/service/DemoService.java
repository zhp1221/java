package com.zhanghp.service;

import com.zhanghp.dao.bean.Demo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * mybatis - demo表 服务类
 * </p>
 *
 * @author zhp
 * @since 2023-11-20
 */
public interface DemoService extends IService<Demo> {
    int add(Demo demo);

}
