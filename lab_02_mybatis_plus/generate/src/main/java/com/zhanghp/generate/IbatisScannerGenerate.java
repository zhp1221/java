package com.zhanghp.generate;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.*;

/**
 * <p>
 * 代码生成：输入生成
 * </p>
 * <p>
 * <a href =
 * "https://baomidou.com/pages/981406/#%E6%95%B0%E6%8D%AE%E5%BA%93%E9%85%8D%E7%BD%AE-datasourceconfig">
 * mybatis-plus generator </a>
 * </p>
 *
 * @author zhanghp
 * @date 2022-07-16 14:53
 */
public class IbatisScannerGenerate {

	public static void main(String[] args) {
		generate();
	}

	/**
	 * 代码生成
	 */
	private static void generate() {

		FastAutoGenerator.create(
				"jdbc:mysql://localhost:3306/community_db?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC",
				"root", "root")

				// 全局配置
				.globalConfig((scanner, builder) -> {
					builder.enableSwagger() // 是否启用swagger注解
							.author(scanner.apply("请输入作者名称")) // 作者名称
							.dateType(DateType.ONLY_DATE) // 时间策略
							.commentDate("yyyy-MM-dd") // 注释日期
							.outputDir(scanner.apply("请输入-》指定输出目录")) // 输出目录
							.fileOverride() // 覆盖已生成文件
							.disableOpenDir(); // 生成后禁止打开所生成的系统目录
				})

				// 包配置
				.packageConfig((scanner, builder) -> {
					builder.parent(scanner.apply("清楚如父包路径，如com.***.***")) // 父包名
							.moduleName(scanner.apply("请输入模块名称")) // 模块包名
							.entity(scanner.apply("请输入实体类包名")) // 实体类包名
							.service(scanner.apply("请输入Service层包名")) // service包名
							.serviceImpl(scanner.apply("请输入ServiceImpl包名")) // serviceImpl包名
							.mapper(scanner.apply("请输入Mapper层包名")) // mapper包名
							.controller(scanner.apply("请输入controller层包名")) // controller包名
							.other(scanner.apply("请输入自定义包名")); // 自定义包名
				})

				// 策略配置
				.strategyConfig((scanner, builder) -> {
					builder.addTablePrefix(scanner.apply("请输入所要过滤的表前缀")) // 增加过滤表前缀
							.addTableSuffix(scanner.apply("请输入所要过滤的表后缀")) // 增加过滤表后缀
							.addFieldPrefix(scanner.apply("请输入所要过滤字段前缀")) // 增加过滤字段前缀
							.addFieldSuffix(scanner.apply("请输入所要过滤字段后缀")) // 增加过滤字段后缀
							.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all"))) // 表匹配

							// Entity 策略配置
							.entityBuilder().enableLombok() // 开启lombok
							.enableChainModel() // 链式
							.enableRemoveIsPrefix() // 开启boolean类型字段移除is前缀
							.enableTableFieldAnnotation() // 开启生成实体时生成的字段注解
							.versionColumnName(scanner.apply("请输入数据库中的乐观锁字段")) // 乐观锁数据库字段
							.versionPropertyName(scanner.apply("请输入字段中的乐观锁名称")) // 乐观锁实体类名称
							.logicDeleteColumnName(scanner.apply("请输入数据库中的逻辑删除字段")) // 逻辑删除数据库中字段名
							.logicDeletePropertyName(scanner.apply("请输入数据库中的实体名称")) // 逻辑删除实体类中的字段名
							.naming(NamingStrategy.underline_to_camel) // 表名 下划线 -》 驼峰命名
							.columnNaming(NamingStrategy.underline_to_camel) // 字段名 下划线 -》
																				// 驼峰命名
							.idType(IdType.ASSIGN_ID) // 主键生成策略 雪花算法生成id
							.formatFileName("%s") // Entity 文件名称
							.addTableFills(new Column("create_time", FieldFill.INSERT)) // 表字段填充
							.addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE)) // 表字段填充

							// Controller 策略配置
							.controllerBuilder().enableRestStyle() // 开启@RestController
							.formatFileName("%sController") // Controller 文件名称

							// Service 策略配置
							.serviceBuilder().formatServiceFileName("%sService") // Service
																					// 文件名称
							.formatServiceImplFileName("%sServiceImpl") // ServiceImpl
																		// 文件名称

							// Mapper 策略配置
							.mapperBuilder().enableMapperAnnotation() // 开启@Mapper
							.enableBaseColumnList() // 启用 columnList (通用查询结果列)
							.enableBaseResultMap() // 启动resultMap
							.formatMapperFileName("%sMapper") // Mapper 文件名称
							.formatXmlFileName("%sMapper"); // Xml 文件名称
				})

				// 注入配置
				.injectionConfig((scanner, builder) -> {
					// 自定义vo，ro，qo等数据模型
					Map<String, String> customFile = new HashMap<>();
					customFile.put("VO.java", "templates/model/vo.java.vm");
					customFile.put("RO.java", "templates/model/ro.java.vm");
					customFile.put("QO.java", "templates/model/qo.java.vm");
					customFile.put("URO.java", "templates/model/uro.java.vm");
					// 自定义MapStruct
					customFile.put("Converter.java", "templates/converter/converter.java.vm");

					// 自定义配置对象
					Map<String, Object> customMap = new HashMap<>();
					customMap.put("vo", "VO");
					customMap.put("ro", "RO");
					customMap.put("qo", "QO");
					customMap.put("uro", "URO");
					builder.customFile(customFile) // 自定义模板
							.customMap(customMap); // 自定义map
				});

	}

	// 处理 all 情况
	protected static List<String> getTables(String tables) {
		return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
	}

}
