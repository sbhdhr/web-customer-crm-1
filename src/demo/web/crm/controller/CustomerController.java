package demo.web.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.web.crm.entity.Customer;
import demo.web.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("title", "List Customers");

		// get customers from dao
		List<Customer> customers = customerService.getAllCustomers();

		// add the customers to model
		model.addAttribute("customers", customers);

		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("title", "Customer Form - Add Customer");
		model.addAttribute("customer",new Customer());
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		// Save the customer using our customer service 
		customerService.saveCustomer(customer);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		model.addAttribute("title", "Customer Form - Update Customer");
		
		// get the customer from the database 
		Customer customer = customerService.getCustomer(id);
		
		// set customer as a model attribute to pre-populate the form 
		model.addAttribute("customer", customer);
		
		// send over to our form 			
		return "customer-form";
	}
}