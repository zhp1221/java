package com.zhanghp;

import com.zhanghp.dao.bean.Demo;
import com.zhanghp.service.DemoService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @since 2023/11/21 20:45
 */
public class TenantClearTest extends AppTest{
    @Resource
    private DemoService demoService;

    @Test
    public void add(){
        demoService.add(Demo.builder().age(18).name("朵莉亚").build());
    }
}
