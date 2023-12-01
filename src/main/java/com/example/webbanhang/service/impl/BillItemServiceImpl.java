package com.example.webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webbanhang.dao.BillDao;
import com.example.webbanhang.dao.BillItemsDao;
import com.example.webbanhang.dao.ProductDao;
import com.example.webbanhang.dto.BillItemsDTO;
import com.example.webbanhang.entity.BillItems;
import com.example.webbanhang.service.BillItemService;

@Service
@Transactional
public class BillItemServiceImpl implements BillItemService {

	
	@Autowired
	BillItemsDao biItemsDao;
	
	@Autowired
	BillDao billDao;
	
	@Autowired
	ProductDao productDao;

	@Override
	public void add(BillItemsDTO b) {
		
		BillItems billItems = new BillItems();
		
		billItems.setCount(b.getCount());
		billItems.setBill(billDao.getbyId(b.getBill().getId()));
		billItems.setProduct(productDao.getById(b.getProduct().getId()));
		billItems.setSum(b.getSum());
		billItems.setBillItemsKey(b.getBillItemsKey());
		
		biItemsDao.add(billItems);
		
	}
	
	
	
}
