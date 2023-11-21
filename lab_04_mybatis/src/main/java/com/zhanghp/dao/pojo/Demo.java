package com.zhanghp.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * demo表 - 实体类
 *
 * @author zhanghp
 * @date 2023/6/25 14:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demo implements Serializable {

	private Integer id;

	private String name;

	private Integer age;

}
