package com.example.webbanhang.dao;

import com.example.webbanhang.entity.Bill;

public interface BillDao {

	void add(Bill b);
	Bill getbyId(Long id);
}
