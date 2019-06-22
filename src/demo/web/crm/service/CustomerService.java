package demo.web.crm.service;

import java.util.List;

import demo.web.crm.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
	
}
