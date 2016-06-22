package com.test.poi.bean.service;

import java.util.List;

import com.test.poi.bean.Employee;
import com.test.poi.bean.dao.POIDao;
import com.test.poi.bean.dao.POIDaoImpl;

public class POIServiceImpl implements POIService {

	@Override
	public List<Employee> getEmployees() {
		POIDao dao = new POIDaoImpl();
		
		return dao.getEmployees();
	}

}
