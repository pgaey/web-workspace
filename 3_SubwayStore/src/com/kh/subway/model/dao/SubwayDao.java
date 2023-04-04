package com.kh.subway.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SubwayDao {

	// DAO단에서 항상 해야할 것
	// mapper 파일 연결
	// => 기본생성자
	
	private Properties prop = new Properties();
	
	public SubwayDao() {
		// mapper 파일의 경로 담기
		String fileName = SubwayDao.class.getResource("/sql/subway/subway-mapper.xml").getPath();
		
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
