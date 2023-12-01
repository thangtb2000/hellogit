package com.example.webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webbanhang.dao.BillDao;
import com.example.webbanhang.dto.BillDTO;
import com.example.webbanhang.entity.Bill;
import com.example.webbanhang.service.BillService;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	
	@Autowired
	BillDao billDao;
	
	@Override
	public void add(BillDTO b) {
		Bill bill = new Bill();
		
		bill.setId(b.getId());
		bill.setUsser(b.getUsser());
		
		billDao.add(bill);
		b.setId(bill.getId());
	}

	@Override
	public BillDTO getbyId(Long id) {
		Bill b = billDao.getbyId(id);
		
		BillDTO billDTO = new BillDTO();
		
		billDTO.setId(b.getId());
		billDTO.setUsser(b.getUsser());
		
		
		return billDTO;
	}
	
}
