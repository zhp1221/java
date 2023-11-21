package com.zhanghp.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhanghp
 * @date 2023/6/27 8:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp implements Serializable {

	private Integer empno;

	private String name;

	private String job;

	private Integer mgr;

	private Date hiredate;

	private Double sal;

	private Double comm;

	private Integer deptno;

	// 组合一个Dept对象作为自己的属性
	private Dept deptObject;

}
