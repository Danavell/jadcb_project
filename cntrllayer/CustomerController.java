package cntrllayer;

import java.util.*;
import modellayer.*;

public class CustomerController
{
    private CustomerContainer cont;

    public CustomerController()
    {
        cont = CustomerContainer.getInstance();
    }

    public void add(String name, String address, String email, int bankAccount, int phone)
    {
        cont.createCustomer(new Customer(name, address, email, bankAccount, phone));
    }

    public void delete(Customer customer)
    {
        cont.deleteCustomer(customer);
    }

    public void update(Customer oldC, String a, String b, String c, int d, int e)
    {
        Customer newC = new Customer(a, b, c, d, e);
        cont.deleteCustomer(oldC);
        cont.createCustomer(newC);
    }
    
    public String getSearchString(String c) {
        ArrayList<Customer> matches = cont.searchCustomer(c);
        String output = "";
        int i = 1;
        for (Customer customer : matches) {
            output += i + ".\n" + "Name: " + customer.getName() + "\n" 
                    + "Phone: " + customer.getPhone() + "\n"
                    + "Email: " + customer.getEmail() + "\n" 
                    + "===========\n";
            i++;
        }
        return output;
    }    
    
    public ArrayList<Customer> getSearchResults(String c) {
        ArrayList<Customer> matches = cont.searchCustomer(c);
        return matches; 
    }
}    

