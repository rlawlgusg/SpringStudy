package com.example.test0315.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "dept")
public class DeptVO {
	@Id
	private int dno;
	private String dname;
	private String dloc;
}
