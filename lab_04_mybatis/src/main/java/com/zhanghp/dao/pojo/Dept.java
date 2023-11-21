package com.zhanghp.dao.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanghp
 * @date 2023/6/28 9:25
 */
@Data
@ToString
@NoArgsConstructor
public class Dept implements Serializable {

	private Integer deptno;

	private String dname;

	private String loc;

	// 组合一个Emp的List集合作为属性
	private List<Emp> empList;

	public Dept(Integer deptno, String dname, List<Emp> empList) {
		this.deptno = deptno;
		this.dname = dname;
		this.empList = empList;
	}

	public Dept(Integer deptno, String dname, String loc) {
		this.deptno = deptno;
		this.loc = loc;
		this.dname = dname;
	}

}
