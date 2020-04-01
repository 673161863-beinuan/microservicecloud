package com.atguigu.springcloud.entitys;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
	
	private Long deptno;     //主键编号
	private String dname;    //部门名称
	private String db_source;//这个部门连接的数据库，自己独立的数据库

}
