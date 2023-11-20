package com.zhanghp.gen;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.Collections;

/**
 * @author zhanghp
 * @since 2023/11/20 14:10
 */
public class Generate {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir") +  "/lab_02_mybatis_plus/tenant";
        FastAutoGenerator.create(
                "jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                "root",
                "zhp.1221"
        ).globalConfig(it -> {
            it
                    .author("zhp")
                    .fileOverride()
                    .disableOpenDir()
                    .outputDir(property + "/src/main/java");
        }).packageConfig(it ->{
            it
                    .parent("com")
                    .moduleName("zhanghp")
                    .controller("ctrl")
                    .entity("dao.bean")
                    .service("service")
                    .serviceImpl("service.impl")
                    .mapper("dao.mapper")
                    .xml("mapper.xml")
                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, property + "/src/main/resources/mapper/"));
        }).strategyConfig(it -> {
            it
                    .addInclude("demo")

                    .entityBuilder()
                    .enableLombok()
                    .naming(NamingStrategy.underline_to_camel)
                    .columnNaming(NamingStrategy.underline_to_camel)
                    .controllerBuilder()

                    // Controller 策略配置
                    .controllerBuilder()
                    .enableRestStyle() // 开启@RestController
                    .formatFileName("%sController") // Controller 文件名称

                    // Service 策略配置
                    .serviceBuilder()
                    .formatServiceFileName("%sService") // Service 文件名称
                    .formatServiceImplFileName("%sServiceImpl") // ServiceImpl 文件名称

                    // Mapper 策略配置
                    .mapperBuilder()
                    .enableMapperAnnotation() // 开启@Mapper
                    .enableBaseColumnList() // 启用 columnList (通用查询结果列)
                    .enableBaseResultMap() // 启动resultMap
                    .formatMapperFileName("%sMapper") // Mapper 文件名称
                    .formatXmlFileName("%sMapper"); // Xml 文件名称

        })
                .execute();
    }
}
