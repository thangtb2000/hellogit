package com.example.webbanhang.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webbanhang.dto.OrderDTO;
import com.example.webbanhang.dto.OrderItemDTO;
import com.example.webbanhang.dto.ProductDTO;
import com.example.webbanhang.service.ProductService;

@Controller
public class OrderControllerBE {
	@Autowired
	private ProductService productService;

	@GetMapping("/giohang")
	public String view(@RequestParam(name = "pID") Long id, Model model, HttpSession session) {

		ProductDTO p = productService.getById(id);

		model.addAttribute("p", productService.getById(id));

		if (session.getAttribute("cart") == null) {

			OrderDTO orderDTO = new OrderDTO();
			OrderItemDTO orderItemDTO = new OrderItemDTO();

			orderItemDTO.setNumber(1);
			orderItemDTO.setProductDTO(p);

			List<OrderItemDTO> orderItemDTOs = new ArrayList<OrderItemDTO>();
			orderItemDTOs.add(orderItemDTO);

			orderDTO.setItemsDTOs(orderItemDTOs);

			session.setAttribute("cart", orderDTO);
			model.addAttribute("order", orderDTO);

		} else {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");

			List<OrderItemDTO> orderItemDTOs = orderDTO.getItemsDTOs();

			boolean flag = false;

			for (OrderItemDTO orderItemDTO : orderItemDTOs) {
				if (orderItemDTO.getProductDTO().getId() == p.getId()) {
					orderItemDTO.setNumber(orderItemDTO.getNumber() + 1);

					flag = true;

				}
			}
			if (!flag) {

				OrderItemDTO orderItemDTO = new OrderItemDTO();

				orderItemDTO.setNumber(1);
				orderItemDTO.setProductDTO(p);

				orderItemDTOs.add(orderItemDTO);

			}

			session.setAttribute("cart", orderDTO);
			model.addAttribute("order", orderDTO);

		}

		return "cart";
	}

	@PostMapping("/update/giohang")
	public String update(Model model, HttpSession session, @RequestParam(name = "number") int number,
			@RequestParam(name = "pID") Long id) {

		ProductDTO p = productService.getById(id);

		model.addAttribute("p", productService.getById(id));

		OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");

		List<OrderItemDTO> orderItemDTOs = orderDTO.getItemsDTOs();

		for (OrderItemDTO o : orderItemDTOs) {

			if (o.getProductDTO().getId() == p.getId()) {
				o.setNumber(number);
			}

		}
		System.out.println(p.getId() + "+++++++++++++++++++");
		return "redirect:/xem-gio-hang";
	}

	@GetMapping("/xem-gio-hang")
	public String viewCart(HttpSession session, Model model) {
		model.addAttribute("list", productService.getList());

		if (session.getAttribute("cart") != null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			model.addAttribute("order", orderDTO);

		}

		return "cart";
	}
	
	@GetMapping("/thanhtoan")
	public String payCart(HttpSession session, Model model) {
		
		
		model.addAttribute("list", productService.getList());
		
		if (session.getAttribute("cart") != null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			model.addAttribute("order", orderDTO);

		}
		
		

		return "payCart";
	}

	@GetMapping("/xoa-gio-hang")
	public String deleteCart(Model model, HttpSession session, @RequestParam(name = "pID") int productId) {

		if (session.getAttribute("cart") != null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");

			List<OrderItemDTO> orderItemDTOs = orderDTO.getItemsDTOs();

			Iterator<OrderItemDTO> iterator = orderItemDTOs.iterator();

			while (iterator.hasNext()) {
				if (iterator.next().getProductDTO().getId() == productId) {
					iterator.remove();
				}
			}
			if (orderItemDTOs.isEmpty()) {
				session.removeAttribute("cart");
			}

			model.addAttribute("order", orderDTO);
		}

		return "cart";
	}

}
