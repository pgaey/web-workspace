package com.kh.subway.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.subway.common.JDBCTemplate;
import com.kh.subway.model.dao.SubwayDao;
import com.kh.subway.model.vo.Order;

public class SubwayService {

	public int insertOrder(Order order) {
		
		// Service단의 가장 큰 역할!! : Connection객체 만들기!!
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO 호출
		// => Connection객체, Controller로부터 전달받은 무언가와 함께 같이 넘겨버리기
		int result = new SubwayDao().insertOrder(conn, order);
		
		// insert, update, delete를 하면 ~ ?
		// 테이블 내용물이 바뀜 => 확정(COMMIT) / 돌아가기(ROLLBACK)
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public ArrayList<Order> selectOrderList() {
		
		// Service => Connection객체 만들기
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Order> list = new SubwayDao().selectOrderList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	
}
