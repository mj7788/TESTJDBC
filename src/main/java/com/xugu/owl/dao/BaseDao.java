package com.xugu.owl.dao;

import java.util.List;

public interface BaseDao<T> {
	
	int add(T t);
	
	int delete(int id);
	
	List<T> findAll();
	
	T findById(int id);
	
	int update(T t);
}
