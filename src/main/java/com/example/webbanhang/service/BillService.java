package com.example.webbanhang.service;

import com.example.webbanhang.dto.BillDTO;

public interface BillService {
	void add(BillDTO b);
	BillDTO getbyId(Long id);
}
