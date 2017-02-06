package mum.edu.waa.nycsports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.edu.waa.nycsports.service.OrderService;



@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/P1234/2")
	public String process() {
		orderService.processOrder("P1234", 2);
		return "redirect:/products";
	}
}
