package com.example.test0315_jpa_book.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.test0315_jpa_book.vo.Orders;

@Repository
public interface OrdersDAO extends JpaRepository<Orders, Integer> {
	//새로운 주문번호를 위한 사용자 정의 sql을 실행하는 메소드를 정의
	@Query("select nvl(max(orderid),0)+1 from Orders")	//테이블의 이름은 클래스이름과 같아야 함(대소문자 구별)
	public int getNextNo();
	
	@Modifying
	@Query(value = "insert into Orders o(o.orderid, o.custid, o.bookid, o.saleprice, o.orderdate) values(:#{#o.orderid},:#{#o.customer.custid},:#{#o.book.bookid},:#{#o.saleprice},sysdate)",nativeQuery = true)
	@Transactional
	public void insert(@Param("o") Orders o);
}
