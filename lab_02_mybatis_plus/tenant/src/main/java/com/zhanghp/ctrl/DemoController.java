package com.zhanghp.ctrl;

import cn.hutool.core.collection.IterUtil;
import com.zhanghp.dao.bean.Demo;
import com.zhanghp.service.DemoService;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * mybatis - demo表 前端控制器
 * </p>
 *
 * @author zhp
 * @since 2023-11-20
 */
@RestController
@RequestMapping("/zhanghp/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("/get")
    public void getall(){
        List<Demo> all = demoService.getAll();
        if (IterUtil.isEmpty(all)) {
            return;
        }
        all.forEach(System.out::println);
    }
}
