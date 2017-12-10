package modellayer;
import java.util.*;

public class EmployeeContainer
{
    private static EmployeeContainer instance = null;
    private Employee employee;
    ArrayList<Employee> cont;    
    
    private EmployeeContainer()
    {
        cont = new ArrayList<>();
    }
    
    public static EmployeeContainer getInstance()
    {
        if(instance == null)
        {
            instance = new EmployeeContainer();
        }
        return instance;
    }

    public void createEmployee(Employee employee) { 
        cont.add(employee);
    }

    public void deleteEmployee(Employee employee) {   
        cont.remove(employee);
    }        
    
    public Employee loginEmployee(String login, String password)
    {
        for(int i = 0 ; i < cont.size() ; i ++ )
        {
            if(cont.get(i).getLogin().equals(login) && cont.get(i).getPassword().equals(password))
            return cont.get(i);
        }
        return null;
        
    }
    // old version of searching
    /*public ArrayList searchEmployee(String key) {
        ArrayList<Employee> matches = new ArrayList<>();

        key = key.toLowerCase();

        for (Map.Entry<String, Employee> entry : cont.entrySet()) {
            if (entry.getKey().contains(key)) {
                matches.add(entry.getValue());
            }
        }

        return matches;
    }*/
}