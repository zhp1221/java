package com.zhanghp.ctrl;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.lang.Console;
import com.zhanghp.config.tenant.TenantContextHolder;
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
        List<Demo> all = demoService.list();
        if (IterUtil.isEmpty(all)) {
            return;
        }
        all.forEach(System.out::println);
    }

    @GetMapping("/get2")
    public void getall2(){
        TenantContextHolder.setTenantSkip();
        List<Demo> all = demoService.list();
        if (IterUtil.isEmpty(all)) {
            return;
        }
        all.forEach(System.out::println);
    }

    @GetMapping("/tenant-clear")
    public void tenantClear(){
        Console.log("执行a方法");
        demoService.a();
        Console.log("执行b方法");
        demoService.b();
    }

    @GetMapping("/tenant-clear2")
    public void tenantClear2(){
        Console.log("执行c方法");
        demoService.a();
        Console.log("执行b方法");
        demoService.b();
    }
}
