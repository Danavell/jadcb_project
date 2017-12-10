package modellayer;
import java.util.*;

public class CustomerContainer
{
    private static CustomerContainer instance = null;
    private Customer customer;
    HashMap<String, Customer> cont;
    int index;
    
    private CustomerContainer()
    {
        cont = new HashMap<>();
        index = 0;
    }
    
    public static CustomerContainer getInstance()
    {
        if(instance == null)
        {
            instance = new CustomerContainer();
        }
        return instance;
    }
    
    private String generateKey(Customer c) {
        String key = c.getName() + "|" + c.getPhone() + "|" + c.getEmail();
        return key.toLowerCase();
    }
    
    public void createCustomer(Customer customer) { 
        cont.put(generateKey(customer), customer);
        index++;
    }
    
    public void deleteCustomer(Customer customer) {
        cont.remove(generateKey(customer));
    }        
    
    public ArrayList searchCustomer(String key) {
        ArrayList<Customer> matches = new ArrayList<>();

        key = key.toLowerCase();

        for (Map.Entry<String, Customer>entry : cont.entrySet())
        {
            if (entry.getKey().contains(key))
            {
                matches.add(entry.getValue());
            }
        }
        return matches;
    } 
}
