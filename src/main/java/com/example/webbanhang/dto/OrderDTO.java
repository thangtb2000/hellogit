package com.example.webbanhang.dto;

import java.util.List;

public class OrderDTO {

	private List<OrderItemDTO> itemsDTOs;

	

	public List<OrderItemDTO> getItemsDTOs() {
		return itemsDTOs;
	}



	public void setItemsDTOs(List<OrderItemDTO> itemsDTOs) {
		this.itemsDTOs = itemsDTOs;
	}



	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

}
