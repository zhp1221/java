package com.zhanghp;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhanghp.generate.dao.mapper.TestMapper;
import com.zhanghp.generate.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhanghp
 * @date 2023/6/21 10:23
 */
@Slf4j
@SpringBootTest
public class TestLimit {
    @Resource
    private TestService testService;
    @Resource
    private TestMapper testMapper;
    @Test
    void testLimit(){
        final List<com.zhanghp.generate.dao.entity.Test> tests = testMapper.selectList(Wrappers.query());
        tests.forEach(System.out::println);

    }

    @Test
    void testLimit2(){
        final com.zhanghp.generate.dao.entity.Test tests = testMapper.selectOne(Wrappers.<com.zhanghp.generate.dao.entity.Test>query().eq("time", 5).orderByDesc("time").last("limit 1"));
        System.out.println(tests);

    }

    @Test
    void testLimit3(){
        final com.zhanghp.generate.dao.entity.Test tests = testMapper.selectOne(Wrappers.<com.zhanghp.generate.dao.entity.Test>query().orderByDesc("time"));
        System.out.println(tests);

    }

    @Test
    void testLambdaLimit(){
        final com.zhanghp.generate.dao.entity.Test tests = testMapper
                .selectOne(Wrappers.<com.zhanghp.generate.dao.entity.Test>lambdaQuery()
                        .orderByDesc(com.zhanghp.generate.dao.entity.Test::getTime).last("limit 1"));
        System.out.println(tests);

    }

    @Test
    void testLambdaOne(){
        final com.zhanghp.generate.dao.entity.Test one = testService.lambdaQuery().eq(com.zhanghp.generate.dao.entity.Test::getTime, 1).one();
        System.out.println(one);
    }

    @Test
    void testtt(){
            long milliseconds = 34170000;

            // long minutes = (milliseconds / 1000) / 60;
            long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);

            // long seconds = (milliseconds / 1000);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);

            System.out.format("%d Milliseconds = %d minutes\n", milliseconds, minutes );
            System.out.println("Or");
            System.out.format("%d Milliseconds = %d seconds", milliseconds, seconds );

    }
}
