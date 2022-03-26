package com.example.test0315.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test0315.vo.DeptVO;

@Repository
public interface DeptDAO extends JpaRepository<DeptVO,Integer> {

}
