package demo.web.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("title", "List Customers");
		return "list-customer";
	}
}
