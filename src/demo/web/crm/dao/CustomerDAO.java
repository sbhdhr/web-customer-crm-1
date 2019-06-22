package demo.web.crm.dao;

import java.util.List;

import demo.web.crm.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getAllCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);
}
