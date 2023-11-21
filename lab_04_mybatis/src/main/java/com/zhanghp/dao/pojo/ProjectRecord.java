package com.zhanghp.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhanghp
 * @date 2023/7/2 19:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRecord implements Serializable {

	private Integer empno;

	private Integer pid;

	// 组合一个Emp对象作为属性
	private Emp empObject;

	// 鉴别器属性的使用
	private Project project;

}
