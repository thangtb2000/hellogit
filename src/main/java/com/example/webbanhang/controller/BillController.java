package com.example.webbanhang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.webbanhang.dao.UsserDao;
import com.example.webbanhang.dto.BillDTO;
import com.example.webbanhang.dto.BillItemsDTO;
import com.example.webbanhang.dto.OrderDTO;
import com.example.webbanhang.dto.OrderItemDTO;
import com.example.webbanhang.dto.ShipDetailDTO;
import com.example.webbanhang.entity.BillItemsKey;
import com.example.webbanhang.service.BillItemService;
import com.example.webbanhang.service.BillService;

@Controller
public class BillController {

	@Autowired
	BillService billService;

	@Autowired
	BillItemService billItemService;

	@Autowired
	UsserDao usserDao;

	@GetMapping("/thanhtoan/hoantat")
	public String payCart(HttpSession session, Model model, @ModelAttribute ShipDetailDTO ship) {

		

//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (session.getAttribute("cart") != null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			BillDTO billDTO = new BillDTO();
//			billDTO.setUsser(usserDao.getByUsername(userDetails.getUsername()));
			billService.add(billDTO);
			for (OrderItemDTO itemDTO : orderDTO.getItemsDTOs()) {
				BillItemsDTO billItemsDTO = new BillItemsDTO();
				billItemsDTO.setBill(billDTO);
				billItemsDTO.setCount(itemDTO.getNumber());
				billItemsDTO.setProduct(itemDTO.getProductDTO());
				billItemsDTO.setSum(itemDTO.getNumber() * itemDTO.getProductDTO().getPrice());
				billItemsDTO.setBillItemsKey(new BillItemsKey(billDTO.getId(), itemDTO.getProductDTO().getId()));
				billItemService.add(billItemsDTO);
			}

		}

		if (session.getAttribute("cart") != null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			model.addAttribute("order", orderDTO);

		}

		return "bill";
	}

}
