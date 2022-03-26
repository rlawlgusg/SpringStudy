package com.example.test0315_jpa_book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test0315_jpa_book.vo.OrdersViewID;
import com.example.test0315_jpa_book.vo.View_ListOrders;
import com.example.test0315_jpa_book.vo.View_ListOrders2;
@Repository
public interface View_listOrdersDAO2 extends JpaRepository<View_ListOrders2, OrdersViewID> {

}
