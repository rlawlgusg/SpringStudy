package com.example.test0315_jpa_book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test0315_jpa_book.vo.View_ListOrders;
@Repository
public interface View_listOrdersDAO extends JpaRepository<View_ListOrders, Integer> {

}
