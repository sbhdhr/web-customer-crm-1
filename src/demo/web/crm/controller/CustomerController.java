package demo.web.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.web.crm.dao.CustomerDAO;
import demo.web.crm.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("title", "List Customers");

		// get customers from dao
		List<Customer> customers = customerDAO.getAllCustomers();

		// add the customers to model
		model.addAttribute("customers", customers);

		return "list-customer";
	}
}
